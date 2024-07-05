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

package es.cadox8.xenapi.params.conversation;

import es.cadox8.xenapi.api.conversation.Conversations;
import lombok.Builder;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;

@Builder
public class ConversationsParams {

    private final int page;
    private final int starterId;
    private final int receiverId;
    private final boolean starred;
    private final boolean unread;

    public NameValuePair[] query() {
        final NameValuePair[] query = new NameValuePair[5];

        if (this.page > 0)
            query[0] = new BasicNameValuePair("page", String.valueOf(this.page));
        if (this.starterId > 0)
            query[1] = new BasicNameValuePair("starter_id", String.valueOf(this.starterId));
        if (this.receiverId > 0)
            query[2] = new BasicNameValuePair("receiver_id", String.valueOf(this.receiverId));

        if (this.starred)
            query[3] = new BasicNameValuePair("starred", String.valueOf(true));
        if (this.unread)
            query[4] = new BasicNameValuePair("unread", String.valueOf(true));

        return query;
    }

    public Class<Conversations> type() {
        return Conversations.class;
    }
}
