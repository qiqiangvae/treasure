package online.qiqiang.treasure.common.vo;

import lombok.Data;
import online.qiqiang.forest.common.exception.ErrorCode;
import online.qiqiang.forest.common.exception.IErrorCode;

/**
 * @author qiqiang
 */
@Data
public class Response<T> {
    private int code;
    private T data;
    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(T data) {
        this.data = data;
        this.code = ErrorCode.SUCCESS.getCode();
        this.message = ErrorCode.SUCCESS.getMessage();
    }

    public Response(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static Response<String> code(IErrorCode errorCode) {
        return new Response<>(errorCode.getCode(), errorCode.getMessage());
    }
}
