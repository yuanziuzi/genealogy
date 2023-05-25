package com.tonglu.genealogy.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tonglu.genealogy.system.entity.DictData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典数据管理 Service接口
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
public interface DictDataService extends IService<DictData> {

    /**
     * 分页查询字典数据列表
     *
     * @param dictData
     * @param pager
     * @return
     */
    public IPage<DictData> listDictData(DictData dictData, Page<DictData> pager);
}
