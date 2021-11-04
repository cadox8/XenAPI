package es.cadox8.xenapi.exceptions;

public class XenForoHttpException extends RuntimeException {

    public XenForoHttpException() {}

    public XenForoHttpException(String message) {
        super(message);
    }

    public XenForoHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public XenForoHttpException(Throwable cause) {
        super(cause);
    }

    public XenForoHttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
