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

import es.cadox8.xenapi.utils.Argument;

public class XenForoUrl {

    //
    public static final String GET_ME = "/me";

    public static final String GET_USERS = "/users";
    public static final String GET_USERS_ID = "/users/{id}";
    //

    private final String baseUrl;
    private final String api_url;

    private Argument[] args = {};

    private XenForoUrl(String api_url, String baseUrl) {
        this.api_url = api_url;
        this.baseUrl = baseUrl;
    }

    public static XenForoUrl createUrlWithArgs(String api_url, String baseUrl) {
        return new XenForoUrl(api_url, baseUrl);
    }

    public static String createUrl(String api_url, String baseUrl) {
        return api_url + baseUrl;
    }

    public XenForoUrl params(Argument... args) {
        this.args = args;
        return this;
    }

    public String asString() {
        final StringBuilder builder = new StringBuilder(this.api_url);
        builder.append(baseUrl);
        for (Argument arg : args) {
            builder.append("/");
            builder.append(arg.getArgValue());
        }
        return builder.toString();
    }
}
