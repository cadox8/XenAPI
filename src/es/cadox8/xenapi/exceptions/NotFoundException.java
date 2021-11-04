package es.cadox8.xenapi.exceptions;

import es.cadox8.xenapi.api.XenForoEntity;

public class NotFoundException extends XenForoBadRequestException {
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
