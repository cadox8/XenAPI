/*
 *  Copyright (c) 2018.
 *
 *  This file is part of XenAPI <https://github.com/cadox8/XenAPI>.
 *
 *  XenAPI is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  XenAPI is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.cadox8.xenapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import me.cadox8.xenapi.reply.AbstractReply;
import me.cadox8.xenapi.reply.AlertsReply;
import me.cadox8.xenapi.request.Request;
import me.cadox8.xenapi.request.RequestType;
import me.cadox8.xenapi.utils.Callback;
import me.cadox8.xenapi.utils.Log;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class XenAPI {

    @Getter private static XenAPI instance;
    private Gson gson;
    private final HttpClient httpClient;

    private final ExecutorService exService = Executors.newCachedThreadPool();

    @Getter private final String token;

    /**
     * Default constructor
     *
     * @param token The API token
     * @param url The URL to the forum
     */
    public XenAPI(String token, String url) {
        instance = this;

        if (!url.endsWith("/api.php")) url += "/api.php";
        Request.setBASE_URL(url);
        this.token = token;

        httpClient = HttpClientBuilder.create().build();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Execute Request, executes Callback when finished
     *
     * @param request  Request to get
     * @param callback Callback to execute
     * @param <R>      Class of the reply
     */
    public <R extends AbstractReply> void getReply(Request request, Callback<R> callback) {
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
                final String content = EntityUtils.toString(obj.getEntity(), "UTF-8");
                Log.debug(content);

                if (request.getRequestType() == RequestType.GET_ALERTS) {
                    final GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
                    builder.registerTypeAdapter(AlertsReply.Alerts.class, new AlertsReply.AlertListDeserializer());
                    value = builder.create().fromJson(content, (Type) AlertsReply.Alerts.class);
                } else {
                    value = gson.fromJson(content, (Type) request.getRequestType().getReplyClass());
                }
                value.setJson(content);
                value.setUrl(request.getURL(this));
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
}
