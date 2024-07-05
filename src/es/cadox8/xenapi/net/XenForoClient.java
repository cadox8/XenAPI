/*
 * Copyright (c) 2021-2024
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import de.jupf.staticlog.Log;
import de.jupf.staticlog.format.LogFormat;
import es.cadox8.xenapi.api.commons.Errors;
import es.cadox8.xenapi.exceptions.*;
import es.cadox8.xenapi.utils.StatusCode;
import es.cadox8.xenapi.utils.UrlExpander;
import es.cadox8.xenapi.utils.Utils;
import lombok.NonNull;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.net.URIBuilder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static de.jupf.staticlog.Log.FormatOperations.*;

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

    public XenForoClient(String token, String user, @NonNull final HttpClient httpClient) {
        this.token = token;
        this.user = user;
        this.httpClient = httpClient;
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();

        final LogFormat format = Log.newFormat();
        format.line(date("yyyy-MM-dd HH:mm:ss.SSS"), space(1), text("["), level(), text("]"), space(2), message());

        Log.info("Started client! Version: 2.4.0-SNAPSHOT", "XenforoClient");
    }

    public <T> T get(String url, Class<T> responseType, final NameValuePair... query) {
        return this.get(url, responseType, "", query);
    }

    public <T> T get(String url, Class<T> responseType, String params) {
        return this.get(url, responseType, params, new NameValuePair[]{});
    }

    public <T> T get(String url, Class<T> responseType, String params, final NameValuePair... query) {
        Log.debug("--> Sending to " + url, "XenForoClient");
        final HttpGet httpGet;
        try {
            httpGet = new HttpGet(new URIBuilder(UrlExpander.replaceParam(url, params)).addParameters(Arrays.asList(query)).build());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return this.getEntityAndReleaseConnection(responseType, httpGet);
    }

    public <T> T postForObject(String url, Object body, Class<T> responseType) {
        return this.postForObject(url, body, responseType, "");
    }

    public <T> T postForObject(String url, Class<T> responseType, String params) {
        return this.postForObject(url, "", responseType, params);
    }

    public <T> T postForObject(String url, Object body, Class<T> responseType, String params) {
        final HttpPost httpPost = new HttpPost(UrlExpander.replaceParam(url, params));

        try {
            Log.debug("--> Sending to " + url + " with body: " + body, "XenForoClient");

            final HttpEntity entity = new StringEntity(this.gson.toJson(body), ContentType.APPLICATION_FORM_URLENCODED);
            httpPost.setEntity(entity);
            return this.getEntityAndReleaseConnection(responseType, httpPost);
        } catch (JsonSyntaxException e) {
            // TODO : custom exception
            throw new RuntimeException(e);
        }
    }

    public <T> T postFileForObject(String url, File file, Object body, Class<T> objectClass, String fileName) {
        final HttpPost httpPost = new HttpPost(UrlExpander.replaceParam(url, ""));
        final HttpEntity entity = MultipartEntityBuilder.create().addTextBody("", this.gson.toJson(body)).addBinaryBody(fileName, file).build();
        httpPost.setEntity(entity);
        return this.getEntityAndReleaseConnection(objectClass, httpPost);
    }

    public <T> T postFileForObject(String url, File file, Class<T> objectClass, String params, String fileName) {
        final HttpPost httpPost = new HttpPost(UrlExpander.replaceParam(url, params));
        final HttpEntity entity = MultipartEntityBuilder.create().addBinaryBody(fileName, file).build();
        httpPost.setEntity(entity);
        return getEntityAndReleaseConnection(objectClass, httpPost);
    }

    public <T> T putForObject(String url, Object body, Class<T> responseType, String params) {
        final HttpPut put = new HttpPut(UrlExpander.replaceParam(url, params));
        try {
            final HttpEntity entity = new StringEntity(this.gson.toJson(body), ContentType.MULTIPART_FORM_DATA);
            put.setEntity(entity);
            return getEntityAndReleaseConnection(responseType, put);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T delete(String url, Class<T> responseType, final NameValuePair... query) {
        return this.get(url, responseType, "", query);
    }

    public <T> T delete(String url, Class<T> responseType, String params) {
        return this.get(url, responseType, params, new NameValuePair[]{});
    }

    public <T> T delete(String url, Class<T> responseType, String params, final NameValuePair... query) {
        final HttpDelete delete;
        try {
            delete = new HttpDelete(new URIBuilder(UrlExpander.replaceParam(url, params)).addParameters(Arrays.asList(query)).build());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return this.getEntityAndReleaseConnection(responseType, delete);
    }

    private <T> T getEntityAndReleaseConnection(Class<T> objectClass, HttpUriRequest httpRequest) {
        try {
            httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
            httpRequest.setHeader("XF-Api-User", this.user);
            httpRequest.setHeader("XF-Api-Key", this.token);
            final ClassicHttpResponse httpResponse = this.httpClient.executeOpen(null, httpRequest, null);

            final HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity == null) {
                throw new XenForoHttpException("Http entity returned by XenForo is null");
            }

            String body = Utils.toString(httpEntity.getContent());
            final StatusLine status = new StatusLine(httpResponse);

            if (status.getStatusCode() == StatusCode.BadRequest.getStatus()) {
                throw new XenForoBadRequestException(body);
            }
            if (status.getStatusCode() == StatusCode.NotAuthorized.getStatus()) {
                throw new NotAuthorizedException(body);
            }
            if (status.getStatusCode() == StatusCode.ResourceNotFound.getStatus()) {
                throw new NotFoundException("Resource not found: " + httpRequest.getRequestUri());
            }

            try {
                Log.debug("<-- Received body: " + body, "XenForoClient");
                return this.gson.fromJson(body, objectClass);
            } catch (JsonSyntaxException e) {
                final Errors err = this.gson.fromJson(body, Errors.class);

                Log.error("Retrieved the following errors: ", "XenForoClient");
                err.getErrors().forEach(er -> {
                    Log.error(er.getCode() + " - " + er.getMessage(), "XenForoClient");
                });
            }
        } catch (XenForoBaseException e) {
            Log.error("", "XenForoClient", e);
        } catch (IOException e) {
            throw new XenForoHttpException(e);
        }

        httpRequest.abort();
        return this.defaultError(objectClass);
    }

    private <T> T defaultError(Class<T> baseClass) {
        try {
            if (baseClass.equals(Boolean.class))
                return (T) Boolean.FALSE;
            final Constructor<T> constructor = baseClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }
}
