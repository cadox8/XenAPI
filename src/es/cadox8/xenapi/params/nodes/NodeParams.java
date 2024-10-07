/*
 * Copyright (c) 2024
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

package es.cadox8.xenapi.params.nodes;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.constraint.CharSequenceConstraint;
import am.ik.yavi.core.Constraint;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import es.cadox8.xenapi.api.commons.TypeNodeId;
import es.cadox8.xenapi.exceptions.XenForoMissingArgsException;
import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Builder
@ToString
public class NodeParams {

    private String title;
    private String nodeName;
    private String description;
    private int parentNodeId;
    private int displayOrder;
    private boolean displayInList;

    private List<String> typeData;
    private TypeNodeId nodeTypeId;

    public String body() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        final JsonObject body = new JsonObject();
        final JsonObject node = new JsonObject();

        node.addProperty("title", this.title);

        if (!this.nodeName.isEmpty())
            node.addProperty("node_name", this.nodeName);
        if (!this.description.isEmpty())
            node.addProperty("description", this.description);

        node.addProperty("parent_node_id", this.parentNodeId);

        if (this.displayOrder != -1)
            node.addProperty("display_order", this.displayOrder);
        if (this.displayInList)
            node.addProperty("display_in_list", this.displayInList);

        body.add("node", node);

        if (this.typeData == null)
            this.typeData = new ArrayList<>();

        if (!this.typeData.isEmpty()) {
            final JsonArray typesData = new JsonArray();
            this.typeData.forEach(typesData::add);

            body.add("type_data", typesData);
        }

        body.addProperty("node_type_id", this.nodeTypeId.getNodeType());

        this.valid();

        return gson.toJson(body);
    }

    /**
     * Validate
     */
    private void valid() {
        final Validator<NodeParams> val = ValidatorBuilder.<NodeParams>of()._string(x -> x.title, "title", CharSequenceConstraint::notEmpty)._integer(x -> x.parentNodeId, "parentNodeId", c -> c.greaterThanOrEqual(1))._enum(x -> x.nodeTypeId, "nodeTypeId", Constraint::notNull).build();
        final ConstraintViolations violations = val.validate(this);

        if (!violations.isEmpty()) {
            final StringBuilder sb = new StringBuilder("An error occurred while validating: " + this.getClass().getSimpleName());
            sb.append('\n');
            violations.forEach(a -> sb.append(a.message()).append(" | "));
            sb.deleteCharAt(sb.length() - 2);
            throw new XenForoMissingArgsException(sb.toString());
        }
    }
}
