package com.tonglu.genealogy.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * <p>
 * Mybatis-plus 自动填充策略
 * <p>
 *
 * @author yuanZi
 * @date 2023-05-08
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 起始版本
     */
    private static final int START_VERSION = 1;

    /**
     * 逻辑未删除值
     */
    private static final boolean LOGIC_NOT_DELETE_VALUE = false;

    /**
     * 默认空用户
     */
    private static final long TEMP_USER_ID = -1L;

    /**
     * 新增时自动填充策略
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // todo 查询用户信息
        this.strictInsertFill(metaObject, "version", () -> START_VERSION, Integer.class);
        this.strictInsertFill(metaObject, "deleteFlag", () -> LOGIC_NOT_DELETE_VALUE, Boolean.class);
        this.strictInsertFill(metaObject, "createBy", () -> TEMP_USER_ID, Long.class);
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "updateBy", () -> TEMP_USER_ID, Long.class);
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }

    /**
     * 更新时自动填充策略
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // todo 查询用户信息
        this.strictInsertFill(metaObject, "updateBy", () -> TEMP_USER_ID, Long.class);
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
    }
}