package me.cadox8.xenapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.cadox8.xenapi.reply.*;

@AllArgsConstructor
public enum RequestType {

    AUTHENTICATE("authenticate", AuthenticateReply.class),
    EDIT_USER("editUser", EditUserReply.class),
    GET_ADDON("getAddon", AddonReply.class),
    GET_ADDONS("getAddons", AddonsReply.class),
    //GET_ACCTIONS("getActions"), Nope :D
    GET_ALERTS("getAlerts"),
    GET_CONVERSATIONS("getConversations"),
    GET_GROUP("getGroup"),
    GET_NODE("getNode", NodeReply.class),
    GET_NODES("getNodes"),
    GET_POST("getPost"),
    AVATAR("getAvatar", AvatarReply.class);

    @Getter private final String key;
    @Getter private final Class<? extends AbstractReply> replyClass;

    RequestType(String key) {
        this.key = key;
        this.replyClass = null;
    }
}
