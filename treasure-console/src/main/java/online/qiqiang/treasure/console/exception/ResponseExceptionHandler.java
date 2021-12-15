package online.qiqiang.treasure.console.exception;

import cn.dev33.satoken.exception.NotBasicAuthException;
import lombok.extern.slf4j.Slf4j;
import online.qiqiang.forest.common.exception.BusinessException;
import online.qiqiang.treasure.common.vo.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qiqiang
 */
@RestControllerAdvice
@Slf4j
public class ResponseExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Response<Void> businessExceptionHandle(BusinessException businessException) {
        return new Response<>(businessException.getCode(), businessException.getMessage());
    }

    @ExceptionHandler(NotBasicAuthException.class)
    public void businessExceptionHandle(NotBasicAuthException notBasicAuthException) {
        log.error(notBasicAuthException.getMessage());
    }
}
