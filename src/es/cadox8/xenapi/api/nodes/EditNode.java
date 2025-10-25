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

package es.cadox8.xenapi.api.nodes;

import es.cadox8.xenapi.net.ApiRequest;
import es.cadox8.xenapi.net.HttpMethod;
import es.cadox8.xenapi.net.XenforoPaths;
import es.cadox8.xenapi.utils.XenNameValuePair;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class EditNode implements ApiRequest<NodesPost> {

    private final Integer id; // Required to edit

    private final String title;
    private final String name;
    private final String description;
    private final Integer parentNodeId;
    private final Integer displayOrder;
    @Builder.Default private final Boolean displayInList = true;
    private final List<String> typeData;

    @Override
    public XenforoPaths getPath() {
        return XenforoPaths.NODES_ACTIONS;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public Object query() {
        return this.id;
    }

    @Override
    public List<XenNameValuePair> params() {
        return List.of();
    }

    @Override
    public List<XenNameValuePair> body() {
        final List<XenNameValuePair> params = new ArrayList<>();

        if (this.title != null && !this.title.isEmpty())
            params.add(new XenNameValuePair("node[title]", this.title));

        if (this.name != null && !this.name.isEmpty())
            params.add(new XenNameValuePair("node[node_name]", this.name));

        if (this.description != null && !this.description.isEmpty())
            params.add(new XenNameValuePair("node[description]", this.description));

        if (this.parentNodeId != null && this.parentNodeId >= 0)
            params.add(new XenNameValuePair("node[parent_node_id]", this.parentNodeId));

        if (this.displayOrder != null && this.displayOrder >= 0)
            params.add(new XenNameValuePair("node[display_order]", this.displayOrder));

        if (this.displayInList != null)
            params.add(new XenNameValuePair("node[display_in_list]", this.displayInList));

        if (this.typeData != null && !this.typeData.isEmpty())
            params.add(new XenNameValuePair("type_data", this.typeData));

        return params;
    }

    @Override
    public Class<NodesPost> response() {
        return NodesPost.class;
    }
}
