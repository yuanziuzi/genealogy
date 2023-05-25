package com.tonglu.genealogy.common.core.entity;

import static com.tonglu.genealogy.common.core.constant.ResponseCodeConstant.*;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * 响应信息主体
 * <p>
 *
 * @author: yuanzi
 * @date:   2023-05-10
 */
@Data
@AllArgsConstructor
public class RestResult<T> {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;


    private static <T> RestResult<T> restResult(int code, String msg, T data) {
        return new RestResult<T>(code, msg, data);
    }

    public static <T> RestResult<T> success(String msg, T data) {
        return restResult(SUCCESS, msg, data);
    }

    public static <T> RestResult<T> success(String msg) {
        return success(msg, null);
    }

    public static <T> RestResult<T> success(T data) {
        return success("操作成功!", data);
    }

    public static <T> RestResult<T> success() {
        return success("操作成功!");
    }


    public static <T> RestResult<T> fail(String msg, T data) {
        return restResult(FAIL, msg, data);
    }

    public static <T> RestResult<T> fail(String msg) {
        return fail(msg, null);
    }

    public static <T> RestResult<T> fail() {
        return fail("操作失败!");
    }

}
