package com.tonglu.genealogy.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 业务异常
 * <p>
 *
 * @author liusiyuan
 * @since 2023-05-19
 */
@Setter
@Getter
public class ServiceException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String msg;

    /**
     * 返回此可抛出对象的详细消息字符串
     *
     * @return
     */
    @Override
    public String getMessage() {
        return msg;
    }

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException() {
    }
}
