package es.cadox8.xenapi.exceptions;

public class NotAuthorizedException extends XenForoBadRequestException {
    public NotAuthorizedException(String message) {
        super(message);
    }

    public NotAuthorizedException() {
        this("Not authorized");
    }

    public NotAuthorizedException(String response, Throwable cause) {
        super(response, cause);
    }
}
