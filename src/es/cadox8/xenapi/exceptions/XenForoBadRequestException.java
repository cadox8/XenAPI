package es.cadox8.xenapi.exceptions;

public class XenForoBadRequestException extends RuntimeException {
    public XenForoBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public XenForoBadRequestException(String message) {
        super(message);
    }

    public XenForoBadRequestException(Throwable cause) {
        super(cause);
    }
}
