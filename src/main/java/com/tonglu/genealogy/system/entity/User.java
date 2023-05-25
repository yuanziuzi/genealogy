package com.tonglu.genealogy.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tonglu.genealogy.common.core.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * <p>
 * 用户实体
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel("用户实体")
public class User extends BaseEntity {

    private static final long serialVersionUID = 2L;

    @TableId(value = "user_id", type = IdType.AUTO)
    @ApiModelProperty("用户ID，主键，唯一标识")
    private Long userId;

    @TableField("phone")
    @Size(min = 11, max = 11, message = "请正确输入手机号")
    @ApiModelProperty("手机号")
    private String phone;

    @TableField("`password`")
    @Length(min = 6, max = 18, message = "密码至少{min}位，最多{max}位")
    @ApiModelProperty("登陆密码")
    private String password;

    @Length(max = 20, message = "昵称最多{max}个字符 ")
    @TableField("nick_name")
    @ApiModelProperty("昵称")
    private String nickName;

    @TableField("sex")
    @ApiModelProperty("性别")
    private Integer sex;

    @TableField("email")
    @Email(message = "email格式校验错误")
    @ApiModelProperty("邮箱")
    private String email;

    @Length(max = 10, message = "最多{max}个字符 ")
    @TableField("real_name")
    @ApiModelProperty("真实姓名")
    private String realName;

    @TableField("id")
    @ApiModelProperty("身份证号")
    private String id;

    @TableField("`status`")
    @ApiModelProperty("用户状态")
    private Integer status;


}
