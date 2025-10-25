/*
 * Copyright (c) 2024-2025
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

package es.cadox8.xenapi.api.attachment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AttachmentResponse implements ApiResponse {

    @Expose
    @SerializedName("filename")
    private String filename;

    @Expose
    @SerializedName("file_size")
    private int fileSize;

    @Expose
    @SerializedName("height")
    private int height;

    @Expose
    @SerializedName("width")
    private int width;

    @Expose
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    @Expose
    @SerializedName("direct_url")
    private String directUrl;

    @Expose
    @SerializedName("is_video")
    private boolean isVideo;

    @Expose
    @SerializedName("is_audio")
    private boolean isAudio;

    @Expose
    @SerializedName("attachment_id")
    private int attachmentId;

    @Expose
    @SerializedName("content_type")
    private String contentType;

    @Expose
    @SerializedName("content_id")
    private int contentId;

    @Expose
    @SerializedName("attach_date")
    private int attachDate;

    @Expose
    @SerializedName("view_count")
    private int viewCount;
}
