package me.cadox8.xenapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import me.cadox8.xenapi.reply.AbstractReply;
import me.cadox8.xenapi.request.Request;
import me.cadox8.xenapi.utils.Callback;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class XenAPI {

    @Getter private static XenAPI instance;
    @Getter private final Gson gson;
    private HttpClient httpClient;

    private final ExecutorService exService = Executors.newCachedThreadPool();

    @Getter private UUID token;

    public XenAPI() {
        instance = this;

        httpClient = HttpClientBuilder.create().build();

        gson = new GsonBuilder().create();
    }


    /**
     * Sets the API token
     *
     * @param token API Token
     */
    public void setToken(String token) {
        setToken(UUID.fromString(token));
    }
    public void setToken(UUID token) {
        this.token = token;
    }


    /**
     * Sets the Base URL to call the API
     *
     * @param url Base URL to the forum
     */
    public void setBaseURL(String url) {
        if (!url.startsWith("h")) url = url.replaceAll(url, "http://" + url);
        if (!url.endsWith("/")) url = url.replaceAll(url, url + "/");

        Request.setBASE_URL(url);
    }


    /**
     * Execute Request asynchronously, executes Callback when finished
     *
     * @param request  Request to get
     * @param callback Callback to execute
     * @param <R>      Class of the reply
     */
    public <R extends AbstractReply> void getAsync(Request request, Callback<R> callback) {
        if (getToken() == null) return;
        get(request, callback);
    }


    /**
     * Internal method
     *
     * @param request  The request to get
     * @param callback The callback to execute
     * @param <T>      The class of the callback
     * @return The ResponseHandler that wraps the callback
     */
    private <T extends AbstractReply> ResponseHandler<HttpResponse> buildResponseHandler(Request request, Callback<T> callback) {
        return obj -> {
            T value;
            try {
                String content = EntityUtils.toString(obj.getEntity(), "UTF-8");
                value = gson.fromJson(content, (Type) request.getRequestType().getReplyClass());

            } catch (Throwable t) {
                callback.callback(t, null);
                return obj;
            }
            callback.callback(null, value);
            return obj;
        };
    }

    /**
     * Internal method
     *
     * @param request  The request to get
     * @param callback The callback to execute
     */
    private Future<HttpResponse> get(Request request, Callback<?> callback) {
        return exService.submit(() -> httpClient.execute(new HttpGet(request.getURL(this)), buildResponseHandler(request, callback)));
    }


    /**
     * Gets file from website
     *
     * @param url The url to read
     */
    @Deprecated
    public static String getWebInfo(String url){
        try {
            URL u = new URL(url);
            BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
            return br.readLine();
        } catch (IOException e){}
        return "Error with URL";
    }
}
