package me.cadox8.xenapi.reply;

import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import me.cadox8.xenapi.request.RequestType;

import java.lang.reflect.Type;

public class EditUserReply extends AbstractReply {

    @Getter private Type type = new TypeToken<String>() {}.getType();

    @Getter private String json;

    @Override
    public RequestType getRequestType() {
        return RequestType.EDIT_USER;
    }
}
