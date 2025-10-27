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

package es.cadox8.xenapi.api.posts;

import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Adds a new reply to a thread.
 */
@Builder
public class PostReply implements ApiRequest<PostReplyResponse> {

    /**
     * Required
     */
    private final Integer threadId;
    /**
     * Required
     */
    private final String message;

    private final String attachmentKey;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.POSTS;
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
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.threadId == null || this.threadId <= 0)
            throw new XenForoMissingArgsException("threadId!");

        if (this.message == null || this.message.isEmpty())
            throw new XenForoMissingArgsException("message!");

        list.add(new XenNameValuePair("thread_id", this.threadId));
        list.add(new XenNameValuePair("message", this.message));

        if (this.attachmentKey != null && !this.attachmentKey.isEmpty())
            params().add(new XenNameValuePair("attachmentKey", this.attachmentKey));

        return list;
    }

    @Override
    public Class<PostReplyResponse> response() {
        return PostReplyResponse.class;
    }
}
