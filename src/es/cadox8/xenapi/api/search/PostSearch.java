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

import es.cadox8.xenapi.api.commons.Order;
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
public class PostSearch implements ApiRequest<BasicSearch> {

    private final String searchType;
    private final String keywords;
    /**
     * ?????
     */
    private final List<String> c;

    private final Order order;
    @Builder.Default private final Boolean grouped = false;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.SEARCH;
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

        if (this.searchType != null && !this.searchType.isEmpty())
            list.add(new XenNameValuePair("search_type", this.searchType));

        if (this.keywords != null && !this.keywords.isEmpty())
            list.add(new XenNameValuePair("keywords", this.keywords));

        if (this.c != null && !this.c.isEmpty())
            list.add(new XenNameValuePair("c", this.c));

        if (this.order != null)
            list.add(new XenNameValuePair("order", this.order.getOrder()));

        if (this.grouped != null)
            list.add(new XenNameValuePair("grouped", this.grouped));

        return list;
    }

    @Override
    public Class<BasicSearch> response() {
        return BasicSearch.class;
    }
}
