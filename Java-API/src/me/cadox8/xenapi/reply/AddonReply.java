package me.cadox8.xenapi.reply;

import lombok.Getter;
import me.cadox8.xenapi.request.RequestType;

public class AddonReply extends AbstractReply {

    @Getter private Addon addon;

    @Override
    public RequestType getRequestType() {
        return RequestType.GET_ADDON;
    }


    public class Addon {

        @Getter private int id;
        @Getter private String title;
        @Getter private String version;
        @Getter private boolean enabled;
        @Getter private String url;
    }
}
