package es.cadox8.xenapi.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.cadox8.xenapi.XenAPI;

@JsonIgnoreProperties(ignoreUnknown = true)
public class XenForoEntity {

    @JsonIgnore
    protected XenAPI xenAPIService;

    @SuppressWarnings("unchecked")
    public <T extends XenForoEntity> T setInternalXenAPI(XenAPI xenAPIService) {
        this.xenAPIService = xenAPIService;
        return (T) this;
    }

    protected XenAPI getXenAPIService() {
        if (xenAPIService == null) throw new IllegalStateException("The xenAPI not initialized. Please call setInternalXenAPI before.");
        return xenAPIService;
    }
}
