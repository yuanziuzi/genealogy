package com.tonglu.genealogy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tonglu.genealogy.system.entity.DictType;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Mapper
public interface DictTypeMapper extends BaseMapper<DictType> {

    /**
     * 校验字典类型唯一
     *
     * @param dictType
     * @return
     */
    DictType checkDictTypeUnique(DictType dictType);
}
