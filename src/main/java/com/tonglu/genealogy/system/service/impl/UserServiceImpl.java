package com.tonglu.genealogy.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tonglu.genealogy.common.core.constant.UserConstants;
import com.tonglu.genealogy.system.entity.User;
import com.tonglu.genealogy.system.mapper.UserMapper;
import com.tonglu.genealogy.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 用户表 服务实现类
 * <p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 手机号唯一验证
     *
     * @param user
     * @return
     */
    @Override
    public boolean checkPhoneUnique(User user) {
        boolean unique = UserConstants.UNIQUE;
        Long userId = Objects.isNull(user.getUserId()) ? -1 : user.getUserId();
        User phoneUser = userMapper.checkPhoneUnique(user);
        if (!Objects.isNull(phoneUser) && !userId.equals(phoneUser.getUserId())) {
            unique = UserConstants.NOT_UNIQUE;
        }
        return unique;
    }

    /**
     * 分页查询用户列表
     *
     * @param user
     * @param pager
     * @return
     */
    @Override
    public IPage<User> listUsers(User user, Page<User> pager) {
        return userMapper.listUsers(user, pager);
    }

}
