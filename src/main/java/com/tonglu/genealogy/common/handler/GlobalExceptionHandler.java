package com.tonglu.genealogy.common.handler;

import com.tonglu.genealogy.common.core.entity.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 全局异常处理器
 * <p>
 *
 * @author yuanzi
 * @since 2023-05-17
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求方式不支持
     *
     * @param exception
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public RestResult<Exception> handleException(HttpRequestMethodNotSupportedException exception) {
        log.error(exception.getMessage(), exception);
        return RestResult.fail("不支持'" + exception.getMethod() + "'请求");
    }

    /**
     * 自定义参数绑定验证异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public RestResult<Exception> validExceptionHandler(BindException exception) {
        log.error(exception.getMessage(), exception);
        String defaultMessage = exception.getAllErrors().get(0).getDefaultMessage();
        return RestResult.fail(defaultMessage);
    }

    /**
     * 未知的运行异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public RestResult<Exception> runtimeExceptionHandler(RuntimeException exception) {
        log.error(exception.getMessage(), exception);
        return RestResult.fail("服务异常！");
    }

    /**
     * 系统异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public RestResult<Exception> systemExceptionHandler(Exception exception) {
        log.error(exception.getMessage(), exception);
        return RestResult.fail("系统异常！");
    }


}
