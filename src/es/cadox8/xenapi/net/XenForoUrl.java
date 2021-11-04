package es.cadox8.xenapi.net;

import es.cadox8.xenapi.utils.Argument;

public class XenForoUrl {

    //
    public static final String GET_ME = "/me";
    //

    private final String baseUrl;
    private final String api_url;

    private Argument[] args = {};

    private XenForoUrl(String api_url, String baseUrl) {
        this.api_url = api_url;
        this.baseUrl = baseUrl;
    }

    public static XenForoUrl createUrl(String api_url, String baseUrl) {
        return new XenForoUrl(api_url, baseUrl);
    }

    public static String createUrlWithNoArgs(String api_url, String baseUrl) {
        return api_url + baseUrl;
    }

    public XenForoUrl params(Argument... args) {
        this.args = args;
        return this;
    }

    public String asString() {
        final StringBuilder builder = new StringBuilder(this.api_url);
        builder.append(baseUrl);
        for (Argument arg : args) {
            builder.append("&");
            builder.append(arg.getArgName());
            builder.append("=");
            builder.append(arg.getArgValue());
        }
        return builder.toString();
    }
}
