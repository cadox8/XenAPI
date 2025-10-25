/*
 * Copyright (c) 2025
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

package es.cadox8.xenapi.api.conversation;

import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.net.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class GetConversations implements ApiRequest<ConversationsResponse> {

    private final int page;
    private final int starter_id;
    private final int receiver_id;
    private final boolean starred;
    private final boolean unread;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.CONVERSATIONS;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public Object query() {
        return null;
    }

    @Override
    public List<XenNameValuePair> params() {
        return new ArrayList<>();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> params = new ArrayList<>();

        if (this.page != -1)
            params.add(new XenNameValuePair("page", this.page));

        if (this.starter_id != -1)
            params.add(new XenNameValuePair("starter_id", this.starter_id));

        if (this.receiver_id != -1)
            params.add(new XenNameValuePair("receiver_id", this.receiver_id));

        if (this.starred)
            params.add(new XenNameValuePair("starred", true));

        if (this.unread)
            params.add(new XenNameValuePair("unread", true));

        return params;
    }

    @Override
    public Class<ConversationsResponse> response() {
        return ConversationsResponse.class;
    }
}


