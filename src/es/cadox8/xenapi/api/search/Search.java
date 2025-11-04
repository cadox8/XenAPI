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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.Data;

import java.util.List;

@Data
public class Search implements ApiResponse {

    @Expose
    @SerializedName("search_id")
    private Integer searchId;

    @Expose
    @SerializedName("result_count")
    private Integer resultCount;

    @Expose
    @SerializedName("search_type")
    private String searchType;

    @Expose
    @SerializedName("search_query")
    private String searchQuery;

    @Expose
    @SerializedName("search_constraints")
    private List<String> searchConstraints;

    @Expose
    @SerializedName("search_order")
    private List<String> searchOrder;

    @Expose
    @SerializedName("search_grouping")
    private Boolean searchGrouping;

    @Expose
    @SerializedName("warnings")
    private List<String> warnings;

    @Expose
    @SerializedName("user_id")
    private Integer userId;

    @Expose
    @SerializedName("search_date")
    private Integer searchDate;

    @Expose
    @SerializedName("query_hash")
    private String queryHash;
}
