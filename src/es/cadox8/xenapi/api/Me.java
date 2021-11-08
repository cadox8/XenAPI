/*
 * Copyright (c) 2021-2021.
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class Me extends User {

    public Me(String about, boolean activity_visible, int age, Object[] alert_optout, String allow_post_profile, String allow_receive_news_feed, String allow_send_personal_conversation, String allow_view_identities, String allow_view_profile, AvatarUrls[] avatar_urls, Object[] profile_banner_urls, boolean can_ban, boolean can_converse, boolean can_edit, boolean can_follow, boolean can_ignore, boolean can_post_profile, boolean can_view_profile, boolean can_view_profile_posts, boolean can_warn, boolean content_show_signature, String creation_watch_state, Map<String, String> custom_fields, String custom_title, Date dob, String email, boolean email_on_conversation, String gravatar, boolean interaction_watch_state, boolean is_admin, boolean is_banned, boolean is_discouraged) {
        super(about, activity_visible, age, alert_optout, allow_post_profile, allow_receive_news_feed, allow_send_personal_conversation, allow_view_identities, allow_view_profile, avatar_urls, profile_banner_urls, can_ban, can_converse, can_edit, can_follow, can_ignore, can_post_profile, can_view_profile, can_view_profile_posts, can_warn, content_show_signature, creation_watch_state, custom_fields, custom_title, dob, email, email_on_conversation, gravatar, interaction_watch_state, is_admin, is_banned, is_discouraged);
    }
}
