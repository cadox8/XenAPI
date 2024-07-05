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
import es.cadox8.xenapi.api.auth.LoginToken;
import lombok.Builder;
import lombok.NonNull;

@Builder
public class LoginTokenParams {

    /**
     * Required
     */
    @NonNull private final int userId;
    
    private final String limitIp;
    private final String returnUrl;
    private final boolean force = false;
    private final boolean remember = false;

    public Object body() {
        final JsonObject body = new JsonObject();
        body.addProperty("user_id", userId);

        if (!this.limitIp.isEmpty())
            body.addProperty("limit_ip", this.limitIp);
        if (!this.returnUrl.isEmpty())
            body.addProperty("return_url", this.returnUrl);
        if (this.force)
            body.addProperty("force", true);
        if (this.remember)
            body.addProperty("remember", true);

        return body;
    }

    public Class<LoginToken> type() {
        return LoginToken.class;
    }
}
