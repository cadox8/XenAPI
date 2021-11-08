/*
 * Copyright (c) 2021.
 *
 * This file is part of XenAPI <https://github.com/cadox8/XenAPI>.
 *
 * XenAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XenAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you have any question feel free to ask at <https://cadox8.es> or <mailto:cadox8@gmail.com>
 */

package es.cadox8.xenapi.net;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import es.cadox8.xenapi.api.Me;
import es.cadox8.xenapi.exceptions.NotAuthorizedException;
import es.cadox8.xenapi.exceptions.NotFoundException;
import es.cadox8.xenapi.exceptions.XenForoBadRequestException;
import es.cadox8.xenapi.exceptions.XenForoHttpException;
import es.cadox8.xenapi.utils.UrlExpander;
import es.cadox8.xenapi.utils.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.Objects;

public class XenForoClient {

    private final HttpClient httpClient;
    private final Gson gson;

    private final String token;
    private final String user;

    public XenForoClient(String token) {
        this(token, "");
    }
    public XenForoClient(String token, String user) {
        this(token, user, HttpClientBuilder.create().build());
    }

    public XenForoClient(String token, String user, HttpClient httpClient) {
        this.token = token;
        this.user = user;
        this.httpClient = Objects.requireNonNull(httpClient);
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    }

    public <T> T get(String url, Class<T> responseType, String... params) {
        final HttpGet httpGet = new HttpGet(UrlExpander.expandUrl(url, params));
        return getEntityAndReleaseConnection(responseType, httpGet);
    }

    public <T> T postForObject(String url, Object body, Class<T> responseType, String... params) {
        final HttpPost httpPost = new HttpPost(UrlExpander.expandUrl(url, params));

        try {
            final HttpEntity entity = new StringEntity(this.gson.toJson(body), ContentType.APPLICATION_FORM_URLENCODED);
            httpPost.setEntity(entity);

            return getEntityAndReleaseConnection(responseType, httpPost);
        } catch (JsonSyntaxException e) {
            // TODO : custom exception
            throw new RuntimeException(e);
        }
    }

    public <T> T postFileForObject(String url, File file, Class<T> objectClass, String... params) {
        final HttpPost httpPost = new HttpPost(UrlExpander.expandUrl(url, params));
        final HttpEntity entity = MultipartEntityBuilder.create().addPart("file", new FileBody(file)).addPart("filename", new StringBody(file.getName(), ContentType.TEXT_PLAIN)).build();
        httpPost.setEntity(entity);
        return getEntityAndReleaseConnection(objectClass, httpPost);
    }

    public <T> T putForObject(String url, Object body, Class<T> responseType, String... params) {
        final HttpPut put = new HttpPut(UrlExpander.expandUrl(url, params));
        try {
            final HttpEntity entity = new StringEntity(this.gson.toJson(body), ContentType.MULTIPART_FORM_DATA);
            put.setEntity(entity);
            return getEntityAndReleaseConnection(responseType, put);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T delete(String url, Class<T> responseType, String... params) {
        final HttpDelete delete = new HttpDelete(UrlExpander.expandUrl(url, params));
        return getEntityAndReleaseConnection(responseType, delete);
    }

    private <T> T getEntityAndReleaseConnection(Class<T> objectClass, HttpRequestBase httpRequest) {
        try {
            httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
            httpRequest.setHeader("XF-Api-User", this.user);
            httpRequest.setHeader("XF-Api-Key", this.token);
            final HttpResponse httpResponse = this.httpClient.execute(httpRequest);

            final HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                String body = Utils.toString(httpEntity.getContent());
                if (httpResponse.getStatusLine().getStatusCode() == 400) {
                    throw new XenForoBadRequestException(body);
                }
                if (httpResponse.getStatusLine().getStatusCode() == 401) {
                    throw new NotAuthorizedException(body);
                }
                if (httpResponse.getStatusLine().getStatusCode() == 404) {
                    throw new NotFoundException("Resource not found: " + httpRequest.getURI());
                }
                try {
                    final StringBuilder sb = new StringBuilder(body.substring(body.indexOf(":") + 1));
                    sb.deleteCharAt(sb.length() - 1);
                    body = sb.toString();
                    System.out.println(body);
                    return this.gson.fromJson(body, objectClass);
                } catch (JsonSyntaxException e) {
                    throw new XenForoHttpException("Cannot parse XenForo response. Expected to get a json string, but got: " + body);
                }
            } else {
                throw new XenForoHttpException("Http entity returned by XenForo is null");
            }
        } catch (XenForoHttpException e) {
            throw e;
        } catch (IOException e) {
            throw new XenForoHttpException(e);
        } finally {
            httpRequest.releaseConnection();
        }
    }
}
