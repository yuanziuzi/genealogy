package com.tonglu.genealogy.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tonglu.genealogy.common.core.controller.BaseController;
import com.tonglu.genealogy.common.core.entity.RestResult;
import com.tonglu.genealogy.system.entity.DictType;
import com.tonglu.genealogy.system.service.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 字典类型 前端控制器
 * <p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Api(tags = "字典类型管理")
@RestController
@RequestMapping("/system/dict-type")
public class DictTypeController extends BaseController {

    @Resource
    private DictTypeService dictTypeService;

    @ApiOperation("新增字典类型")
    @PostMapping("/save")
    public RestResult<DictType> saveDictType(@RequestBody @ApiParam DictType dictType) {
        if (!dictTypeService.checkDictTypeUnique(dictType)) {
            return error("新增字典'" + dictType.getDictName() + "'失败，字典类型已存在");
        }
        return toRestResult(dictTypeService.save(dictType));
    }

    @ApiOperation("删除字典")
    @DeleteMapping("/remove/{dictId}")
    public RestResult<DictType> removeDictType(
            @PathVariable @ApiParam(value = "字典ID", name = "dictId", required = true) Integer dictId) {
        return toRestResult(dictTypeService.removeDictType(dictId));
    }

    @ApiOperation("修改字典类型")
    @PutMapping("/update")
    public RestResult<DictType> updateDictType(@RequestBody @ApiParam DictType dictType) {
        if (!dictTypeService.checkDictTypeUnique(dictType)) {
            return error("修改字典'" + dictType.getDictName() + "'失败，字典类型已存在");
        }
        return toRestResult(dictTypeService.updateById(dictType));
    }

    @ApiOperation("查询字典类型详情")
    @GetMapping("/detail/{dictId}")
    public RestResult<DictType> getDictType(
            @PathVariable @ApiParam(value = "字典ID", name = "dictId", required = true) Integer dictId) {
        return toRestResult(dictTypeService.getById(dictId));
    }

    @ApiOperation("分页查询字典类型列表")
    @PostMapping("/list")
    public RestResult<IPage<DictType>> listDictType(@RequestBody @ApiParam DictType dictType) {
        return toRestResult(dictTypeService.listDictType(dictType, getPager(dictType)));
    }


}
