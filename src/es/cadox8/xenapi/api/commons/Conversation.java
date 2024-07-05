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
import kotlin.Pair;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Conversation {

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("recipients")
    private List<Pair<Integer, String>> recipients;

    @Expose
    @SerializedName("is_starred")
    private boolean isStarred;

    @Expose
    @SerializedName("is_unread")
    private boolean isUnread;

    @Expose
    @SerializedName("can_edit")
    private boolean canEdit;

    @Expose
    @SerializedName("can_reply")
    private boolean canReply;

    @Expose
    @SerializedName("can_invite")
    private boolean canInvite;

    @Expose
    @SerializedName("can_upload_attachment")
    private boolean canUploadAttachment;

    @Expose
    @SerializedName("view_url")
    private String viewUrl;

    @Expose
    @SerializedName("conversation_id")
    private int conversationId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("user_id")
    private int userId;

    @Expose
    @SerializedName("start_date")
    private int startDate;

    @Expose
    @SerializedName("open_invite")
    private boolean openInvite;

    @Expose
    @SerializedName("conversation_open")
    private boolean conversationOpen;

    @Expose
    @SerializedName("reply_count")
    private int replyCount;

    @Expose
    @SerializedName("recipient_count")
    private int recipientCount;

    @Expose
    @SerializedName("first_message_id")
    private int firstMessageId;

    @Expose
    @SerializedName("last_message_date")
    private int lastMessageDate;

    @Expose
    @SerializedName("last_message_id")
    private int lastMessageId;

    @Expose
    @SerializedName("last_message_user_id")
    private int lastMessageUserId;

    @Expose
    @SerializedName("starter")
    private User starter;
}
