package com.tonglu.genealogy.common.core.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tonglu.genealogy.common.core.constant.Constants;
import com.tonglu.genealogy.common.core.entity.RestResult;
import com.tonglu.genealogy.common.util.ServletUtils;

import java.util.Objects;

/**
 * <p>
 * web层通用数据处理
 * <p>
 *
 * @author: yuanzi
 * @date: 2023-05-17
 */
public class BaseController {


    /**
     * 返回响应结果
     *
     * @param rows 操作影响行数
     * @param <T>
     * @return
     */
    protected <T> RestResult<T> toRestResult(int rows) {
        return rows > 0 ? success() : error();
    }

    /**
     * 返回响应结果
     *
     * @param result 操作结果
     * @param <T>
     * @return
     */
    protected <T> RestResult<T> toRestResult(boolean result) {
        return result ? success() : error();
    }

    /**
     * 返回响应结果
     *
     * @param data 数据
     * @param <T>
     * @return
     */
    protected <T> RestResult<T> toRestResult(T data) {
        return !Objects.isNull(data) ? success(data) : error();
    }

    /**
     * 返回成功消息
     *
     * @param data
     * @param <T>
     * @return
     */
    protected static <T> RestResult<T> success(T data) {
        return RestResult.success(data);
    }

    /**
     * 返回成功消息
     *
     * @param <T>
     * @return
     */
    private static <T> RestResult<T> success() {
        return RestResult.success();
    }

    /**
     * 返回失败消息
     *
     * @param msg
     * @param <T>
     * @return
     */
    protected static <T> RestResult<T> error(String msg) {
        return RestResult.fail(msg);
    }

    /**
     * 返回失败消息
     *
     * @param <T>
     * @return
     */
    private static <T> RestResult<T> error() {
        return RestResult.fail();
    }

    /**
     * 获取分页对象
     *
     * @param <T>
     * @return
     */
    protected <T> Page<T> getPager(T t) {
        return buildPager(t);
    }

    /**
     * 构建分页对象
     *
     * @param t
     * @param <T>
     * @return
     */
    private <T> Page<T> buildPager(T t) {
        Page<T> pager = new Page<>();
        pager.setSize(ServletUtils.getIntegerParameter(Constants.PAGE_SIZE));
        pager.setCurrent(ServletUtils.getIntegerParameter(Constants.PAGE_CURRENT));
        return pager;
    }

}
