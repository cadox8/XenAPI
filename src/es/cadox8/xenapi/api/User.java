/*
 * Copyright (c) 2021.
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

package es.cadox8.xenapi.api;

import es.cadox8.xenapi.api.user.AvatarUrls;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Map;

/**
 * User class
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends XenForoEntity {

    private String about;
    private boolean activity_visible;
    private int age;
    private Object[] alert_optout;
    private String allow_post_profile;
    private String allow_receive_news_feed;
    private String allow_send_personal_conversation;
    private String allow_view_identities;
    private String allow_view_profile;

    private AvatarUrls[] avatar_urls;
    private Object[] profile_banner_urls;

    private boolean can_ban;
    private boolean can_converse;
    private boolean can_edit;
    private boolean can_follow;
    private boolean can_ignore;
    private boolean can_post_profile;
    private boolean can_view_profile;
    private boolean can_view_profile_posts;
    private boolean can_warn;
    private boolean content_show_signature;

    private String creation_watch_state;
    private Map<String, String> custom_fields;
    private String custom_title;
    private Date dob;

    private String email;
    private boolean email_on_conversation;

    private String gravatar;

    private boolean interaction_watch_state;
    private boolean is_admin;
    private boolean is_banned;
    private boolean is_discouraged;
}
