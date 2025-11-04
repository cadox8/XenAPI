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

package es.cadox8.xenapi.api.nodes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import es.cadox8.xenapi.api.commons.Node;
import es.cadox8.xenapi.api.commons.TypeNodeId;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter

public class NodesFlat implements ApiResponse {

    @Expose
    @SerializedName("nodes_flat")
    private List<FlatNode> nodes;

    @ToString
    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class FlatNode {

        @Expose
        @SerializedName("breadcrumbs")
        private List<Node.Breadcrumbs> breadcrumbs;

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
        private TypeNodeId nodeTypeId;

        @Expose
        @SerializedName("display_order")
        private int displayOrder;

        @Expose
        @SerializedName("display_in_list")
        private boolean displayInList;

        @Expose
        @SerializedName("type_data")
        private TypeData typeData;
    }

    @ToString
    @Getter
    @EqualsAndHashCode(callSuper = false)
    public static class TypeData {
        @Expose
        @SerializedName("allow_posting")
        private boolean allowPosting;

        @Expose
        @SerializedName("can_create_thread")
        private boolean canCreateThread;

        @Expose
        @SerializedName("can_upload_attachment")
        private boolean canUploadAttachment;


    }
}


