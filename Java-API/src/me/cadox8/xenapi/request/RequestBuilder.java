package me.cadox8.xenapi.request;

import me.cadox8.xenapi.exceptions.ParamTypeException;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private RequestType requestType = null;
    private Map<RequestParam, Object> params = new HashMap<>();

    private RequestBuilder(RequestType requestType) {
        if (!params.isEmpty()) params.clear();
        this.requestType = requestType;
    }

    public static RequestBuilder newBuilder(RequestType requestType) {
        return new RequestBuilder(requestType);
    }

    public RequestBuilder addParam(RequestParam param, Object value) {
        if (!validate(param, value)) throw new ParamTypeException(param, value);
        this.params.put(param, value);
        return this;
    }

    /**
     * Validate value for param, making sure it is of
     * the correct RequestParam type and
     * can be used for given RequestType
     */
    private boolean validate(RequestParam param, Object value) {
        if (value != null && value.getClass().equals(param.getValueClass())) {
            return param.getRequestType() == requestType;
        }
        return false;
    }

    /**
     * Builds a request from the builder
     */
    public Request createRequest() {
        return new Request(requestType, params);
    }
}
