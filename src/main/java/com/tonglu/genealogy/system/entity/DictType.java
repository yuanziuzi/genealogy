package com.tonglu.genealogy.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tonglu.genealogy.common.core.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典类型表
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dict_type")
public class DictType extends BaseEntity {

    private static final long serialVersionUID = 3L;

    /**
     * ID 唯一标识 字典类型ID
     */
    @TableId(value = "dict_id", type = IdType.AUTO)
    private Integer dictId;

    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;

    /**
     * 字典名称
     */
    @TableField("dict_name")
    private String dictName;

    /**
     * 描述
     */
    @TableField("remark")
    private String remark;

    /**
     * 状态
     */
    @TableField("`status`")
    private Integer status;


}
