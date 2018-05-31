package me.cadox8.xenapi.exceptions;

import me.cadox8.xenapi.request.RequestParam;

public class ParamTypeException extends XenAPIException {

    public ParamTypeException(RequestParam requestParam, Object value) {
        super(requestParam.name() + " is not of correct type! " +
                "Expected " +
                "'" + requestParam.getValueClass().getSimpleName() + "'" +
                " but got " +
                "'" + (value == null ? "null" : value.getClass().getSimpleName()) + "'"
        );
    }
}
