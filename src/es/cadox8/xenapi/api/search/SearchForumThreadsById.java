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

package es.cadox8.xenapi.api.search;

import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenAPIExperimental;
import es.cadox8.xenapi.utils.XenNameValuePair;
import es.cadox8.xenapi.utils.XenforoPaths;
import lombok.Builder;

import java.util.List;

@Builder
@XenAPIExperimental(XenAPIExperimental.Status.UNTESTED)
public class SearchForumThreadsById implements ApiRequest<SearchForumThreadsResponse> {

    private final Integer id;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.SEARCH_FORUMS_THREADS;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public Object query() {
        if (this.id == null)
            throw new XenForoMissingArgsException("id");
        return this.id;
    }

    @Override
    public List<XenNameValuePair> params() {
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        return List.of();
    }

    @Override
    public Class<SearchForumThreadsResponse> response() {
        return SearchForumThreadsResponse.class;
    }
}
