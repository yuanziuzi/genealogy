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
 * 字典数据表
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dict_data")
public class DictData extends BaseEntity {

    private static final long serialVersionUID = 4L;

    /**
     * 字典编码
     */
    @TableId(value = "dict_code", type = IdType.AUTO)
    private Integer dictCode;

    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;

    /**
     * 字典标签
     */
    @TableField("dict_label")
    private String dictLabel;

    /**
     * 字典键值
     */
    @TableField("dict_value")
    private Integer dictValue;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 默认值标识
     */
    @TableField("default_flag")
    private Boolean defaultFlag;

    /**
     * 状态
     */
    @TableField("`status`")
    private Integer status;


}
