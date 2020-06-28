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
public class ActionsReply extends AbstractReply {

    @Getter private String createconversationreply;
    @Getter private String getuserupgrade;
    @Getter private String edituser;
    @Getter private String getaddon;
    @Getter private String createalert;
    @Getter private String getconversations;
    @Getter private String getprofilepost;
    @Getter private String authenticate;
    @Getter private String getactions;
    @Getter private String search;
    @Getter private String getuser;
    @Getter private String getresources;
    @Getter private String getnodes;
    @Getter private String getresourcecategories;
    @Getter private String createthread;
    @Getter private String upgradeuser;
    @Getter private String editpost;
    @Getter private String getprofileposts;
    @Getter private String login;
    @Getter private String getstats;
    @Getter private String createpost;
    @Getter private String getconversation;
    @Getter private String getalerts;
    @Getter private String getnode;
    @Getter private String getthread;
    @Getter private String getusers;
    @Getter private String getuserupgrades;
    @Getter private String createconversation;
    @Getter private String editthread;
    @Getter private String deleteuser;
    @Getter private String getthreads;
    @Getter private String deletepost;
    @Getter private String createprofilepost;
    @Getter private String downgradeuser;
    @Getter private String register;
    @Getter private String getposts;
    @Getter private String createprofilepostcomment;
    @Getter private String logout;
    @Getter private String getgroup;
    @Getter private String getpost;
    @Getter private String getresource;
    @Getter private String getavatar;
    @Getter private String getaddons;


    @Override
    public RequestType getRequestType() {
        return RequestType.GET_ACTIONS;
    }
}
