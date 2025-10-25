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
import es.cadox8.xenapi.api.auth.UserResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
@Getter
public class Thread {

    @Expose
    @SerializedName("username")
    private String username;

    @Expose
    @SerializedName("is_watching")
    private boolean isWatching = false;

    @Expose
    @SerializedName("visitor_post_count")
    private int visitorPostCount = 0;

    @Expose
    @SerializedName("is_unread")
    private boolean isUnread = false;

    @Expose
    @SerializedName("custom_fields")
    private Map<String, String> customFields;

    @Expose
    @SerializedName("tags")
    private List<String> tags;

    @Expose
    @SerializedName("prefix")
    private String prefix = "";

    @Expose
    @SerializedName("can_edit")
    private boolean canEdit;

    @Expose
    @SerializedName("can_edit_tags")
    private boolean canEditTags;

    @Expose
    @SerializedName("can_reply")
    private boolean canReply;

    @Expose
    @SerializedName("can_soft_delete")
    private boolean canSoftDelete;

    @Expose
    @SerializedName("can_hard_delete")
    private boolean canHardDelete;

    @Expose
    @SerializedName("can_view_attachments")
    private boolean canViewAttachments;

    @Expose
    @SerializedName("view_url")
    private String viewUrl;

    @Expose
    @SerializedName("is_first_post_pinned")
    private boolean isFirstPostPinned;

    @Expose
    @SerializedName("highlighted_post_ids")
    private List<Integer> highlightedPostIds;

    @Expose
    @SerializedName("is_search_engine_indexable")
    private boolean isSearchEngineIndexable;

    @Expose
    @SerializedName("index_state")
    private String indexState = "";

    @Expose
    @SerializedName("Forum")
    private Node forum;

    @Expose
    @SerializedName("vote_score")
    private int voteScore = 0;

    @Expose
    @SerializedName("can_content_vote")
    private boolean canContentVote = false;

    @Expose
    @SerializedName("allowed_content_vote_types")
    private List<String> allowedContentVoteTypes;

    @Expose
    @SerializedName("is_content_voted")
    private boolean isContentVoted = false;

    @Expose
    @SerializedName("visitor_content_vote")
    private String visitorContentVote = "";

    @Expose
    @SerializedName("thread_id")
    private int threadId;

    @Expose
    @SerializedName("node_id")
    private int nodeId;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("reply_count")
    private int replyCount;

    @Expose
    @SerializedName("view_count")
    private int viewCount;

    @Expose
    @SerializedName("user_id")
    private int userId;

    @Expose
    @SerializedName("post_date")
    private int postDate;

    @Expose
    @SerializedName("sticky")
    private boolean sticky;

    @Expose
    @SerializedName("discussion_state")
    private String discussionState;

    @Expose
    @SerializedName("discussion_open")
    private boolean discussionOpen;

    @Expose
    @SerializedName("discussion_type")
    private String discussionType;

    @Expose
    @SerializedName("first_post_id")
    private int firstPostId;

    @Expose
    @SerializedName("last_post_date")
    private int lastPostDate;

    @Expose
    @SerializedName("last_post_id")
    private int lastPostId;

    @Expose
    @SerializedName("last_post_user_id")
    private int lastPostUserId;

    @Expose
    @SerializedName("last_post_username")
    private String lastPostUsername;

    @Expose
    @SerializedName("first_post_reaction_score")
    private int firstPostReactionScore;

    @Expose
    @SerializedName("prefix_id")
    private int prefixId;

    @Expose
    @SerializedName("User")
    private UserResponse user;
}
