package es.cadox8.xenapi.utils;

import es.cadox8.xenapi.request.BaseRequest;
import es.cadox8.xenapi.response.BaseResponse;

import java.io.IOException;

public interface Callback<T extends BaseRequest<T, R>, R extends BaseResponse> {

    void onResponse(T request, R response);
    void onFailure(T request, IOException e);
}
