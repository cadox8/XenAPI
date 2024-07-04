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

import com.google.gson.JsonObject;
import es.cadox8.xenapi.api.XenForoEntity;
import es.cadox8.xenapi.api.alerts.Alert;
import es.cadox8.xenapi.api.alerts.Alerts;
import es.cadox8.xenapi.api.user.*;
import es.cadox8.xenapi.net.XenForoClient;
import es.cadox8.xenapi.net.XenforoPaths;
import es.cadox8.xenapi.utils.Utils;
import lombok.NonNull;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class XenAPI {

    private final XenForoClient httpClient;
    private final String url;

    /**
     * Constructor for the XenAPI Builder
     *
     * @param url   the url where XenForo is installed at
     * @param token The token you have to access
     */
    @Deprecated
    public XenAPI(String url, String token) {
        this(url, token, "");
    }

    /**
     * Constructor for the XenAPI Builder
     *
     * @param url   the url where XenForo is installed at
     * @param token The token you have to access
     * @param user  The user of the generated token
     *              <p>
     *              You need to pass the user param if the token is for superuser
     */
    public XenAPI(String url, String token, String user) {
        this.url = url.contains("/api") ? url : url + "/api";
        this.httpClient = new XenForoClient(token, user);
    }

    // --- ---

    /**
     * Gets all users from the forum
     *
     * @param page The page to look at
     * @return A collection of users and a paginator to retrieve more Users
     * @see Users
     */
    public Users getUsers(int page) {
        final Users user = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.GET_USERS), Users.class, new BasicNameValuePair("page", String.valueOf(page)));
        user.setInternalXenAPI(this);
        return user;
    }

    /**
     * Finds a user by its email
     *
     * @param email The email of the user
     * @return The User data
     * @see FindEmail
     * @see es.cadox8.xenapi.api.models.User
     */
    public FindEmail findUserByEmail(String email) {
        final FindEmail user = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.GET_USERS_EMAIL), FindEmail.class, new BasicNameValuePair("email", email));
        user.setInternalXenAPI(this);
        return user;
    }

    /**
     * Finds a user by its name. If the name does not match to any user, a list of recommendations will be given
     *
     * @param name The name to search for
     * @return The User or a list of Recommendations
     * @see FindName
     * @see es.cadox8.xenapi.api.models.User
     */
    public FindName findUserByName(String name) {
        final FindName user = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.GET_USERS_NAME), FindName.class, new BasicNameValuePair("username", name));
        user.setInternalXenAPI(this);
        return user;
    }

    /**
     * Finds a user by its id.
     *
     * @param id The id of the user
     * @return The user data
     * @see UserId
     * @see es.cadox8.xenapi.api.models.User
     */
    public UserId findUserById(int id) {
        final UserId user = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.USERS_ID), UserId.class, String.valueOf(id));
        user.setInternalXenAPI(this);
        return user;
    }

    /**
     * Finds a user by its id. Adding with_posts (true or false), it will retrieve all posts by the user. Use paginator to
     * retrieve all
     *
     * @param id         The id of the user
     * @param with_posts True or False (if included, posts will be given)
     * @param page       The page we are looking for
     * @return The user data
     * @see UserId
     * @see es.cadox8.xenapi.api.models.User
     */
    public UserId findUserById(int id, boolean with_posts, int page) {
        final UserId user = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.USERS_ID), UserId.class, String.valueOf(id), new BasicNameValuePair("with_posts", String.valueOf(with_posts)), new BasicNameValuePair("page", String.valueOf(page)));
        user.setInternalXenAPI(this);
        return user;
    }

    /**
     * Deletes a user from the forum
     *
     * @param id The id of the User to be deleted
     * @return True if the user was deleted successfully, false if not
     */
    public boolean deleteUser(int id) {
        return this.httpClient.delete(Utils.createUrl(this.url, XenforoPaths.USERS_ID), Boolean.class, String.valueOf(id));
    }

    /**
     * Deletes a user from the forum.
     * RenameTo changes the name of the user before deleting it
     *
     * @param id       The id of the User to be deleted
     * @param renameTo The new name of the user
     * @return True if the user was deleted successfully, false if not
     */
    public boolean deleteUser(int id, String renameTo) {
        return this.httpClient.delete(Utils.createUrl(this.url, XenforoPaths.USERS_ID), Boolean.class, String.valueOf(id), new BasicNameValuePair("renameTo", renameTo));
    }

    public boolean updateAvatar(int id, @NonNull final File file) {
        return this.httpClient.postFileForObject(Utils.createUrl(this.url, XenforoPaths.USER_AVATAR), file, Boolean.class, String.valueOf(id), "avatar");
    }

    public boolean deleteAvatar(int id) {
        return this.httpClient.delete(Utils.createUrl(this.url, XenforoPaths.USER_AVATAR), Boolean.class, String.valueOf(id));
    }

    public GetProfilePosts getProfilePosts(int id) {
        final GetProfilePosts user = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.PROFILE_POSTS), GetProfilePosts.class, String.valueOf(id));
        user.setInternalXenAPI(this);
        return user;
    }

    public Alert getAlert(int id) {
        final Alert alerts = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.ALERTS), Alert.class, String.valueOf(id));
        alerts.setInternalXenAPI(this);
        return alerts;
    }

    public Alerts getAlerts() {
        final Alerts alerts = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.ALERTS), Alerts.class);
        alerts.setInternalXenAPI(this);
        return alerts;
    }

    public Alerts getAlerts(int page, int cutoff, boolean unviewed, boolean unread) {
        final Alerts alerts = this.httpClient.get(Utils.createUrl(this.url, XenforoPaths.ALERTS), Alerts.class, new BasicNameValuePair("page", String.valueOf(page)), new BasicNameValuePair("cutoff", String.valueOf(cutoff)), new BasicNameValuePair("unviewed", String.valueOf(unviewed)), new BasicNameValuePair("unread", String.valueOf(unread)));
        alerts.setInternalXenAPI(this);
        return alerts;
    }

    public boolean sendAlert(int toUserId, String alert) {
        final JsonObject body = new JsonObject();
        body.addProperty("to_user_id", toUserId);
        body.addProperty("alert", alert);
        return this.httpClient.postForObject(Utils.createUrl(this.url, XenforoPaths.ALERTS), body, Boolean.class, "");
    }

    public boolean sendAlert(int toUserId, String alert, int fromUserId, String link, String title) {
        final JsonObject body = new JsonObject();
        body.addProperty("to_user_id", toUserId);
        body.addProperty("alert", alert);
        body.addProperty("from_user_id", fromUserId);
        body.addProperty("link_url", link);
        body.addProperty("link_title", title);
        return this.httpClient.postForObject(Utils.createUrl(this.url, XenforoPaths.ALERTS), body, Boolean.class, "");
    }

    public boolean markAlerts(boolean read, boolean viewed) {
        final JsonObject body = new JsonObject();
        if (read)
            body.addProperty("read", true);
        if (viewed)
            body.addProperty("viewed", true);
        return this.httpClient.postForObject(Utils.createUrl(this.url, XenforoPaths.ALERTS_MARK), body, Boolean.class, "");
    }

    private <T extends XenForoEntity> List<T> asList(Supplier<T[]> responseSupplier) {
        return Arrays.stream(responseSupplier.get()).peek(t -> t.setInternalXenAPI(this)).collect(Collectors.toList());
    }
}
