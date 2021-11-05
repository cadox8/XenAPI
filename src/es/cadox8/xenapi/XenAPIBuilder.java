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

package es.cadox8.xenapi;

import es.cadox8.xenapi.api.Me;
import es.cadox8.xenapi.api.User;
import es.cadox8.xenapi.api.XenForoEntity;
import es.cadox8.xenapi.net.XenForoClient;
import es.cadox8.xenapi.net.XenForoUrl;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class XenAPIBuilder implements XenAPI {

    private final XenForoClient httpClient;
    private final String url;

    /**
     * Constructor for the XenAPI Builder
     *
     * @param url the url where XenForo is installed at
     * @param token The token you have to access
     */
    public XenAPIBuilder(String url, String token) {
        this(url, token, "");
    }

    /**
     * Constructor for the XenAPI Builder
     *
     * @param url the url where XenForo is installed at
     * @param token The token you have to access
     * @param user The user of the generated token
     *
     * You need to pass the user param if the token is for superuser
     */
    public XenAPIBuilder(String url, String token, String user) {
        this.url = url + "/api";
        this.httpClient = new XenForoClient(token, user);
    }

    //

    @Override
    public Me me() {
        final Me me = get(XenForoUrl.createUrl(this.url, XenForoUrl.GET_ME), Me.class);
        me.setInternalXenAPI(this);
        return me;
    }

    @Override
    public User findUserById() {
        final User user = get(XenForoUrl.createUrl(this.url, XenForoUrl.GET_USERS), User.class);
        user.setInternalXenAPI(this);
        return user;
    }

    @Override
    public User findUserById(int id) {
        final User user = get(XenForoUrl.createUrl(this.url, XenForoUrl.GET_USERS_ID), User.class, String.valueOf(id));
        user.setInternalXenAPI(this);
        return user;
    }

    /* internal methods */

    private <T> T postFileForObject(String url, File file, Class<T> objectClass, String... params) {
        return httpClient.postFileForObject(url, file, objectClass, params);
    }

    private <T> T post(String url, Object object, Class<T> objectClass, String... params) {
        return httpClient.postForObject(url, object, objectClass, params);
    }

    private <T> T get(String url, Class<T> objectClass, String... params) {
        return httpClient.get(url, objectClass, params);
    }

    private <T> T put(String url, Object object, Class<T> objectClass, String... params) {
        return httpClient.putForObject(url, object, objectClass, params);
    }

    private <T> T delete(String url, Class<T> responseType, String... params) {
        return httpClient.delete(url, responseType, params);
    }

    private <T extends XenForoEntity> List<T> asList(Supplier<T[]> responseSupplier) {
        return Arrays.stream(responseSupplier.get()).peek(t -> t.setInternalXenAPI(this)).collect(Collectors.toList());
    }
}
