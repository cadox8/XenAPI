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

package es.cadox8.xenapi.params.user;

import es.cadox8.xenapi.api.user.UserId;
import lombok.Builder;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

/**
 * <a href="https://xenforo.com/community/pages/api-endpoints/#route_get_users_id_">From Xenforo docs</a>:
 * <p>
 * Gets information about the specified user.
 */
@Builder
public class FindUserByIdParams {

    private final int userId;
    private final boolean withPosts;
    private final int page;

    public String guery() {
        return String.valueOf(this.userId);
    }

    public NameValuePair[] params() {
        final NameValuePair[] params = new NameValuePair[2];

        if (this.withPosts)
            params[0] = new BasicNameValuePair("with_posts", "true");

        if (this.page > 0)
            params[1] = new BasicNameValuePair("page", String.valueOf(this.page));

        return params;
    }

    public Class<UserId> type() {
        return UserId.class;
    }
}
