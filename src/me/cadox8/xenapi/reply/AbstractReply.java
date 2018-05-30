package me.cadox8.xenapi.reply;

import lombok.Getter;
import me.cadox8.xenapi.request.RequestType;

public abstract class AbstractReply {

    @Getter protected int error = 0;
    @Getter protected String message;

    public abstract RequestType getRequestType();

    @Override
    public String toString() {
        return "AbstractReply{error=" + error + ", message=" + message + "'}";
    }
}
