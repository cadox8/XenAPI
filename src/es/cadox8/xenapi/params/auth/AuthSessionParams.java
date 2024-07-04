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

package es.cadox8.xenapi.params.auth;

import com.google.gson.JsonObject;
import es.cadox8.xenapi.api.user.FindEmail;
import lombok.Builder;

/**
 * <a href="https://xenforo.com/community/pages/api-endpoints/#route_post_auth_from_session">From Xenforo docs</a>:
 * <p>
 * Looks up the active XenForo user based on session ID or remember cookie value. This can be used to help with seamless SSO with XF, assuming the session or remember
 * cookies are available to your page. At least one of session_id and remember_cookie must be provided. Only available to super user keys.
 */
@Builder
public class AuthSessionParams {

    private final String sessionId;
    private final String rememberCookie;


    public Object body() {
        final JsonObject body = new JsonObject();

        if (!this.sessionId.isEmpty())
            body.addProperty("session_id", this.sessionId);

        if (!this.rememberCookie.isEmpty())
            body.addProperty("remember_cookie", this.rememberCookie);

        return body;
    }

    public Class<FindEmail> type() {
        return FindEmail.class;
    }
}