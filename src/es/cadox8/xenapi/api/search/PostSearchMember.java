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

import es.cadox8.xenapi.api.commons.TypeNodeId;
import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.utils.XenAPIExperimental;
import es.cadox8.xenapi.utils.XenNameValuePair;
import es.cadox8.xenapi.utils.XenforoPaths;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
@XenAPIExperimental(XenAPIExperimental.Status.UNTESTED)
public class PostSearchMember implements ApiRequest<BasicSearch> {

    private final Integer userId;
    private final String content;
    private final String type;
    private final Integer before;
    private final TypeNodeId threadType;
    @Builder.Default private final Boolean grouped = false;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.SEARCH_MEMBER;
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

        if (this.userId == null)
            throw new XenForoMissingArgsException("userId");

        list.add(new XenNameValuePair("user_id", this.userId));

        if (this.content != null && !this.content.isEmpty())
            list.add(new XenNameValuePair("content", this.content));

        if (this.type != null && !this.type.isEmpty())
            list.add(new XenNameValuePair("type", this.type));

        if (this.before != null)
            list.add(new XenNameValuePair("before", this.before));

        if (this.threadType != null)
            list.add(new XenNameValuePair("thread_type", this.threadType.getNodeType()));

        if (this.grouped != null)
            list.add(new XenNameValuePair("grouped", this.grouped));

        return list;
    }

    @Override
    public Class<BasicSearch> response() {
        return BasicSearch.class;
    }
}
