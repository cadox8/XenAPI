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

package es.cadox8.xenapi.api.profile.comments;

import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class UpdateProfilePostComments implements ApiRequest<ProfilePostCommentsResponse> {

    /**
     * Required
     */
    private final Integer profilePostId;

    /**
     * Required
     */
    private final String message;
    @Builder.Default private final String authorAlertReason = "";
    @Builder.Default private final Boolean authorAlert = true;

    private final String attachmentKey;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.PROFILE_POST_COMMENTS_ID;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Object query() {
        if (this.profilePostId == null || this.profilePostId <= 0)
            throw new XenForoMissingArgsException("profilePostId!");

        return this.profilePostId;
    }

    @Override
    public List<XenNameValuePair> params() {
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.message == null || this.message.isEmpty())
            throw new XenForoMissingArgsException("message!");

        list.add(new XenNameValuePair("message", this.message));

        list.add(new XenNameValuePair("author_alert", this.authorAlert));
        list.add(new XenNameValuePair("author_alert_reason", this.authorAlertReason));

        if (this.attachmentKey != null && !this.attachmentKey.isEmpty())
            params().add(new XenNameValuePair("attachmentKey", this.attachmentKey));

        return list;
    }

    @Override
    public Class<ProfilePostCommentsResponse> response() {
        return ProfilePostCommentsResponse.class;
    }
}
