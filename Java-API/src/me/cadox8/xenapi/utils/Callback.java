package me.cadox8.xenapi.utils;

import me.cadox8.xenapi.reply.AbstractReply;

@FunctionalInterface
public interface Callback<T extends AbstractReply> {

    void callback(Throwable failCause, T result);
}
