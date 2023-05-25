package com.tonglu.genealogy.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tonglu.genealogy.common.core.entity.RestResult;
import com.tonglu.genealogy.system.entity.DictData;
import com.tonglu.genealogy.system.service.DictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import com.tonglu.genealogy.common.core.controller.BaseController;

import javax.annotation.Resource;

/**
 * <p>
 * 字典数据管理 前端控制器
 * </p>
 *
 * @author yuanzi
 * @since 2023-05-11
 */
@Api(tags = "字典数据管理")
@RestController
@RequestMapping("/system/dict-data")
public class DictDataController extends BaseController {

    @Resource
    private DictDataService dictDataService;

    @ApiOperation("新增字典数据")
    @PostMapping("/save")
    public RestResult<DictData> saveDictData(@RequestBody @ApiParam DictData dictData) {
        return toRestResult(dictDataService.save(dictData));
    }

    @ApiOperation("更新字典数据")
    @PutMapping("/update")
    public RestResult<DictData> updateDictData(@RequestBody @ApiParam DictData dictData) {
        return toRestResult(dictDataService.updateById(dictData));
    }

    @ApiOperation("删除字典数据")
    @DeleteMapping("/remove/{dictCode}")
    public RestResult<DictData> removeDictData(
            @PathVariable @ApiParam(value = "字典编码", name = "dictCode", required = true) Integer dictCode) {
        return toRestResult(dictDataService.removeById(dictCode));
    }

    @ApiOperation("查询字典数据详情")
    @GetMapping("/detail/{dictCode}")
    public RestResult<DictData> detailDictData(
            @PathVariable @ApiParam(value = "字典编码", name = "dictCode", required = true) Integer dictCode) {
        return toRestResult(dictDataService.getById(dictCode));
    }

    @ApiOperation("分页查询字典数据列表")
    @PostMapping("/list")
    public RestResult<IPage<DictData>> listDictData(@RequestBody @ApiParam DictData dictData) {
        return toRestResult(dictDataService.listDictData(dictData, getPager(dictData)));
    }

}