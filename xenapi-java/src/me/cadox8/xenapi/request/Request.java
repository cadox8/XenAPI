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

package me.cadox8.xenapi.request;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.xenapi.XenAPI;

import java.util.Map;

public class Request {

    @Getter @Setter private static String BASE_URL = "";

    @Getter private final RequestType requestType;
    @Getter private final Map<RequestParam, Object> params;

    @Getter private String grab_as = "";

    public Request(RequestType requestType, Map<RequestParam, Object> params) {
        this.requestType = requestType;
        this.params = params;
    }

    /**
     * Allows to getResponse a Reply with one username
     *
     * @param username The username to grab
     * @return A Request
     */
    public Request grab_as(String username) {
        grab_as = username;
        return this;
    }

    /**
     * Gets the action URL
     *
     * @param xenAPI Instance class
     * @return Returns the complete URL
     */
    public String getURL(XenAPI xenAPI) {
        final StringBuilder url = new StringBuilder(BASE_URL + "?action=");

        url.append(requestType.getKey()).append("&");
        for (Map.Entry<RequestParam, Object> entry : params.entrySet()) url.append(entry.getKey().getQueryField()).append("=").append(entry.getKey().serialize(entry.getValue())).append("&");
        if (!params.containsKey(RequestParam.HASH)) url.append("hash=").append(xenAPI.getToken());
        if (!grab_as.equalsIgnoreCase("")) url.append("&grab_as=").append(grab_as);
        return url.toString();
    }
}
