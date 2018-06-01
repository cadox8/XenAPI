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

package me.cadox8.xenapi;

import me.cadox8.xenapi.reply.PostReply;
import me.cadox8.xenapi.request.Request;
import me.cadox8.xenapi.request.RequestBuilder;
import me.cadox8.xenapi.request.RequestParam;
import me.cadox8.xenapi.request.RequestType;
import me.cadox8.xenapi.utils.Callback;

public class Launcher {

    public static void main(String... args) {
        XenAPI api = new XenAPI();
        api.setToken("e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10");
        api.setBaseURL("http://192.168.1.2/foro");

        Request r = RequestBuilder.newBuilder(RequestType.GET_POST).addParam(RequestParam.POST_ID, 1).createRequest();

        System.out.println("URL: " + r.getURL(api));
        System.out.println("Raw: " + XenAPI.getWebInfo(r.getURL(api)) + "\n\n");


        api.getReply(r, (Callback<PostReply>) (failCause, result)-> {
            if (result.getError() != 0) {
                System.out.println("Error (" + result.getError() + "): " + result.getMessage());
                return;
            }

            if (failCause != null) {
                failCause.printStackTrace();
            } else {
                System.out.println("Result: " + result.getTitle());
            }
        });
    }
}
