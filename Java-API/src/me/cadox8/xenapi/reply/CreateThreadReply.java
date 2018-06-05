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
public class CreateThreadReply extends AbstractReply {

    @Getter private String tags;
    @Getter private String last_post_user_id;
    @Getter private String reply_count;
    @Getter private String first_post_likes;
    @Getter private String node_id;
    @Getter private String last_post_id;
    @Getter private String sticky;
    @Getter private String username;
    @Getter private String title;
    @Getter private String discussion_open;
    @Getter private String discussion_state;
    @Getter private String discussion_type;
    @Getter private String user_id;
    @Getter private String last_post_date;
    @Getter private String view_count;
    @Getter private String thread_id;
    @Getter private String first_post_id;
    @Getter private String prefix_id;
    @Getter private String post_date;
    @Getter private String last_post_username;

    @Override
    public RequestType getRequestType() {
        return RequestType.CREATE_ALERT;
    }
}
