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
import es.cadox8.xenapi.utils.Utils;
import es.cadox8.xenapi.utils.XenAPIExperimental;
import lombok.Getter;
import lombok.Setter;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.net.URIBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static de.jupf.staticlog.Log.FormatOperations.*;

public class XenForoClient {

    private final HttpClient httpClient;
    private final Gson gson;

    private final String token;
    private final int user;

    @Setter
    @Getter
    @XenAPIExperimental(XenAPIExperimental.Status.TO_BE_DONE)
    private boolean enableEnhancementAPI;

    public XenForoClient(String token) {
        this(token, -1);
    }

    public XenForoClient(String token, int user) {
        this.token = token;
        this.user = user;
        this.httpClient = HttpClients.createDefault();
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        this.enableEnhancementAPI = false;

        final LogFormat format = Log.newFormat();
        format.line(date("yyyy-MM-dd HH:mm:ss.SSS"), text(" | "), tag(), space(1), text("["), level(), text("]"), space(2), message());
    }

    /**
     * Send a GET request to the server
     *
     * @param url          The URL of the forum
     * @param responseType The ResponseType
     * @param params       Params required for get (defined in the Query class)
     * @param <T>          The ResponseType
     * @return The ResponseType
     */
    public <T extends ApiResponse> Response<T, Errors> get(String url, Class<T> responseType, final List<NameValuePair> params) {
        return this.get(url, responseType, "", params);
    }

    /**
     * Send a GET request to the server
     *
     * @param url          The URL of the forum
     * @param responseType The ResponseType
     * @param query        The query for the get (id)
     * @param <T>          The ResponseType
     * @return The ResponseType
     */
    public <T extends ApiResponse> Response<T, Errors> get(String url, Class<T> responseType, Object query) {
        return this.get(url, responseType, query, new ArrayList<>());
    }

    /**
     * Send a GET request to the server
     *
     * @param url          The URL of the forum
     * @param responseType The ResponseType
     * @param query        The query for the get (id)
     * @param params       Params required for get (defined in the Query class)
     * @param <T>          The ResponseType
     * @return The ResponseType
     */
    public <T extends ApiResponse> Response<T, Errors> get(String url, Class<T> responseType, Object query, final List<NameValuePair> params) {
        final String finalURL = Utils.replaceQuery(url, query);
        Log.debug("--> GET Sending to " + finalURL, "XenForoClient");
        final HttpGet httpGet;
        try {
            httpGet = new HttpGet(new URIBuilder(finalURL).addParameters(params).build());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return this.send(responseType, httpGet);
    }

    public <T extends ApiResponse> Response<T, Errors> post(String url, Class<T> responseType, Object query, final List<NameValuePair> params) {
        final String finalURL = Utils.replaceQuery(url, query);
        Log.debug("--> POST Sending to " + finalURL + " with params: " + params, "XenForoClient");
        final HttpPost httpPost;

        try {
            httpPost = new HttpPost(new URIBuilder(finalURL).build());
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
            return this.send(responseType, httpPost);
        } catch (JsonSyntaxException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends ApiResponse> Response<T, Errors> postFile(String url, Class<T> responseType, Object query, final List<NameValuePair> params, File file) {
        final String finalURL = Utils.replaceQuery(url, query);
        Log.debug("--> POST Sending to " + url + " with params: " + params, "XenForoClient");
        final HttpPost httpPost;

        try {
            final MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("avatar", file);
            params.forEach(p -> builder.addParameter(new BasicNameValuePair(p.getName(), p.getValue())));

            httpPost = new HttpPost(new URIBuilder(finalURL).build());
            httpPost.setEntity(builder.build());
            return this.send(responseType, httpPost);
        } catch (JsonSyntaxException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends ApiResponse> Response<T, Errors> put(String url, Object body, Class<T> responseType, Object query) {
        final HttpPut put = new HttpPut(Utils.replaceQuery(url, query));
        try {
            final HttpEntity entity = new StringEntity(this.gson.toJson(body), ContentType.MULTIPART_FORM_DATA);
            put.setEntity(entity);
            put.setHeader("Content-Type", "application/x-www-form-urlencoded");
            return send(responseType, put);
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends ApiResponse> Response<T, Errors> delete(String url, Class<T> responseType, Object query, final List<NameValuePair> params) {
        final HttpDelete delete;
        try {
            delete = new HttpDelete(new URIBuilder(Utils.replaceQuery(url, query)).build());
            delete.setEntity(new UrlEncodedFormEntity(params));
            delete.setHeader("Content-Type", "application/x-www-form-urlencoded");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return this.send(responseType, delete);
    }

    private <T extends ApiResponse> Response<T, Errors> send(Class<T> objectClass, HttpUriRequestBase httpRequest) {
        try {
            httpRequest.setHeader("XF-Api-Key", this.token);
            if (this.user != -1)
                httpRequest.setHeader("XF-Api-User", String.valueOf(this.user));

            final HttpClientContext context = HttpClientContext.create();
            try (ClassicHttpResponse httpResponse = this.httpClient.executeOpen(null, httpRequest, context)) {
                final var httpEntity = httpResponse.getEntity();

                if (httpEntity == null)
                    throw new XenForoHttpException("Http entity returned by XenForo is null");

                final String body = Utils.toString(httpEntity.getContent());
                final StatusLine status = new StatusLine(httpResponse);

                switch (StatusCode.fromStatus(status.getStatusCode())) {
                    case BadRequest:
                        throw new XenForoBadRequestException(body);
                    case NotAuthorized:
                        throw new XenforoNotAuthorizedException(body);
                    case Forbidden:
                        throw new XenForoForbiddenException(body);
                    case ResourceNotFound:
                        throw new XenforoNotFoundException("Resource not found: " + httpRequest.getRequestUri());
                    case Unknown:
                        throw new XenForoBaseException(body);
                }

                try {
                    Log.debug("<-- Received body: " + body, "XenForoClient");
                    T parsed = this.gson.fromJson(body, objectClass);
                    return Response.success(parsed);
                } catch (JsonSyntaxException je) {
                    Log.error("", "XenForoClient", je);
                    Errors err = this.gson.fromJson(body, Errors.class);
                    Log.error("Retrieved the following errors: ", "XenForoClient");
                    err.getErrors().forEach(er -> Log.error(er.getCode() + " - " + er.getMessage(), "XenForoClient"));
                    return Response.error(err);
                }
            }
        } catch (XenForoBaseException e) {
            Log.error(e.getMessage(), "XenForoClient");
            httpRequest.abort();
            Errors err = this.gson.fromJson(e.getMessage(), Errors.class);
            return Response.error(err);
        } catch (IOException e) {
            throw new XenForoHttpException(e);
        }
    }
}
