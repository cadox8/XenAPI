package es.cadox8.xenapi.net;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class XenForoClient {

    private final HttpClient httpClient;
    private final ObjectMapper mapper;

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
        this.mapper = new ObjectMapper();
    }

    public <T> T get(String url, Class<T> responseType, String... params) {
        final HttpGet httpGet = new HttpGet(UrlExpander.expandUrl(url, params));
        httpGet.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpGet.setHeader("XF-Api-Key", this.token);
        httpGet.setHeader("XF-Api-User", this.user);
        return getEntityAndReleaseConnection(responseType, httpGet);
    }

    public <T> T postForObject(String url, Object body, Class<T> responseType, String... params) {
        final HttpPost httpPost = new HttpPost(UrlExpander.expandUrl(url, params));
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setHeader("XF-Api-Key", this.token);
        httpPost.setHeader("XF-Api-User", this.user);

        try {
            final HttpEntity entity = new ByteArrayEntity(this.mapper.writeValueAsBytes(body), ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);

            return getEntityAndReleaseConnection(responseType, httpPost);
        } catch (JsonProcessingException e) {
            // TODO : custom exception
            throw new RuntimeException(e);
        }
    }

    public <T> T postFileForObject(String url, File file, Class<T> objectClass, String... params) {
        final HttpPost httpPost = new HttpPost(UrlExpander.expandUrl(url, params));
        final HttpEntity entity = MultipartEntityBuilder.create().addPart("file", new FileBody(file)).addPart("filename", new StringBody(file.getName(), ContentType.TEXT_PLAIN)).build();
        httpPost.setEntity(entity);
        httpPost.setHeader("Content-Type", "multipart/form-data");
        httpPost.setHeader("XF-Api-Key", this.token);
        httpPost.setHeader("XF-Api-User", this.user);
        return getEntityAndReleaseConnection(objectClass, httpPost);
    }

    public <T> T putForObject(String url, Object body, Class<T> responseType, String... params) {
        final HttpPut put = new HttpPut(UrlExpander.expandUrl(url, params));
        put.setHeader("Content-Type", "application/x-www-form-urlencoded");
        put.setHeader("XF-Api-Key", this.token);
        put.setHeader("XF-Api-User", this.user);
        try {
            final HttpEntity entity = new ByteArrayEntity(this.mapper.writeValueAsBytes(body), ContentType.APPLICATION_JSON);
            put.setEntity(entity);
            return getEntityAndReleaseConnection(responseType, put);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T delete(String url, Class<T> responseType, String... params) {
        final HttpDelete delete = new HttpDelete(UrlExpander.expandUrl(url, params));
        delete.setHeader("Content-Type", "application/x-www-form-urlencoded");
        delete.setHeader("XF-Api-Key", this.token);
        delete.setHeader("XF-Api-User", this.user);
        return getEntityAndReleaseConnection(responseType, delete);
    }

    private <T> T getEntityAndReleaseConnection(Class<T> objectClass, HttpRequestBase httpRequest) {
        try {
            final HttpResponse httpResponse = this.httpClient.execute(httpRequest);

            final HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                final String body = Utils.toString(httpEntity.getContent());
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
                    return this.mapper.readValue(body, objectClass);
                } catch (JsonProcessingException e) {
                    throw new XenForoHttpException("Cannot parse XenForo response. Expected to get a json string, but got: " + body);
                }
            } else {
                throw new XenForoHttpException("http entity returned by XenForo is null");
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
