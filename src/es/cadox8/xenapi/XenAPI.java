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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class XenAPI {

    @Getter private static XenAPI instance;
    private Gson gson;
    private final HttpClient httpClient;

    @Getter private final String token;

    /**
     * Default constructor
     *
     * @param token The API token
     * @param url The URL to the forum
     */
    public XenAPI(String token, String url) {
        instance = this;

        if (!url.endsWith("/api")) url += "/api";
        this.token = token;

        httpClient = HttpClientBuilder.create().build();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }
}
