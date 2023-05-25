package com.tonglu.genealogy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tonglu.genealogy.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * <p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 手机号唯一验证
     *
     * @param user
     * @return
     */
    User checkPhoneUnique(User user);

    /**
     * 分页查询用户列表
     *
     * @param user
     * @param page
     * @return
     */
    IPage<User> listUsers(@Param("user") User user, Page<User> page);
}
