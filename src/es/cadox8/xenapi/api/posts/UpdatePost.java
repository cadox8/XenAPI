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
import es.cadox8.xenapi.net.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Adds a new reply to a thread.
 */
@Builder
public class UpdatePost implements ApiRequest<PostReplyResponse> {

    /**
     * Required
     */
    private final Integer postId;

    // -----

    private final String message;
    @Builder.Default private final String authorAlertReason = "";
    private final String attachmentKey;
    @Builder.Default private final Boolean authorAlert = true;
    @Builder.Default private Boolean clearEdit = false;
    @Builder.Default private Boolean silent = false;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.POSTS_GET;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Object query() {
        if (this.postId == null || this.postId <= 0)
            throw new XenForoMissingArgsException("postId is missing!");

        return this.postId;
    }

    @Override
    public List<XenNameValuePair> params() {
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.message == null || this.message.isEmpty())
            throw new XenForoMissingArgsException("message is missing!");

        list.add(new XenNameValuePair("message", this.message));
        list.add(new XenNameValuePair("silent", this.silent));
        
        if (this.clearEdit && !this.silent)
            throw new XenForoMissingArgsException("For clearEdit you need silent");

        list.add(new XenNameValuePair("clear_edit", this.clearEdit));
        list.add(new XenNameValuePair("author_alert", this.authorAlert));
        list.add(new XenNameValuePair("author_alert_reason", this.authorAlertReason));

        if (this.attachmentKey != null && !this.attachmentKey.isEmpty())
            params().add(new XenNameValuePair("attachmentKey", this.attachmentKey));

        return list;
    }

    @Override
    public Class<PostReplyResponse> response() {
        return PostReplyResponse.class;
    }
}
