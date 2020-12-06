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

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.cadox8.xenapi.reply.*;

@AllArgsConstructor
public enum RequestType {

    AUTHENTICATE("authenticate", AuthenticateReply.class),
    LOGIN("login", LoginReply.class),
    LOGOUT("logout", LogoutReply.class),
    REGISTER("register", RegisterReply.class),

    CREATE_ALERT("createAlert", CreateAlertReply.class),
    CREATE_POST("createPost", CreatePostReply.class),
    CREATE_THREAD("createThread", CreateThreadReply.class),

    UPGRADE_USER("upgradeuser"),

    SEARCH("search"),

    EDIT_USER("editUser", EditUserReply.class),

    GET_ADDON("getAddon", AddonReply.class),
    GET_ADDONS("getAddons", AddonsReply.class),
    GET_ACTIONS("getActions", ActionsReply.class),
    GET_ALERTS("getAlerts", AlertsReply.class),
    GET_CONVERSATIONS("getConversations"),
    GET_GROUP("getGroup", GroupReply.class),
    GET_NODE("getNode", NodeReply.class),
    GET_NODES("getNodes", NodesReply.class),
    GET_POST("getPost", PostReply.class),
    GET_POSTS("getPosts", PostsReply.class),
    GET_AVATAR("getAvatar", AvatarReply.class);


    @Getter private final String key;
    @Getter private final Class<? extends AbstractReply> replyClass;

    RequestType(String key) {
        this(key, null);
    }
}
