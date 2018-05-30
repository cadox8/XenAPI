package me.cadox8.xenapi.exceptions;

public class XenAPIException extends RuntimeException {

    public XenAPIException() {
    }

    public XenAPIException(String message) {
        super(message);
    }

    public XenAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public XenAPIException(Throwable cause) {
        super(cause);
    }

    public XenAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
