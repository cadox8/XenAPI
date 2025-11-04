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

package es.cadox8.xenapi.api.alerts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import es.cadox8.xenapi.api.auth.UserResponse;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.Data;

@Data
public class AlertResponse implements ApiResponse {

    @Expose
    @SerializedName("action")
    private String action;
    @Expose
    @SerializedName("alert_id")
    private int alertId;
    @Expose
    @SerializedName("alert_text")
    private String alertText;
    @Expose
    @SerializedName("alert_url")
    private String alertUrl;
    @Expose
    @SerializedName("alerted_user_id")
    private int alertedUserId;
    @Expose
    @SerializedName("auto_read")
    private boolean autoRead;
    @Expose
    @SerializedName("content_id")
    private int contentId;
    @Expose
    @SerializedName("content_type")
    private String contentType;
    @Expose
    @SerializedName("event_date")
    private long eventDate;
    @Expose
    @SerializedName("read_date")
    private long readDate;
    @Expose
    @SerializedName("User")
    private UserResponse user;
    @Expose
    @SerializedName("user_id")
    private int userId;
    @Expose
    @SerializedName("username")
    private String username;
    @Expose
    @SerializedName("view_date")
    private long viewDate;
}