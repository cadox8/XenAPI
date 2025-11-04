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

package es.cadox8.xenapi.api.stats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.Data;

@Data
public class StatsResponse implements ApiResponse {

    @Expose
    @SerializedName("totals")
    private final Totals totals;
    @Expose
    @SerializedName("latest_user")
    private final LatestUser latestUser;
    @Expose
    @SerializedName("online")
    private final Online online;

    @Data
    public static class Totals {

        @Expose
        @SerializedName("threads")
        private final int threads;

        @Expose
        @SerializedName("messages")
        private final int messages;

        @Expose
        @SerializedName("users")
        private final int users;
    }

    @Data
    public static class LatestUser {
        @Expose
        @SerializedName("user_id")
        private final int userId;

        @Expose
        @SerializedName("username")
        private final String username;

        @Expose
        @SerializedName("register_date")
        private final int registerDate;
    }

    @Data
    public static class Online {
        @Expose
        @SerializedName("total")
        private final int total;
        @Expose
        @SerializedName("members")
        private final int members;
        @Expose
        @SerializedName("guests")
        private final int guests;
    }
}
