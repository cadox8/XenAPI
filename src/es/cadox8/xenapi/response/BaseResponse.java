package es.cadox8.xenapi.response;

import lombok.Data;

@Data
public abstract class BaseResponse {

    private ErrorBody[] errors;

    @Data
    private static class ErrorBody {
        private String code;
        private String message;
        private String[] params;
    }
}
