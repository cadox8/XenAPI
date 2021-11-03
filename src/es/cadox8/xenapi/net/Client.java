package es.cadox8.xenapi.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.cadox8.xenapi.request.BaseRequest;
import es.cadox8.xenapi.response.BaseResponse;
import es.cadox8.xenapi.utils.Callback;
import java.net.http.HttpClient;

public class Client {

    private final HttpClient client;
    private final Gson gson;

    public Client() {
        this.client = HttpClient.newHttpClient();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> void send(final T request, final Callback<T, R> callback) {
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> R send(final BaseRequest<T, R> request) {
        return null;
    }
}
