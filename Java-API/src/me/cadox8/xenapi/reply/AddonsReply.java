package me.cadox8.xenapi.reply;

import lombok.Getter;
import me.cadox8.xenapi.request.RequestType;

import java.util.List;

public class AddonsReply extends AbstractReply {

    @Getter private int count;
    @Getter private List<Addon> addons;

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
