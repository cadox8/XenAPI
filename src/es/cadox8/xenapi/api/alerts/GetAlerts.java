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

import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class GetAlerts implements ApiRequest<AllAlertResponse> {

    /**
     *
     */
    private final int page;
    /**
     * Unix timestamp of the oldest alert to include. Note that unread or unviewed alerts are always included.
     */
    private final int cutoff;
    /**
     * If true, gets only unviewed alerts. Unviewed alerts have not been seen (in the standard UI).
     */
    private final boolean unviewed;
    /**
     * If true, gets only unread alerts. Unread alerts may have been seen but the content they relate to has not been viewed.
     */
    private final boolean unread;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.ALERTS;
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
        final List<XenNameValuePair> params = new ArrayList<>();

        if (this.cutoff > 0)
            params.add(new XenNameValuePair("cutoff", this.cutoff));

        if (this.page > 0)
            params.add(new XenNameValuePair("page", this.page));

        params.add(new XenNameValuePair("unviewed", this.unviewed));
        params.add(new XenNameValuePair("unread", this.unread));
        return params;
    }

    @Override
    public List<XenNameValuePair> body() {
        return new ArrayList<>();
    }

    @Override
    public Class<AllAlertResponse> response() {
        return AllAlertResponse.class;
    }
}
