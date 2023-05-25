package com.tonglu.genealogy.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tonglu.genealogy.common.core.constant.UserConstants;
import com.tonglu.genealogy.common.exception.ServiceException;
import com.tonglu.genealogy.common.util.StringUtils;
import com.tonglu.genealogy.system.entity.DictType;
import com.tonglu.genealogy.system.mapper.DictDataMapper;
import com.tonglu.genealogy.system.mapper.DictTypeMapper;
import com.tonglu.genealogy.system.service.DictTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Service
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType> implements DictTypeService {

    @Resource
    private DictTypeMapper dictTypeMapper;

    @Resource
    private DictDataMapper dictDataMapper;

    /**
     * 校验字典类型唯一
     *
     * @param dictType
     * @return
     */
    @Override
    public boolean checkDictTypeUnique(DictType dictType) {
        Integer id = Objects.isNull(dictType.getDictId()) ? -1 : dictType.getDictId();
        DictType type = dictTypeMapper.checkDictTypeUnique(dictType);
        boolean unique = UserConstants.UNIQUE;
        if (!Objects.isNull(type)) {
            if (!id.equals(type.getDictId())) {
                unique = UserConstants.NOT_UNIQUE;
            }
        }
        return unique;
    }

    /**
     * 删除字典类型
     *
     * @param dictId 字典ID
     * @return
     */
    @Override
    public int removeDictType(Integer dictId) {
        DictType dictType = dictTypeMapper.selectById(dictId);
        if (dictDataMapper.countDictDataesByType(dictType.getDictType()) > 0) {
            throw new ServiceException(StringUtils.format("\"{}\"已分配，不能删除", dictType.getDictName()));
        }
        return dictTypeMapper.deleteById(dictId);
    }

    /**
     * 分页查询字典类型
     *
     * @param dictType
     * @param pager
     * @return
     */
    @Override
    public IPage<DictType> listDictType(DictType dictType, Page<DictType> pager) {
        LambdaQueryWrapper<DictType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(dictType.getDictType()), DictType::getDictType, dictType.getDictType());
        wrapper.eq(!Objects.isNull(dictType.getStatus()), DictType::getStatus, dictType.getStatus());
        wrapper.like(StringUtils.isNotBlank(dictType.getDictName()), DictType::getDictName, dictType.getDictName());
        return dictTypeMapper.selectPage(pager, wrapper);
    }

}
