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
public class PostReply extends AbstractReply {

    @Getter private String tags;
    @Getter private String position;
    @Getter private String warning_message;
    @Getter private String last_edit_date;
    @Getter private String like_users;
    @Getter private String node_title;
    @Getter private String post_id;
    @Getter private String node_id;
    @Getter private String message;
    @Getter private String title;
    @Getter private String last_edit_user_id;
    @Getter private String username;
    @Getter private String message_html;
    @Getter private String attach_count;
    @Getter private String likes;
    @Getter private String absolute_url;
    @Getter private String user_id;
    @Getter private String message_state;
    @Getter private String warning_id;
    @Getter private String node_name;
    @Getter private String thread_id;
    @Getter private String edit_count;
    @Getter private String post_date;
    @Getter private String ip_id;

    @Override
    public RequestType getRequestType() {
        return RequestType.GET_POST;
    }
}
