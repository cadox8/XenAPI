package me.cadox8.xenapi.reply;

import com.google.gson.JsonElement;
import lombok.Getter;
import me.cadox8.xenapi.request.RequestType;

public class AvatarReply extends AbstractReply {

    @Getter private JsonElement avatar;

    @Override
    public RequestType getRequestType() {
        return RequestType.AVATAR;
    }
}
