package es.cadox8.xenapi.request;

import es.cadox8.xenapi.response.BaseResponse;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseRequest<T extends BaseRequest<T, R>, R extends BaseResponse> {

    @SuppressWarnings("unchecked")
    protected final T thisAsT = (T) this;

    private final Class<? extends R> responseClass;
    @Getter private final Map<String, Object> parameters;

    public BaseRequest(Class<? extends R> responseClass) {
        this.responseClass = responseClass;
        this.parameters = new LinkedHashMap<>();
    }

    protected T add(String name, Object val) {
        parameters.put(name, val);
        return thisAsT;
    }

    protected T addAll(Map<String, Object> values) {
        parameters.putAll(values);
        return thisAsT;
    }

    public String getMethod() {
        String className = this.getClass().getSimpleName();
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    public Class<? extends R> getResponseType() {
        return responseClass;
    }

    public boolean isMultipart() {
        return false;
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public int getTimeoutSeconds() {
        return 0;
    }
}
