/*
 * Copyright (c) 2-125
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

import java.util.ArrayList;
import java.util.List;

@Data
public class Post implements ApiResponse {

    @Expose
    @SerializedName("username")
    private String username = "";

    @Expose
    @SerializedName("is_first_post")
    private Boolean isFirstPost = false;

    @Expose
    @SerializedName("is_last_post")
    private Boolean isLastPost = false;

    @Expose
    @SerializedName("is_unread")
    private Boolean isUnread = false;

    @Expose
    @SerializedName("message_parsed")
    private String htmlMessage = "";

    @Expose
    @SerializedName("can_edit")
    private Boolean canEdit = false;

    @Expose
    @SerializedName("can_soft_delete")
    private Boolean canSoftDelete = false;

    @Expose
    @SerializedName("can_hard_delete")
    private Boolean canHardDelete = false;

    @Expose
    @SerializedName("can_react")
    private Boolean canReact = false;

    @Expose
    @SerializedName("can_view_attachments")
    private Boolean canViewAttachments = false;

    @Expose
    @SerializedName("view_url")
    private String viewUrl = "";

    @Expose
    @SerializedName("Thread")
    private Thread thread;

    @Expose
    @SerializedName("Attachments")
    private List<AttachmentResponse> attachments = new ArrayList<>();

    @Expose
    @SerializedName("is_reacted_to")
    private Boolean hasReactedTo = false;

    @Expose
    @SerializedName("visitor_reaction_id")
    private Integer visitorReactionId = -1;

    @Expose
    @SerializedName("vote_score")
    private Integer voteScore = -1;

    @Expose
    @SerializedName("can_content_vote")
    private Boolean canVote = false;

    @Expose
    @SerializedName("allowed_content_vote_types")
    private List<String> allowedContentVoteTypes = new ArrayList<>();

    @Expose
    @SerializedName("is_content_voted")
    private Boolean isContentVoted = false;

    @Expose
    @SerializedName("visitor_content_vote")
    private String visitorContentVote = "";

    @Expose
    @SerializedName("post_id")
    private Integer postId = -1;

    @Expose
    @SerializedName("thread_id")
    private Integer threadId = -1;

    @Expose
    @SerializedName("user_id")
    private Integer userId = -1;

    @Expose
    @SerializedName("post_date")
    private Integer postDate = -1;

    @Expose
    @SerializedName("message")
    private String message = "";

    @Expose
    @SerializedName("message_state")
    private String messageState = "";

    @Expose
    @SerializedName("attach_count")
    private Integer attachCount = -1;

    @Expose
    @SerializedName("warning_message")
    private String warningMessage = "";

    @Expose
    @SerializedName("position")
    private Integer position = -1;

    @Expose
    @SerializedName("reaction_score")
    private Integer reactionScore = -1;

    @Expose
    @SerializedName("User")
    private UserResponse.UserData user = null;
}
