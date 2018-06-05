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

import java.util.function.Function;

@AllArgsConstructor
public enum RequestParam {

    AUTH_USER(RequestType.AUTHENTICATE, "username", String.class),
    AUTH_PASS(RequestType.AUTHENTICATE, "password", String.class),

    CREATE_ALERT_USER(RequestType.CREATE_ALERT, "user", String.class),
    CREATE_ALERT_CAUSE_USER(RequestType.CREATE_ALERT, "cause_user", String.class),
    CREATE_ALERT_CONTENT_TYPE(RequestType.CREATE_ALERT, "content_type", String.class),
    CREATE_ALERT_CONTENT_ID(RequestType.CREATE_ALERT, "content_id", Integer.class),
    CREATE_ALERT_ALERT_ACTION(RequestType.CREATE_ALERT, "alert_action", String.class),

    CREATE_POST_THREAD_ID(RequestType.CREATE_POST, "thread_id", Integer.class),
    CREATE_POST_MESSAGE(RequestType.CREATE_POST, "message", String.class),

    CREATE_THREAD_TITLE(RequestType.CREATE_THREAD, "title", String.class),
    CREATE_THREAD_MESSAGE(RequestType.CREATE_THREAD, "message", String.class),
    CREATE_THREAD_NODE_ID(RequestType.CREATE_THREAD, "node_id", Integer.class),
    CREATE_THREAD_PREFIX_ID(RequestType.CREATE_THREAD, "prefix_id", Integer.class),
    CREATE_THREAD_DISCUSSION_OPEN(RequestType.CREATE_THREAD, "discussion_open", Integer.class),
    CREATE_THREAD_DISCUSSION_STATE(RequestType.CREATE_THREAD, "discussion_state", String.class),
    CREATE_THREAD_STICKY(RequestType.CREATE_THREAD, "sticky", Integer.class),

    EDIT_USER(RequestType.EDIT_USER, RequestType.REGISTER, "username", String.class),
    EDIT_PASS(RequestType.EDIT_USER, RequestType.REGISTER, "password", String.class),
    EDIT_EMAIL(RequestType.EDIT_USER, RequestType.REGISTER, "email", String.class),
    EDIT_GROUP(RequestType.EDIT_USER, RequestType.REGISTER, "group", String.class),
    EDIT_GENDER(RequestType.EDIT_USER, RequestType.REGISTER, "gender", String.class),
    EDIT_TITLE(RequestType.EDIT_USER, RequestType.REGISTER, "custom_title", String.class),
    EDIT_STYLE(RequestType.EDIT_USER, RequestType.REGISTER, "style_id", Integer.class),
    EDIT_TIMEZONE(RequestType.EDIT_USER, RequestType.REGISTER, "timezone", String.class),
    EDIT_VISIBLE(RequestType.EDIT_USER, RequestType.REGISTER, "visible", Integer.class),
    EDIT_DOB_DAY(RequestType.EDIT_USER, RequestType.REGISTER, "dob_day", Integer.class),
    EDIT_DOB_MONTH(RequestType.EDIT_USER, RequestType.REGISTER, "dob_month", Integer.class),
    EDIT_DOB_YEAR(RequestType.EDIT_USER, RequestType.REGISTER, "dob_year", Integer.class),
    EDIT_STATE(RequestType.EDIT_USER, RequestType.REGISTER, "user_state", String.class),
    EDIT_FIELDS(RequestType.EDIT_USER, RequestType.REGISTER, "custom_fields", String.class),
    EDIT_ADD_GROUPS(RequestType.EDIT_USER, RequestType.REGISTER, "add_groups", String.class),
    EDIT_REM_GROUPS(RequestType.EDIT_USER, RequestType.REGISTER, "remove_groups", String.class),
    EDIT_TROPHY(RequestType.EDIT_USER, RequestType.REGISTER, "trophy_points", String.class),

    ADDON_NAME(RequestType.GET_ADDON, "value", String.class),
    ADDONS_TYPE(RequestType.GET_ADDONS, "type", String.class),

    ALERT_USER(RequestType.GET_ALERTS, "value", String.class),
    ALERT_TYPE(RequestType.GET_ALERTS, "type", String.class),

    CONVER_USER(RequestType.GET_CONVERSATIONS, "value", String.class),

    GROUP_ID(RequestType.GET_GROUP, "value", String.class),
    GROUP_ID_INT(RequestType.GET_GROUP, "value", Integer.class),

    NODE_ID(RequestType.GET_NODE, "value", Integer.class),
    NODE_TYPE(RequestType.GET_NODES, "node_type", String.class),

    POST_ID(RequestType.GET_POST, "value", Integer.class),

    //ToDo: getPosts by values

    AVATAR_USER(RequestType.GET_AVATAR, "value", String.class),
    AVATAR_SIZE(RequestType.GET_AVATAR, "size", Character.class);


    private static final RequestParam[] v = values();

    @Getter private final RequestType requestType;
    @Getter private final RequestType requestType2;
    @Getter private final String queryField;
    @Getter private final Class valueClass;
    private final Function<Object, String> valueSerializer;

    RequestParam(RequestType requestType, RequestType requestType2, String queryField, Class<?> valueClass) {
        this(requestType, requestType2, queryField, valueClass, null);
    }

    RequestParam(RequestType requestType, String queryField, Class<?> valueClass) {
        this(requestType, null, queryField, valueClass, null);
    }

    public String serialize(Object value) {
        return valueSerializer == null ? String.valueOf(value) : valueSerializer.apply(value);
    }
}