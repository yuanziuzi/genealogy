package com.tonglu.genealogy.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tonglu.genealogy.common.core.controller.BaseController;
import com.tonglu.genealogy.common.core.entity.RestResult;
import com.tonglu.genealogy.system.entity.User;
import com.tonglu.genealogy.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public RestResult<User> addUser(@Validated @RequestBody @ApiParam User user) {
        if (!userService.checkPhoneUnique(user)) {
            return error("手机号已被注册！");
        }
        return toRestResult(userService.save(user));
    }

    @ApiOperation("删除指定用户")
    @GetMapping("/remove/{userId}")
    public RestResult<User> removeUser(
            @PathVariable("userId") @ApiParam(value = "用户ID", name = "userId", required = true) Long userId) {
        return toRestResult(userService.removeById(userId));
    }

    @ApiOperation("修改用户数据")
    @PutMapping("/update")
    public RestResult<User> updateUser(@RequestBody @ApiParam User user) {
        if (!userService.checkPhoneUnique(user)) {
            return error("手机号已被注册！");
        }
        return toRestResult(userService.updateById(user));
    }

    @ApiOperation("分页查询用户列表")
    @PostMapping("/list")
    public RestResult<IPage<User>> listUsers(@RequestBody @ApiParam User user) {
        return toRestResult(userService.listUsers(user, getPager(user)));
    }

    @ApiOperation("查询用户详情")
    @GetMapping("/detail/{userId}")
    public RestResult<User> getUser(
            @PathVariable("userId") @ApiParam(value = "用户ID", name = "userId", required = true) Long userId) {
        return toRestResult(userService.getById(userId));
    }


}
