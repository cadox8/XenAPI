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

package es.cadox8.xenapi.api.commons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class Node {

    @Expose
    @SerializedName("breadcrumbs")
    private List<Breadcrumbs> breadcrumbs;

    @Expose
    @SerializedName("view_url")
    private String viewUrl;

    @Expose
    @SerializedName("node_id")
    private int nodeId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("node_name")
    private String nodeName;

    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("node_type_id")
    private String nodeTypeId;

    @Expose
    @SerializedName("parent_node_id")
    private int parentNodeId;

    @Expose
    @SerializedName("display_order")
    private int displayOrder;

    @Expose
    @SerializedName("display_in_list")
    private boolean displayInList;

    @ToString
    @Getter
    public static class Breadcrumbs {
        @Expose
        @SerializedName("node_id")
        private int nodeId;

        @Expose
        @SerializedName("title")
        private String title;

        @Expose
        @SerializedName("node_type_id")
        private int nodeTypeId;
    }
}
