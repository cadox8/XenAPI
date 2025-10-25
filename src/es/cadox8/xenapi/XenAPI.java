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

package es.cadox8.xenapi;

import de.jupf.staticlog.Log;
import de.jupf.staticlog.core.LogLevel;
import es.cadox8.xenapi.api.commons.Errors;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.ApiResponse;
import es.cadox8.xenapi.net.Response;
import es.cadox8.xenapi.net.XenForoClient;
import es.cadox8.xenapi.utils.Utils;
import lombok.NonNull;
import org.apache.hc.core5.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

public class XenAPI {

    private final XenForoClient client;
    private final String url;

    /**
     * Constructor for the XenAPI Builder
     *
     * @param url   the url where XenForo is installed at
     * @param token The token you have to access
     *              <p>
     *              You need to pass the user param if the token is for superuser
     */
    public XenAPI(final String url, final String token) {
        this(url, token, -1);
    }


    /**
     * Constructor for the XenAPI Builder
     *
     * @param url     the url where XenForo is installed at
     * @param token   The token you have to access
     * @param user_id The user of the generated token
     *                <p>
     *                You need to pass the user param if the token is for superuser
     */
    public XenAPI(final String url, final String token, int user_id) {
        this.url = url.contains("/api") ? url : url + "/api";
        this.client = new XenForoClient(token, user_id);
        this.setDebug(false);
    }

    /**
     * Sets the library to debug mode to see all logs. By default, this is False
     *
     * @param debug True/False
     */
    public void setDebug(boolean debug) {
        Log.setLogLevel(debug ? LogLevel.DEBUG : LogLevel.INFO);
    }

    // --- NEW ---

    /**
     * Method to send the request to the XenForo API
     *
     * @param request The ApiRequest Class
     * @param <T>     The ApiResponse Class from the ApiRequest
     * @return If success, the ApiResponse Class, if error an #Errors class with the errors from XenForo
     * @see Response
     * @see Errors
     */
    public <T extends ApiResponse> Response<T, Errors> send(@NonNull final ApiRequest<T> request) {
        final String url = Utils.createUrl(this.url, request.getPath());

        final List<NameValuePair> realParams = new ArrayList<>();
        switch (request.getMethod()) {
            case GET: {
                request.params().forEach(p -> realParams.add(p.generate()));
                return this.client.get(url, request.response(), request.query(), realParams);
            }
            case POST: {
                request.body().forEach(p -> realParams.add(p.generate()));

                return client.post(url, request.response(), request.query(), realParams);
            }
/*            case PUT:
                return client.putForObject(url, request.getBody(), request.getResponseType(), request.getQueryParams());*/
            case DELETE:
                request.body().forEach(p -> realParams.add(p.generate()));
                return client.delete(url, request.response(), request.query(), realParams);
            default:
                throw new IllegalArgumentException("Unsupported HTTP method: " + request.getMethod());
        }
    }
}
