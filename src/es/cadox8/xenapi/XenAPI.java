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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import de.jupf.staticlog.Log;
import de.jupf.staticlog.core.LogLevel;
import es.cadox8.xenapi.api.XenForoEntity;
import es.cadox8.xenapi.api.alerts.Alert;
import es.cadox8.xenapi.api.alerts.Alerts;
import es.cadox8.xenapi.api.attachment.AttachmentGet;
import es.cadox8.xenapi.api.attachment.AttachmentNewKey;
import es.cadox8.xenapi.api.attachment.Attachments;
import es.cadox8.xenapi.api.auth.LoginToken;
import es.cadox8.xenapi.api.commons.Success;
import es.cadox8.xenapi.api.commons.UpdateEmail;
import es.cadox8.xenapi.api.commons.User;
import es.cadox8.xenapi.api.conversation.*;
import es.cadox8.xenapi.api.forums.Forums;
import es.cadox8.xenapi.api.forums.Threads;
import es.cadox8.xenapi.api.index.Index;
import es.cadox8.xenapi.api.me.Me;
import es.cadox8.xenapi.api.user.*;
import es.cadox8.xenapi.net.XenForoClient;
import es.cadox8.xenapi.net.XenforoPaths;
import es.cadox8.xenapi.params.alerts.AlertsParams;
import es.cadox8.xenapi.params.alerts.MarkAlertParams;
import es.cadox8.xenapi.params.alerts.MarkAlertsParams;
import es.cadox8.xenapi.params.alerts.SendAlertParams;
import es.cadox8.xenapi.params.attachments.AttachmentsNewKeyParams;
import es.cadox8.xenapi.params.attachments.AttachmentsParams;
import es.cadox8.xenapi.params.auth.AuthParams;
import es.cadox8.xenapi.params.auth.AuthSessionParams;
import es.cadox8.xenapi.params.auth.LoginTokenParams;
import es.cadox8.xenapi.params.conversation.ConversationCreateParams;
import es.cadox8.xenapi.params.conversation.ConversationMsgsParams;
import es.cadox8.xenapi.params.conversation.ConversationsParams;
import es.cadox8.xenapi.params.conversation.UpdateConversationParams;
import es.cadox8.xenapi.params.forums.ForumsParams;
import es.cadox8.xenapi.params.forums.ThreadsParams;
import es.cadox8.xenapi.params.me.MeParams;
import es.cadox8.xenapi.params.user.FindUserByIdParams;
import es.cadox8.xenapi.utils.Utils;
import lombok.NonNull;
import org.apache.hc.core5.annotation.Experimental;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class XenAPI {

    private final XenForoClient client;
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
        this.client = new XenForoClient(token, user);
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

    // -- Alerts --
    public Alert getAlert(int id) {
        final Alert alerts = this.client.get(Utils.createUrl(this.url, XenforoPaths.ALERTS), Alert.class, String.valueOf(id));
        return alerts.setInternalXenAPI(this);
    }

    public Alerts getAlerts(@NonNull final AlertsParams params) {
        final Alerts alerts = this.client.get(Utils.createUrl(this.url, XenforoPaths.ALERTS), params.type(), params.params());
        return alerts.setInternalXenAPI(this);
    }

    public Success sendAlert(@NonNull final SendAlertParams params) {
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.ALERTS), params.body(), params.type()).setInternalXenAPI(this);
    }

    public Success markAlerts(@NonNull final MarkAlertsParams params) {
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.ALERTS_MARK), params.body(), params.type()).setInternalXenAPI(this);
    }

    public Success markAlert(@NonNull final MarkAlertParams params) {
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.ALERT_MARK), params.body(), params.type(), params.query()).setInternalXenAPI(this);
    }

    // -- --
    // -- Attachments --
    public Attachments getAttachments(@NonNull String key) {
        final Attachments att = this.client.get(Utils.createUrl(this.url, XenforoPaths.ATTACHMENTS), Attachments.class, key);
        return att.setInternalXenAPI(this);
    }

    @Experimental
    public AttachmentNewKey newAttachmentKey(@NonNull final AttachmentsNewKeyParams params) {
        final AttachmentNewKey newKey = this.client.postFileForObject(Utils.createUrl(this.url, XenforoPaths.ATTACHMENTS_NEW_KEY), params.getAttachment(), params.body(), params.type(), params.getAttachment().getName());
        return newKey.setInternalXenAPI(this);
    }

    @Experimental
    public AttachmentGet newAttachment(@NonNull final AttachmentsParams params) {
        final AttachmentGet newKey = this.client.postFileForObject(Utils.createUrl(this.url, XenforoPaths.ATTACHMENTS_NEW_KEY), params.getAttachment(), params.body(), params.type(), params.getAttachment().getName());
        return newKey.setInternalXenAPI(this);
    }

    // -- --
    // -- Auth --
    public User auth(@NonNull final AuthParams params) {
        final FindEmail user = this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.AUTH), params.body(), params.type());
        user.setInternalXenAPI(this);
        return user.getUser();
    }

    public User authSession(@NonNull final AuthSessionParams params) {
        final FindEmail user = this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.AUTH_SESSION), params.body(), params.type());
        user.setInternalXenAPI(this);
        return user.getUser();
    }

    public LoginToken loginToken(@NonNull final LoginTokenParams token) {
        final LoginToken user = this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.LOGIN_TOKEN), token.body(), token.type());
        return user.setInternalXenAPI(this);
    }
    // -- --
    // -- Conversations --

    /**
     * Replies to a conversation.
     * <p>
     * This method is the same as {@link #replyConversationId(ConversationMsgsParams)}  replyConversation}
     *
     * @param params
     * @return
     */
    public ConversationMessages replyConversation(@NonNull final ConversationMsgsParams params) {
        final ConversationMessages conv = this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATION_MSG), params.body(), params.type());
        return conv.setInternalXenAPI(this);
    }

    public ConversationMessages getConversation(final int id) {
        final ConversationMessages conv = this.client.get(Utils.createUrl(this.url, XenforoPaths.CONVERSATION_MSG), ConversationMessages.class, String.valueOf(id));
        return conv.setInternalXenAPI(this);
    }

    /**
     * Replies to a conversation.
     * <p>
     * This method is the same as {@link #replyConversation(ConversationMsgsParams)}  replyConversation}
     *
     * @param params
     * @return
     */
    public ConversationMessages replyConversationId(@NonNull final ConversationMsgsParams params) {
        final JsonObject body = new JsonObject();
        body.addProperty("message", params.getMessage());
        body.addProperty("attachment_key", params.getAttachment_key());

        final ConversationMessages conv = this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATION_MSG), body, params.type(), String.valueOf(params.getConversationId()));
        return conv.setInternalXenAPI(this);
    }

    /**
     * Reacts to a conversation. If the reaction id is the same, it will be removed
     *
     * @param id       The id of the conversation
     * @param reaction The Reaction id (refs to the reaction id on the forum, we can not get the list at the moment)
     * @return A class with the information of the action and the status (always true)
     * @see ConversationReact
     */
    public ConversationReact reactConversation(final int id, final int reaction) {
        final JsonObject body = new JsonObject();
        body.addProperty("reaction_id", reaction);
        final ConversationReact conv = this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATION_MSG_REACT), body, ConversationReact.class, String.valueOf(id));
        return conv.setInternalXenAPI(this);
    }

    public Conversations getConversations(@NonNull final ConversationsParams params) {
        return this.client.get(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS), params.type(), params.query()).setInternalXenAPI(this);
    }

    public ConversationCreate createConversation(@NonNull final ConversationCreateParams params) {
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS), params.body(), params.getType()).setInternalXenAPI(this);
    }

    public ConversationInfo getConversationInfo(final int id, final boolean withMessages, final int page) {
        final NameValuePair[] query = new NameValuePair[2];
        if (withMessages)
            query[0] = new BasicNameValuePair("with_messages", "true");
        if (page > 1)
            query[1] = new BasicNameValuePair("page", String.valueOf(page));

        return this.client.get(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS), ConversationInfo.class, String.valueOf(id), query).setInternalXenAPI(this);
    }

    public ConversationCreate updateConversation(@NonNull final UpdateConversationParams params) {
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS), params.body(), params.type(), String.valueOf(params.getConversationId())).setInternalXenAPI(this);
    }

    public Success deleteConversation(final int id, final Success ignore) {
        return this.client.delete(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS), Success.class, String.valueOf(id), new BasicNameValuePair("ignore", String.valueOf(ignore))).setInternalXenAPI(this);
    }

    public Success inviteConversation(final int id, final Integer[] recipients) {
        final JsonObject body = new JsonObject();
        final JsonArray array = new JsonArray();
        Arrays.asList(recipients).forEach(array::add);
        body.add("recipient_ids", array);
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS_INVITE), body, Success.class, String.valueOf(id)).setInternalXenAPI(this);
    }

    public Success markConversationAsRead(final int id, final int date) {
        final JsonObject body = new JsonObject();
        body.addProperty("date", date);
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS_MARK_READ), body, Success.class, String.valueOf(id)).setInternalXenAPI(this);
    }

    public Success markConversationAsUnread(final int id) {
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS_MARK_UNREAD), Success.class, String.valueOf(id)).setInternalXenAPI(this);
    }

    public GetConversationMessages getMessagesFromConversation(final int id, final int page) {
        return this.client.get(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS_MESSAGES), GetConversationMessages.class, String.valueOf(id), new BasicNameValuePair("page", String.valueOf(page))).setInternalXenAPI(this);
    }

    public Success markConversationAsStar(final int id, final boolean star) {
        final JsonObject body = new JsonObject();
        body.addProperty("star", star);
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.CONVERSATIONS_MESSAGES), body, Success.class, String.valueOf(id)).setInternalXenAPI(this);
    }

    // -- --
    // -- Forums --
    public Forums getForum(@NonNull final ForumsParams params) {
        return this.client.get(Utils.createUrl(this.url, XenforoPaths.FORUMS), params.type(), String.valueOf(params.getForumId()), params.params()).setInternalXenAPI(this);
    }

    public Success markForumAsRead(final int forum, final int date) {
        final JsonObject body = new JsonObject();
        body.addProperty("date", date);
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.FORUMS_MARK_READ), body, Success.class, String.valueOf(forum)).setInternalXenAPI(this);
    }

    public Threads getForumThreads(@NonNull final ThreadsParams params) {
        return this.client.get(Utils.createUrl(this.url, XenforoPaths.FORUMS), params.type(), String.valueOf(params.getForumId()), params.params()).setInternalXenAPI(this);
    }

    // -- --
    // -- Index --
    public Index getIndex() {
        return this.client.get(Utils.createUrl(this.url, XenforoPaths.INDEX), Index.class).setInternalXenAPI(this);
    }

    // -- --
    // -- Me --
    public Me getMe() {
        return this.client.get(Utils.createUrl(this.url, XenforoPaths.ME), Me.class).setInternalXenAPI(this);
    }

    public Success updateMe(@NonNull final MeParams params) {
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.ME), params.body(), Success.class).setInternalXenAPI(this);
    }

    public Success updateMeAvatar(@NonNull final File file) {
        return this.client.postFileForObject(Utils.createUrl(this.url, XenforoPaths.ME_AVATAR), file, Success.class, "", "avatar").setInternalXenAPI(this);
    }

    public UpdateEmail updateMeEmail(final String currentPassword, final String new_email) {
        final JsonObject body = new JsonObject();
        body.addProperty("current_password", currentPassword);
        body.addProperty("email", new_email);
        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.ME_EMAIL), body, UpdateEmail.class).setInternalXenAPI(this);
    }

    public Success updateMePassword(final String currentPassword, final String new_password) {
        final JsonObject body = new JsonObject();
        body.addProperty("current_password", currentPassword);
        body.addProperty("new_password", new_password);

        return this.client.postForObject(Utils.createUrl(this.url, XenforoPaths.ME_PASSWORD), body, Success.class).setInternalXenAPI(this);
    }
    // -- --
    // -- Users --

    /**
     * Gets all users from the forum
     *
     * @param page The page to look at
     * @return A collection of users and a paginator to retrieve more Users
     * @see Users
     */
    public Users getUsers(int page) {
        final Users user = this.client.get(Utils.createUrl(this.url, XenforoPaths.GET_USERS), Users.class, new BasicNameValuePair("page", String.valueOf(page)));
        user.setInternalXenAPI(this);
        return user;
    }

    /**
     * Finds a user by its email
     *
     * @param email The email of the user
     * @return The User data
     * @see User
     */
    public User findUserByEmail(String email) {
        final FindEmail user = this.client.get(Utils.createUrl(this.url, XenforoPaths.GET_USERS_EMAIL), FindEmail.class, new BasicNameValuePair("email", email));
        user.setInternalXenAPI(this);
        return user.getUser();
    }

    /**
     * Finds a user by its name. If the name does not match to any user, a list of recommendations will be given
     *
     * @param name The name to search for
     * @return The User or a list of Recommendations
     * @see FindName
     * @see User
     */
    public FindName findUserByName(String name) {
        final FindName user = this.client.get(Utils.createUrl(this.url, XenforoPaths.GET_USERS_NAME), FindName.class, new BasicNameValuePair("username", name));
        user.setInternalXenAPI(this);
        return user;
    }

    public UserId findUserById(@NonNull final FindUserByIdParams params) {
        final UserId user = this.client.get(Utils.createUrl(this.url, XenforoPaths.USERS_ID), params.type(), params.query(), params.params());
        user.setInternalXenAPI(this);
        return user;
    }

    /**
     * Deletes a user from the forum
     *
     * @param id The id of the User to be deleted
     * @return True if the user was deleted successfully, false if not
     */
    public Success deleteUser(int id) {
        return this.client.delete(Utils.createUrl(this.url, XenforoPaths.USERS_ID), Success.class, String.valueOf(id));
    }

    /**
     * Deletes a user from the forum.
     * RenameTo changes the name of the user before deleting it
     *
     * @param id       The id of the User to be deleted
     * @param renameTo The new name of the user
     * @return True if the user was deleted successfully, false if not
     */
    public Success deleteUser(int id, String renameTo) {
        return this.client.delete(Utils.createUrl(this.url, XenforoPaths.USERS_ID), Success.class, String.valueOf(id), new BasicNameValuePair("renameTo", renameTo));
    }

    public Success updateAvatar(int id, @NonNull final File file) {
        return this.client.postFileForObject(Utils.createUrl(this.url, XenforoPaths.USER_AVATAR), file, Success.class, String.valueOf(id), "avatar");
    }

    public Success deleteAvatar(int id) {
        return this.client.delete(Utils.createUrl(this.url, XenforoPaths.USER_AVATAR), Success.class, String.valueOf(id));
    }

    public GetProfilePosts getProfilePosts(@NonNull int id) {
        final GetProfilePosts user = this.client.get(Utils.createUrl(this.url, XenforoPaths.PROFILE_POSTS), GetProfilePosts.class, String.valueOf(id));
        user.setInternalXenAPI(this);
        return user;
    }

    private <T extends XenForoEntity> List<T> asList(Supplier<T[]> responseSupplier) {
        return Arrays.stream(responseSupplier.get()).peek(t -> t.setInternalXenAPI(this)).collect(Collectors.toList());
    }
}
