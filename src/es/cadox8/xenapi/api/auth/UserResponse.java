/*
 * Copyright (c) 2021-2025
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

package es.cadox8.xenapi.api.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import es.cadox8.xenapi.api.commons.AvatarUrls;
import es.cadox8.xenapi.api.commons.ProfileBannerUrls;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * User class
 */
@Data
@AllArgsConstructor
public class UserResponse implements ApiResponse {

    @Expose
    @SerializedName("success")
    private boolean success;

    @Expose
    @SerializedName("user")
    private UserData user;

    @Data
    @AllArgsConstructor
    public static class UserData {

        @Expose
        @SerializedName("about")
        private String about;

        @Expose
        @SerializedName("activity_visible")
        private boolean activityVisible;

        @Expose
        @SerializedName("age")
        private int age;

        @Expose
        @SerializedName("alert_optout")
        private List<Object> alertOptout;

        @Expose
        @SerializedName("allow_post_profile")
        private String allowPostProfile;

        @Expose
        @SerializedName("allow_receive_news_feed")
        private String allowReceiveNewsFeed;

        @Expose
        @SerializedName("allow_send_personal_conversation")
        private String allowSendPersonalConversation;

        @Expose
        @SerializedName("allow_view_identities")
        private String allowViewIdentities;

        @Expose
        @SerializedName("allow_view_profile")
        private String allowViewProfile;

        @Expose
        @SerializedName("avatar_urls")
        private AvatarUrls avatarUrls;

        @Expose
        @SerializedName("can_ban")
        private boolean canBan;

        @Expose
        @SerializedName("can_converse")
        private boolean canConverse;

        @Expose
        @SerializedName("can_edit")
        private boolean canEdit;

        @Expose
        @SerializedName("can_follow")
        private boolean canFollow;

        @Expose
        @SerializedName("can_ignore")
        private boolean canIgnore;

        @Expose
        @SerializedName("can_post_profile")
        private boolean canPostProfile;

        @Expose
        @SerializedName("can_view_profile")
        private boolean canViewProfile;

        @Expose
        @SerializedName("can_view_profile_posts")
        private boolean canViewProfilePosts;

        @Expose
        @SerializedName("can_warn")
        private boolean canWarn;

        @Expose
        @SerializedName("content_show_signature")
        private boolean contentShowSignature;

        @Expose
        @SerializedName("creation_watch_state")
        private String creationWatchState;

        @Expose
        @SerializedName("custom_fields")
        private Map<String, Object> customFields;

        @Expose
        @SerializedName("custom_title")
        private String customTitle;

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("email_on_conversation")
        private boolean emailOnConversation;

        @Expose
        @SerializedName("gravatar")
        private String gravatar;

        @Expose
        @SerializedName("interaction_watch_state")
        private String interactionWatchState;

        @Expose
        @SerializedName("is_admin")
        private boolean isAdmin;

        @Expose
        @SerializedName("is_banned")
        private boolean isBanned;

        @Expose
        @SerializedName("is_discouraged")
        private boolean isDiscouraged;

        @Expose
        @SerializedName("is_followed")
        private boolean isFollowed;

        @Expose
        @SerializedName("is_ignored")
        private boolean isIgnored;

        @Expose
        @SerializedName("is_moderator")
        private boolean isModerator;

        @Expose
        @SerializedName("is_staff")
        private boolean isStaff;

        @Expose
        @SerializedName("is_super_admin")
        private boolean isSuperAdmin;

        @Expose
        @SerializedName("last_activity")
        private long lastActivity;

        @Expose
        @SerializedName("location")
        private String location;

        @Expose
        @SerializedName("message_count")
        private int messageCount;

        @Expose
        @SerializedName("profile_banner_urls")
        private ProfileBannerUrls profileBannerUrls;

        @Expose
        @SerializedName("push_on_conversation")
        private boolean pushOnConversation;

        @Expose
        @SerializedName("push_optout")
        private List<Object> pushOptout;

        @Expose
        @SerializedName("question_solution_count")
        private int questionSolutionCount;

        @Expose
        @SerializedName("reaction_score")
        private int reactionScore;

        @Expose
        @SerializedName("receive_admin_email")
        private boolean receiveAdminEmail;

        @Expose
        @SerializedName("register_date")
        private long registerDate;

        @Expose
        @SerializedName("secondary_group_ids")
        private List<Integer> secondaryGroupIds;

        @Expose
        @SerializedName("show_dob_date")
        private boolean showDobDate;

        @Expose
        @SerializedName("show_dob_year")
        private boolean showDobYear;

        @Expose
        @SerializedName("signature")
        private String signature;

        @Expose
        @SerializedName("timezone")
        private String timezone;

        @Expose
        @SerializedName("trophy_points")
        private int trophyPoints;

        @Expose
        @SerializedName("usa_tfa")
        private boolean usaTfa;

        @Expose
        @SerializedName("use_tfa")
        private boolean useTfa;

        @Expose
        @SerializedName("user_group_id")
        private int userGroupId;

        @Expose
        @SerializedName("user_id")
        private int userId;

        @Expose
        @SerializedName("user_state")
        private String userState;

        @Expose
        @SerializedName("user_title")
        private String userTitle;

        @Expose
        @SerializedName("username")
        private String username;

        @Expose
        @SerializedName("view_url")
        private String viewUrl;

        @Expose
        @SerializedName("visible")
        private boolean visible;

        @Expose
        @SerializedName("vote_score")
        private int voteScore;

        @Expose
        @SerializedName("warning_points")
        private int warningPoints;

        @Expose
        @SerializedName("website")
        private String website;
    }
}
