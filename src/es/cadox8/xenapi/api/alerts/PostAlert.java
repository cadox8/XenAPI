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

package es.cadox8.xenapi.api.alerts;

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
public class PostAlert implements ApiRequest<Success> {

    /**
     * Required. ID of the user to receive the alert
     */
    @Builder.Default private final int to_user_id = -1;
    /**
     * Required. Text of the alert. May use the placeholder "{link}" to have the link automatically inserted.
     */
    @Builder.Default private final String alert = "";
    /**
     * If provided, the user to send the alert from. Otherwise, uses the current API user. May be 0 for an anonymous alert.
     */
    private final int from_user_id;
    private final String link_url;
    private final String link_title;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.ALERTS;
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
        final List<XenNameValuePair> params = new ArrayList<>();

        if (this.to_user_id == -1 || this.alert.isEmpty())
            throw new XenForoMissingArgsException("to_user_id or alert!");

        params.add(new XenNameValuePair("to_user_id", this.to_user_id));
        params.add(new XenNameValuePair("alert", this.alert));
        params.add(new XenNameValuePair("from_user_id", this.from_user_id));

        if (this.link_url != null)
            params.add(new XenNameValuePair("link_url", this.link_url));
        if (this.link_title != null)
            params.add(new XenNameValuePair("link_title", this.link_title));

        return params;
    }

    @Override
    public Class<Success> response() {
        return Success.class;
    }
}
