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
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class GetConversation implements ApiRequest<ConversationCreateResponse> {

    private final int conversation_id;
    private final String message;
    /**
     * API attachment key to upload files. Attachment key content type must be conversation_message with context[conversation_id] set to this conversation ID.
     */
    private final String attachment_key;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.CONVERSATION_MSG;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
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

        params.add(new XenNameValuePair("conversation_id", this.conversation_id));
        params.add(new XenNameValuePair("message", this.message));

        if (!this.attachment_key.isEmpty())
            params.add(new XenNameValuePair("attachment_key", this.attachment_key));

        return params;
    }

    @Override
    public Class<ConversationCreateResponse> response() {
        return ConversationCreateResponse.class;
    }
}


