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

package es.cadox8.xenapi.params.forums;

import es.cadox8.xenapi.api.forums.Threads;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

@Builder
public class ThreadsParams {

    @NonNull
    @Getter
    private final int forumId;

    private final int page;
    private final int prefixId;
    private final int staterId;
    private final int lastDays;
    private final boolean unread;
    private final String threadType;

    private final OrderBy order;
    private final Direction direction;

    public NameValuePair[] params() {
        final NameValuePair[] params = new NameValuePair[8];

        if (this.page > 0)
            params[0] = new BasicNameValuePair("page", String.valueOf(this.page));

        if (this.prefixId > 0)
            params[1] = new BasicNameValuePair("prefix_id", String.valueOf(this.prefixId));

        if (this.staterId > 0)
            params[2] = new BasicNameValuePair("starter_id", String.valueOf(this.staterId));

        if (this.lastDays > 0)
            params[3] = new BasicNameValuePair("last_days", String.valueOf(this.lastDays));

        if (this.unread)
            params[4] = new BasicNameValuePair("unread", "true");

        if (!this.threadType.isEmpty())
            params[5] = new BasicNameValuePair("thread_type", this.threadType);

        if (this.order != OrderBy.NONE)
            params[6] = new BasicNameValuePair("order", this.order.name().toLowerCase());

        if (this.direction != Direction.NONE)
            params[7] = new BasicNameValuePair("direction", this.direction.name().toLowerCase());

        return params;
    }

    public Class<Threads> type() {
        return Threads.class;
    }

    public enum OrderBy {
        LAST_POST_DATE,
        POST_DATE,
        TITLE,
        REPLY_COUNT,
        VIEW_COUNT,
        VOTE_SCORE,
        FIRST_POST_REACTION_SCORE,
        NONE
    }

    public enum Direction {
        ASC,
        DESC,
        NONE
    }
}
