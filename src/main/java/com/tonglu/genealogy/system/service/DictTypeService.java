package com.tonglu.genealogy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tonglu.genealogy.system.entity.DictType;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
public interface DictTypeService extends IService<DictType> {

    /**
     * 校验字典类型唯一
     *
     * @param dictType
     * @return
     */
    public boolean checkDictTypeUnique(DictType dictType);

    /**
     * 删除字典类型
     *
     * @param dictId
     * @return
     */
    public int removeDictType(Integer dictId);

    /**
     * 分页查询字典类型
     *
     * @param dictType
     * @param pager
     * @return
     */
    public IPage<DictType> listDictType(DictType dictType, Page<DictType> pager);
}
