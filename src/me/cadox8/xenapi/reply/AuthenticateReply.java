package me.cadox8.xenapi.reply;

import com.google.gson.JsonElement;
import lombok.Getter;
import me.cadox8.xenapi.request.RequestType;

public class AuthenticateReply extends AbstractReply {

    @Getter private JsonElement hash;

    @Override
    public RequestType getRequestType() {
        return RequestType.AUTHENTICATE;
    }
}
