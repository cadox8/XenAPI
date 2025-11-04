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

package es.cadox8.xenapi.api.profile;

import es.cadox8.xenapi.api.commons.Success;
import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class DeleteProfilePost implements ApiRequest<Success> {

    /**
     * Required
     */
    private final Integer profileId;

    // -----

    private final String reason;
    @Builder.Default private final Boolean hardDelete = false;
    @Builder.Default private final Boolean authorAlert = true;
    @Builder.Default private final String authorAlertReason = "";

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.PROFILE_POST_ID;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    public Object query() {
        if (this.profileId == null || this.profileId <= 0)
            throw new XenForoMissingArgsException("profileId!");

        return this.profileId;
    }

    @Override
    public List<XenNameValuePair> params() {
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> list = new ArrayList<>();

        if (this.reason == null || this.reason.isEmpty())
            throw new XenForoMissingArgsException("reason!");

        list.add(new XenNameValuePair("reason", this.reason));
        list.add(new XenNameValuePair("hard_delete", this.hardDelete));
        list.add(new XenNameValuePair("author_alert", this.authorAlert));
        list.add(new XenNameValuePair("author_alert_reason", this.authorAlertReason));

        return list;
    }

    @Override
    public Class<Success> response() {
        return Success.class;
    }
}
