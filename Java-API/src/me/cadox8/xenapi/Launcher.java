package me.cadox8.xenapi;

import me.cadox8.xenapi.reply.NodeReply;
import me.cadox8.xenapi.request.Request;
import me.cadox8.xenapi.request.RequestBuilder;
import me.cadox8.xenapi.request.RequestParam;
import me.cadox8.xenapi.request.RequestType;
import me.cadox8.xenapi.utils.Callback;

public class Launcher {

    public static void main(String... args) {
        XenAPI api = new XenAPI();
        api.setToken("e65ef8da-ca6a-437c-ab8b-4b2e9e86cd10");
        api.setBaseURL("http://192.168.1.2/foro/");

        Request r = RequestBuilder.newBuilder(RequestType.GET_NODE).addParam(RequestParam.NODE_ID, 9).createRequest();

        System.out.println("Raw: " + XenAPI.getWebInfo(r.getURL(api)) + "\n\n");


        api.getAsync(r, (Callback<NodeReply>) (failCause, result)-> {
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
