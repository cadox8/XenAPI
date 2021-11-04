package es.cadox8.xenapi;

import es.cadox8.xenapi.api.User;
import es.cadox8.xenapi.api.XenForoEntity;
import es.cadox8.xenapi.net.XenForoClient;
import es.cadox8.xenapi.net.XenForoUrl;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class XenAPIBuilder implements XenAPI {

    private final XenForoClient httpClient;
    private final String url;

    /**
     * Constructor for the XenAPI Builder
     *
     * @param url the url where XenForo is installed at
     * @param token The token you have to access
     */
    public XenAPIBuilder(String url, String token) {
        this(url, token, "");
    }

    /**
     * Constructor for the XenAPI Builder
     *
     * @param url the url where XenForo is installed at
     * @param token The token you have to access
     * @param user The user of the generated token
     *
     * You need to pass the user param if the token is for superuser
     */
    public XenAPIBuilder(String url, String token, String user) {
        this.url = url;
        this.httpClient = new XenForoClient(token, user);
    }

    //

    @Override
    public User me() {
        final User me = get(XenForoUrl.createUrlWithNoArgs(this.url, XenForoUrl.GET_ME), User.class);
        me.setInternalXenAPI(this);
        return me;
    }



    /* internal methods */

    private <T> T postFileForObject(String url, File file, Class<T> objectClass, String... params) {
        return httpClient.postFileForObject(url, file, objectClass, enrichParams(params));
    }

    private <T> T post(String url, Object object, Class<T> objectClass, String... params) {
        return httpClient.postForObject(url, object, objectClass, enrichParams(params));
    }

    private <T> T get(String url, Class<T> objectClass, String... params) {
        return httpClient.get(url, objectClass, enrichParams(params));
    }

    private <T> T put(String url, Object object, Class<T> objectClass, String... params) {
        return httpClient.putForObject(url, object, objectClass, enrichParams(params));
    }

    private <T> T delete(String url, Class<T> responseType, String... params) {
        return httpClient.delete(url, responseType, enrichParams(params));
    }

    private String[] enrichParams(String[] params) {
        final List<String> paramList = Arrays.asList(params);
        return paramList.toArray(new String[paramList.size()]);
    }

    private <T extends XenForoEntity> List<T> asList(Supplier<T[]> responseSupplier) {
        return Arrays.stream(responseSupplier.get()).peek(t -> t.setInternalXenAPI(this)).collect(Collectors.toList());
    }
}
