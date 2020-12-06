/*
 *  Copyright (c) 2018.
 *
 *  This file is part of XenAPI <https://github.com/cadox8/XenAPI>.
 *
 *  XenAPI is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  XenAPI is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.cadox8.xenapi.reply;

import lombok.Getter;
import lombok.ToString;
import me.cadox8.xenapi.request.RequestType;

@ToString
public class RegisterReply extends AbstractReply {

    @Getter private String avatar_crop_x;
    @Getter private String trophy_points;
    @Getter private String visible;
    @Getter private String location;
    @Getter private String facebook_auth_id;
    @Getter private String show_dob_date;
    @Getter private String avatar_height;
    @Getter private String language_id;
    @Getter private String username;
    @Getter private String timezone;
    @Getter private String register_date;
    @Getter private String display_style_group_id;
    @Getter private String gravatar;
    @Getter private String avatar_width;
    @Getter private String gender;
    @Getter private String default_watch_state;
    @Getter private String signature;
    @Getter private String avatar_crop_y;
    @Getter private String dob_day;
    @Getter private String custom_title;
    @Getter private String occupation;
    @Getter private String status;
    @Getter private String is_discouraged;
    @Getter private String last_activity;
    @Getter private String user_state;
    @Getter private String homepage;
    @Getter private String scheme_class;
    @Getter private String email;
    @Getter private String status_profile_post_id;
    @Getter private String enable_rte;
    @Getter private String status_date;
    @Getter private String style_id;
    @Getter private String ignored;
    @Getter private String allow_receive_news_feed;
    @Getter private String avatar_date;
    @Getter private String dob_month;
    @Getter private String data;
    @Getter private String about;
    @Getter private String allow_send_personal_conversation;
    @Getter private String csrf_token;
    @Getter private String following;
    @Getter private String email_on_conversation;
    @Getter private String dob_year;
    @Getter private String alert_optout;
    @Getter private String alerts_unread;
    @Getter private String conversations_unread;
    @Getter private String permission_combination_id;
    @Getter private String user_id;
    @Getter private String receive_admin_email;
    @Getter private String message_count;
    @Getter private String user_group_id;
    @Getter private String custom_fields;
    @Getter private String remember_key;
    @Getter private String allow_view_identities;
    @Getter private String allow_post_profile;
    @Getter private String is_banned;
    @Getter private String is_moderator;
    @Getter private String content_show_signature;
    @Getter private String warning_points;
    @Getter private String show_dob_year;
    @Getter private String is_admin;
    @Getter private String like_count;
    @Getter private String secondary_group_ids;
    @Getter private String allow_view_profile;

    @Override
    public RequestType getRequestType() {
        return RequestType.GET_AVATAR;
    }
}
