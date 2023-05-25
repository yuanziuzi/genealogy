package com.tonglu.genealogy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tonglu.genealogy.system.entity.User;

/**
 * <p>
 * 用户表 服务类
 * <p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
public interface UserService extends IService<User> {

    /**
     * 手机号唯一验证`
     *
     * @param user
     * @return
     */
    public boolean checkPhoneUnique(User user);

    /**
     * 分页查询用户列表
     *
     * @param user
     * @param pager
     * @return
     */
    public IPage<User> listUsers(User user, Page<User> pager);
}
