/*
 * Copyright (c) 2018-2021.
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

import es.cadox8.xenapi.net.Client;
import es.cadox8.xenapi.request.BaseRequest;
import es.cadox8.xenapi.response.BaseResponse;
import es.cadox8.xenapi.utils.Callback;
import lombok.NonNull;

public class XenAPI {

    private final Client client;
    private final String token;

    /**
     * Default constructor
     *
     * @param url The URL to the forum
     * @param token The API token
     */
    public XenAPI(@NonNull String url, @NonNull String token) {
        if (!url.endsWith("/api")) url += "/api";

        this.token = token;

        this.client = new Client();
    }

    private <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> request) {
        return this.client.send(request);
    }

    private  <T extends BaseRequest<T, R>, R extends BaseResponse> void execute(T request, Callback<T, R> callback) {
        this.client.send(request, callback);
    }
}
