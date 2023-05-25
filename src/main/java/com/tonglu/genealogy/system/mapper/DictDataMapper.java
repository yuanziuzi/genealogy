package com.tonglu.genealogy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tonglu.genealogy.system.entity.DictData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 字典数据表 Mapper 接口
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Mapper
public interface DictDataMapper extends BaseMapper<DictData> {

    /**
     * 统计字典数据
     *
     * @param dictType 字典类型
     * @return
     */
    int countDictDataesByType(@Param("dictType") String dictType);

    /**
     * 分页查询字典数据列表
     *
     * @param dictData
     * @param pager
     * @return
     */
    IPage<DictData> pageListDictData(@Param("dictData") DictData dictData, Page<DictData> pager);
}