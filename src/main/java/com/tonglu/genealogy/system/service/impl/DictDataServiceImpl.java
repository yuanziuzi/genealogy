package com.tonglu.genealogy.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tonglu.genealogy.system.entity.DictData;
import com.tonglu.genealogy.system.mapper.DictDataMapper;
import com.tonglu.genealogy.system.service.DictDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Service
public class DictDataServiceImpl extends ServiceImpl<DictDataMapper, DictData> implements DictDataService {

    @Resource
    private DictDataMapper dictDataMapper;

    /**
     * 分页查询字典数据列表
     *
     * @param dictData
     * @param pager
     * @return
     */
    @Override
    public IPage<DictData> listDictData(DictData dictData, Page<DictData> pager) {
        return dictDataMapper.pageListDictData(dictData, pager);
    }
}
