package me.cadox8.xenapi.request;

import lombok.Getter;
import lombok.Setter;
import me.cadox8.xenapi.XenAPI;

import java.util.Map;

public class Request {

    @Getter @Setter private static String BASE_URL = "https://localhost/";

    @Getter private final RequestType requestType;
    @Getter private final Map<RequestParam, Object> params;

    public Request(RequestType requestType, Map<RequestParam, Object> params) {
        this.requestType = requestType;
        this.params = params;
    }

    public String getURL(XenAPI xenAPI) {
        String url = BASE_URL + "api.php?action=";

        url += requestType.getKey() + "&";

        for (Map.Entry<RequestParam, Object> entry : params.entrySet()) {
            url += entry.getKey().getQueryField() + "=" + entry.getKey().serialize(entry.getValue()) + "&";
        }

        url += "hash=" + xenAPI.getToken();

        return url;
    }
}
