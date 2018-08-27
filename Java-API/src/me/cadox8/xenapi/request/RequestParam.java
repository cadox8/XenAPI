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

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum RequestParam {

    AUTH_USER("username", String.class, RequestType.LOGIN, RequestType.AUTHENTICATE),
    AUTH_PASS("password", String.class, RequestType.LOGIN, RequestType.AUTHENTICATE),
    AUTH_IP("ip_address", String.class, RequestType.LOGIN, RequestType.AUTHENTICATE),

    CREATE_ALERT_USER("user", String.class, RequestType.CREATE_ALERT),
    CREATE_ALERT_CAUSE_USER("cause_user", String.class, RequestType.CREATE_ALERT),
    CREATE_ALERT_CONTENT_TYPE("content_type", String.class, RequestType.CREATE_ALERT),
    CREATE_ALERT_CONTENT_ID("content_id", Integer.class, RequestType.CREATE_ALERT),
    CREATE_ALERT_ALERT_ACTION("alert_action", String.class, RequestType.CREATE_ALERT),

    CREATE_POST_THREAD_ID("thread_id", Integer.class, RequestType.CREATE_POST),
    CREATE_POST_MESSAGE("message", String.class, RequestType.CREATE_POST),

    CREATE_THREAD_TITLE("title", String.class, RequestType.CREATE_THREAD),
    CREATE_THREAD_MESSAGE("message", String.class, RequestType.CREATE_THREAD),
    CREATE_THREAD_NODE_ID("node_id", Integer.class, RequestType.CREATE_THREAD),
    CREATE_THREAD_PREFIX_ID("prefix_id", Integer.class, RequestType.CREATE_THREAD),
    CREATE_THREAD_DISCUSSION_OPEN("discussion_open", Integer.class, RequestType.CREATE_THREAD),
    CREATE_THREAD_DISCUSSION_STATE("discussion_state", String.class, RequestType.CREATE_THREAD),
    CREATE_THREAD_STICKY("sticky", Integer.class, RequestType.CREATE_THREAD),

    EDIT_USER("username", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_PASS("password", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_EMAIL("email", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_GROUP("group", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_GENDER("gender", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_TITLE("custom_title", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_STYLE("style_id", Integer.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_TIMEZONE("timezone", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_VISIBLE("visible", Integer.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_DOB_DAY("dob_day", Integer.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_DOB_MONTH("dob_month", Integer.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_DOB_YEAR("dob_year", Integer.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_STATE("user_state", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_FIELDS("custom_fields", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_ADD_GROUPS("add_groups", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_REM_GROUPS("remove_groups", String.class, RequestType.EDIT_USER, RequestType.REGISTER),
    EDIT_TROPHY("trophy_points", String.class, RequestType.EDIT_USER, RequestType.REGISTER),

    VALUE_STRING("value", String.class, RequestType.GET_ADDON, RequestType.GET_ALERTS, RequestType.GET_CONVERSATIONS, RequestType.GET_GROUP, RequestType.GET_AVATAR),
    VALUE_INTEGER("value", Integer.class, RequestType.GET_NODE, RequestType.GET_GROUP),

    TYPE_STRING("type", String.class, RequestType.GET_ADDONS, RequestType.GET_ALERTS),

    AVATAR_SIZE("size", Character.class, RequestType.GET_AVATAR);

    //ToDo: getPosts by values


    @Getter private final List<RequestType> requestsType;
    @Getter private final String queryField;
    @Getter private final Class valueClass;
    private final Function<Object, String> valueSerializer;

    RequestParam(String queryField, Class<?> valueClass, RequestType... requestType) {
        this.requestsType = Arrays.asList(requestType);
        this.queryField = queryField;
        this.valueClass = valueClass;
        this.valueSerializer = null;
    }

    public String serialize(Object value) {
        return valueSerializer == null ? String.valueOf(value) : valueSerializer.apply(value);
    }
}