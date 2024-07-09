/*
 * Copyright (c) 2024
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

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum XenforoPaths {
    ALERTS("/alerts/{id}"),
    ALERTS_MARK("/alerts/mark-all"),
    ALERT_MARK("/alerts/{id}/mark"),
    ATTACHMENTS("/attachments"),
    ATTACHMENTS_NEW_KEY("/attachments/new-key"),
    AUTH("/auth"),
    AUTH_SESSION("/auth/from-session"),
    LOGIN_TOKEN("/auth/login-token"),
    CONVERSATION_MSG("/conversation-messages/{id}"),
    CONVERSATION_MSG_REACT("/conversation-messages/{id}/react"),
    CONVERSATIONS("/conversations/{id}"),
    CONVERSATIONS_INVITE("/conversations/{id}/invite"),
    CONVERSATIONS_MARK_READ("/conversations/{id}/mark-read"),
    CONVERSATIONS_MARK_UNREAD("/conversations/{id}/mark-unread"),
    CONVERSATIONS_MESSAGES("/conversations/{id}/messages"),
    CONVERSATIONS_STAR("/conversations/{id}/star"),
    FORUMS("/forums/{id}"),
    FORUMS_MARK_READ("/forums/{id}/mark-read"),
    FORUMS_THREADS("/forums/{id}/threads"),
    INDEX("/index"),
    ME("/me"),
    GET_USERS("/users"),
    GET_USERS_EMAIL("/users/find-email"),
    GET_USERS_NAME("/users/find-name"),
    USERS_ID("/users/{id}"),
    USER_AVATAR("/users/{id}/avatar"),
    PROFILE_POSTS("/users/{id}/profile-posts");

    private final String path;
}
