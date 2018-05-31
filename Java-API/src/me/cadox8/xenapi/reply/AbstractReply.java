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
import me.cadox8.xenapi.request.RequestType;

public abstract class AbstractReply {

    @Getter protected int error = 0;
    @Getter protected String message;

    /**
     * Gets the type of requests to get the Reply Class
     *
     * @return Returns the type of Request
     *
     * @see RequestType
     * @see RequestType#getReplyClass()
     */
    public abstract RequestType getRequestType();

    @Override
    public String toString() {
        return "AbstractReply{error=" + error + ", message=" + message + "'}";
    }
}
