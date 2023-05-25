package com.tonglu.genealogy.common.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务连接器工具类
 * <p>
 *
 * @author liusiyuan
 * @since 2023-05-17
 */
public class ServletUtils {

    /**
     * 获取请求属性
     *
     * @return
     */
    public static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取response
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取String类型请求参数
     *
     * @param name 参数名
     * @return
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 获取Integer类型请求参数
     *
     * @param name 参数名
     * @return
     */
    public static Integer getIntegerParameter(String name) {
        return ConvertUtils.toInteger(getRequest().getParameter(name));
    }
}
