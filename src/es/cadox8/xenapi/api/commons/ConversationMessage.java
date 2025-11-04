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
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class ConversationMessage implements ApiResponse {

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("is_unread")
    private boolean isUnread;

    @Expose
    @SerializedName("message_parsed")
    private String messageParsed;

    @Expose
    @SerializedName("can_edit")
    private boolean canEdit;

    @Expose
    @SerializedName("can_react")
    private boolean canReact;

    @Expose
    @SerializedName("view_url")
    private String viewUrl;

    @Expose
    @SerializedName("Conversation")
    private Conversation conversation;

    @Expose
    @SerializedName("Attachments")
    private List<AttachmentResponse> attachments;

    @Expose
    @SerializedName("is_reacted_to")
    private boolean isReactedTo;

    @Expose
    @SerializedName("visitor_reaction_id")
    private int visitorReactionId;

    @Expose
    @SerializedName("message_id")
    private int messageId;

    @Expose
    @SerializedName("conversation_id")
    private int conversationId;

    @Expose
    @SerializedName("message_date")
    private int messageDate;

    @Expose
    @SerializedName("user_id")
    private int userId;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("attach_count")
    private int attachCount;

    @Expose
    @SerializedName("reaction_score")
    private int reactionScore;

    @Expose
    @SerializedName("User")
    private UserResponse user;
}
