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
public class NodeReply extends AbstractReply {

    @Getter private int node_id;
    @Getter private String title;
    @Getter private String description;
    @Getter private String node_name;
    @Getter private String node_type_id;
    @Getter private int parent_node_id;
    @Getter private int display_order;
    @Getter private int display_in_list;
    @Getter private int lft;
    @Getter private int rgt;
    @Getter private int depth;
    @Getter private int style_id;
    @Getter private int effective_style_id;

    @Override
    public RequestType getRequestType() {
        return RequestType.EDIT_USER;
    }
}
