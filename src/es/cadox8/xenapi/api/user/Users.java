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

package es.cadox8.xenapi.api.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import es.cadox8.xenapi.api.commons.AvatarUrls;
import es.cadox8.xenapi.api.commons.Pagination;
import es.cadox8.xenapi.api.commons.ProfileBannerUrls;
import es.cadox8.xenapi.net.ApiResponse;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;


@Getter
@ToString
public class Users implements ApiResponse {
    @Expose private List<UsersData> users;
    @Expose private Pagination pagination;

    @Getter
    @ToString
    public static class UsersData {
        @Expose
        @SerializedName("activity_visible")
        private boolean activityVisible;

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
        @SerializedName("custom_fields")
        private Map<String, Object> customFields;

        @Expose
        @SerializedName("custom_title")
        private String customTitle;

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
        @SerializedName("question_solution_count")
        private int questionSolutionCount;

        @Expose
        @SerializedName("reaction_score")
        private int reactionScore;

        @Expose
        @SerializedName("register_date")
        private long registerDate;

        @Expose
        @SerializedName("secondary_group_ids")
        private List<Integer> secondaryGroupIds;

        @Expose
        @SerializedName("signature")
        private String signature;

        @Expose
        @SerializedName("trophy_points")
        private int trophyPoints;

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
