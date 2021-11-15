package online.qiqiang.treasure.console.exception;

import online.qiqiang.forest.common.exception.BusinessException;
import online.qiqiang.treasure.common.vo.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qiqiang
 */
@RestControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Response<Void> businessExceptionHandle(BusinessException businessException) {
        return new Response<>(businessException.getCode(), businessException.getMessage());
    }
}
