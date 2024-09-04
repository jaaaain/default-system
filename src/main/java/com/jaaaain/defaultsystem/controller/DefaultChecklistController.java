package com.jaaaain.defaultsystem.controller;

controller;

import .entity.DefaultChecklist;
import .service.DefaultChecklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 违约认定人工审核表(DefaultChecklist)表控制层
 * @since 2024-09-04 12:25:45
 */
@RestController
@RequestMapping("defaultChecklist")
public class DefaultChecklistController {

    @Autowired
    private DefaultChecklistService defaultChecklistService;

    /**
     * 分页查询
     * @param defaultChecklist 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list")
    public Result list(DefaultChecklist defaultChecklist, PageRequest pageRequest) {
        defaultChecklistService.queryByLimit(defaultChecklist, pageRequest);
        return Result.success();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        defaultChecklistService.queryById(id);
        return Result.success();
    }

    /**
     * 新增数据
     * @param defaultChecklist 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(DefaultChecklist defaultChecklist) {
        defaultChecklistService.insert(defaultChecklist);
        return Result.success();
    }

    /**
     * 编辑数据
     * @param defaultChecklist 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(DefaultChecklist defaultChecklist) {
        defaultChecklistService.update(defaultChecklist);
        return Result.success();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        defaultChecklistService.deleteById(id);
        return Result.success();
    }

}

