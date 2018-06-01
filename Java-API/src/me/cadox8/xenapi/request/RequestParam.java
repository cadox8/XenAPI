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

    EDIT_USER(RequestType.EDIT_USER, "username", String.class),
    EDIT_PASS(RequestType.EDIT_USER, "password", String.class),
    EDIT_EMAIL(RequestType.EDIT_USER, "email", String.class),
    EDIT_GROUP(RequestType.EDIT_USER, "group", String.class),
    EDIT_GENDER(RequestType.EDIT_USER, "gender", String.class),
    EDIT_TITLE(RequestType.EDIT_USER, "custom_title", String.class),
    EDIT_STYLE(RequestType.EDIT_USER, "style_id", Integer.class),
    EDIT_TIMEZONE(RequestType.EDIT_USER, "timezone", String.class),
    EDIT_VISIBLE(RequestType.EDIT_USER, "visible", Integer.class),
    EDIT_DOB_DAY(RequestType.EDIT_USER, "dob_day", Integer.class),
    EDIT_DOB_MONTH(RequestType.EDIT_USER, "dob_month", Integer.class),
    EDIT_DOB_YEAR(RequestType.EDIT_USER, "dob_year", Integer.class),
    EDIT_STATE(RequestType.EDIT_USER, "user_state", String.class),
    EDIT_FIELDS(RequestType.EDIT_USER, "custom_fields", String.class),
    EDIT_ADD_GROUPS(RequestType.EDIT_USER, "add_groups", String.class),
    EDIT_REM_GROUPS(RequestType.EDIT_USER, "remove_groups", String.class),
    EDIT_TROPHY(RequestType.EDIT_USER, "trophy_points", String.class),

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

    AVATAR_USER(RequestType.AVATAR, "value", String.class),
    AVATAR_SIZE(RequestType.AVATAR, "size", Character.class);


    private static final RequestParam[] v = values();

    @Getter private final RequestType requestType;
    @Getter private final String queryField;
    @Getter private final Class valueClass;
    private final Function<Object, String> valueSerializer;

    RequestParam(RequestType requestType, String queryField, Class<?> valueClass) {
        this(requestType, queryField, valueClass, null);
    }

    public String serialize(Object value) {
        return valueSerializer == null ? String.valueOf(value) : valueSerializer.apply(value);
    }
}