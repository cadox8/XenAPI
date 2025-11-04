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

import es.cadox8.xenapi.api.commons.Sort;
import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class GetProfilePost implements ApiRequest<GetProfilePostsResponse> {

    /**
     * Required
     */
    private final Integer profileId;

    @Builder.Default private final Boolean withComments = true;
    @Builder.Default private final Sort sort = Sort.DESC;
    private final Integer page;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.PROFILE_POST_ID;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public Object query() {
        if (this.profileId == null || this.profileId <= 0)
            throw new XenForoMissingArgsException("profileId!");

        return this.profileId;
    }

    @Override
    public List<XenNameValuePair> params() {
        final List<XenNameValuePair> params = new ArrayList<>();

        if (this.page > 0)
            params.add(new XenNameValuePair("page", this.page));

        params.add(new XenNameValuePair("with_comments", this.withComments));
        params.add(new XenNameValuePair("direction", this.sort.getDirection()));
        return params;
    }

    @Override
    public List<XenNameValuePair> body() {
        return List.of();
    }

    @Override
    public Class<GetProfilePostsResponse> response() {
        return GetProfilePostsResponse.class;
    }
}
