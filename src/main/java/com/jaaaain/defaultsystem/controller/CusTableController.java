package com.jaaaain.defaultsystem.controller;

controller;

import .entity.CusTable;
import .service.CusTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 客户表(CusTable)表控制层
 * @since 2024-09-04 12:25:30
 */
@RestController
@RequestMapping("cusTable")
public class CusTableController {

    @Autowired
    private CusTableService cusTableService;

    /**
     * 分页查询
     * @param cusTable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list")
    public Result list(CusTable cusTable, PageRequest pageRequest) {
        cusTableService.queryByLimit(cusTable, pageRequest);
        return Result.success();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        cusTableService.queryById(id);
        return Result.success();
    }

    /**
     * 新增数据
     * @param cusTable 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(CusTable cusTable) {
        cusTableService.insert(cusTable);
        return Result.success();
    }

    /**
     * 编辑数据
     * @param cusTable 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(CusTable cusTable) {
        cusTableService.update(cusTable);
        return Result.success();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        cusTableService.deleteById(id);
        return Result.success();
    }

}

