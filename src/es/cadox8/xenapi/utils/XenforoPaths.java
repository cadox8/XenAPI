/*
 * Copyright (c) 2024-2025
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

package es.cadox8.xenapi.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum XenforoPaths {
    ALERTS("/alerts"),
    ALERT("/alerts/{id}"),
    ALERTS_MARK("/alerts/mark-all"),
    ALERT_MARK("/alerts/{id}/mark"),
    ATTACHMENTS("/attachments"),
    ATTACHMENTS_NEW_KEY("/attachments/new-key"),
    AUTH("/auth"),
    AUTH_SESSION("/auth/from-session"),
    LOGIN_TOKEN("/auth/login-token"),
    CONVERSATION_MSG("/conversation-messages"),
    CONVERSATION_MSG_GET("/conversation-messages/{id}"),
    CONVERSATION_MSG_REACT("/conversation-messages/{id}/react"),
    CONVERSATIONS("/conversations"),
    CONVERSATIONS_ID("/conversations/{id}"),
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
    ME_AVATAR("/me/avatar"),
    ME_EMAIL("/me/email"),
    ME_PASSWORD("/me/password"),
    NODES("/nodes"),
    NODES_FLAT("/nodes/flattened"),
    NODES_ACTIONS("/nodes/{id}"),
    GET_USERS("/users"),
    GET_USERS_EMAIL("/users/find-email"),
    GET_USERS_NAME("/users/find-name"),
    USERS_ID("/users/{id}"),
    USER_AVATAR("/users/{id}/avatar"),
    PROFILE_POSTS("/users/{id}/profile-posts"),

    POSTS("/posts"),
    POSTS_GET("/posts/{id}"),
    POST_MARK_SOLUTION("/posts/{id}/mark-solution"),
    POST_REACT("/posts/{id}/react"),
    POST_VOTE("/posts/{id}/vote"),

    PROFILE_POST("/profile-posts"),
    PROFILE_POST_ID("/profile-posts/{id}"),
    PROFILE_POST_ID_COMMENTS("/profile-posts/{id}"),
    PROFILE_POST_COMMENTS("/profile-post-comments"),
    PROFILE_POST_COMMENTS_ID("/profile-post-comments/{id}"),
    PROFILE_POST_COMMENTS_REACT("/profile-post-comments/{id}/react"),

    STATS("/stats"),

    SEARCH("/search"),
    SEARCH_MEMBER("/search/member"),
    SEARCH_ID("/search/{id}"),
    SEARCH_ID_OLDER("/search/{id}/older"),
    SEARCH_FORUMS("/search-forums/{id}"),
    SEARCH_FORUMS_THREADS("/search-forums/{id}/threads");

    private final String path;
}
