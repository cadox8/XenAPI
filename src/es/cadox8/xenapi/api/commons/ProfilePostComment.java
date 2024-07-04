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
import es.cadox8.xenapi.api.models.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProfilePostComment {

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
    @SerializedName("Attachments")
    private Attachment[] attachments;

    @Expose
    @SerializedName("ProfilePost")
    private ProfilePost profilePost;

    @Expose
    @SerializedName("is_reacted_to")
    private boolean isReactedTo;

    @Expose
    @SerializedName("visitor_reaction_id")
    private int visitorReactionId;

    @Expose
    @SerializedName("profile_post_comment_id")
    private int profilePostCommentId;

    @Expose
    @SerializedName("profile_post_id")
    private int profilePostId;

    @Expose
    @SerializedName("user_id")
    private int userId;

    @Expose
    @SerializedName("comment_date")
    private int commentDate;

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
    @SerializedName("reaction_score")
    private int reactionScore;

    @Expose
    @SerializedName("User")
    private User user;
}
