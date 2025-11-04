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
import es.cadox8.xenapi.api.attachment.AttachmentResponse;
import es.cadox8.xenapi.api.auth.UserResponse;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.Data;

import java.util.List;

@Data
public class ProfilePost implements ApiResponse {

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("message_parsed")
    private String messageParsed;

    @Expose
    @SerializedName("can_edit")
    private boolean canEdit;

    @Expose
    @SerializedName("can_soft_delete")
    private boolean canSoftDelete;

    @Expose
    @SerializedName("can_hard_delete")
    private boolean canHardDelete;

    @Expose
    @SerializedName("can_react")
    private boolean canReact;

    @Expose
    @SerializedName("can_view_attachments")
    private boolean canViewAttachments;

    @Expose
    @SerializedName("view_url")
    private String viewUrl;

    @Expose
    @SerializedName("ProfileUser")
    private UserResponse profileUser;

    @Expose
    @SerializedName("Attachments")
    private List<AttachmentResponse> attachments;

    @Expose
    @SerializedName("LatestComments")
    private List<ProfilePostComment> latestComments;

    @Expose
    @SerializedName("is_reacted_to")
    private boolean isReactedTo;

    @Expose
    @SerializedName("visitor_reaction_id")
    private int visitorReactionId;

    @Expose
    @SerializedName("profile_post_id")
    private int profilePostId;

    @Expose
    @SerializedName("profile_user_id")
    private int profileUserId;

    @Expose
    @SerializedName("user_id")
    private int userId;

    @Expose
    @SerializedName("post_date")
    private int postDate;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("message_state")
    private String messageState;

    @Expose
    @SerializedName("warning_message")
    private String warningMessage;

    @Expose
    @SerializedName("comment_count")
    private int commentCount;

    @Expose
    @SerializedName("first_comment_date")
    private int firstCommentDate;

    @Expose
    @SerializedName("last_comment_date")
    private int lastCommentDate;

    @Expose
    @SerializedName("reaction_score")
    private int reactionScore;

    @Expose
    @SerializedName("User")
    private UserResponse user;
}
