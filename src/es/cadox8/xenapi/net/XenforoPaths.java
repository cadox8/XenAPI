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
    GET_USERS("/users"),
    GET_USERS_EMAIL("/users/find-email"),
    GET_USERS_NAME("/users/find-name"),
    USERS_ID("/users/{id}"),
    USER_AVATAR("/users/{id}/avatar"),
    PROFILE_POSTS("/users/{id}/profile-posts"),
    ALERTS("/alerts/{id}"),
    ALERTS_MARK("/alerts/mark-all"),
    AUTH("/auth"),
    AUTH_SESSION("/auth/from-session"),
    LOGIN_TOKEN("/auth/login-token");

    private final String path;
}
