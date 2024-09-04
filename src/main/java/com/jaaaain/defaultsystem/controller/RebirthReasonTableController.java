package com.jaaaain.defaultsystem.controller;

controller;

import .entity.RebirthReasonTable;
import .service.RebirthReasonTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 重生原因表(RebirthReasonTable)表控制层
 * @since 2024-09-04 12:25:46
 */
@RestController
@RequestMapping("rebirthReasonTable")
public class RebirthReasonTableController {

    @Autowired
    private RebirthReasonTableService rebirthReasonTableService;

    /**
     * 分页查询
     * @param rebirthReasonTable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list")
    public Result list(RebirthReasonTable rebirthReasonTable, PageRequest pageRequest) {
        rebirthReasonTableService.queryByLimit(rebirthReasonTable, pageRequest);
        return Result.success();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        rebirthReasonTableService.queryById(id);
        return Result.success();
    }

    /**
     * 新增数据
     * @param rebirthReasonTable 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(RebirthReasonTable rebirthReasonTable) {
        rebirthReasonTableService.insert(rebirthReasonTable);
        return Result.success();
    }

    /**
     * 编辑数据
     * @param rebirthReasonTable 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(RebirthReasonTable rebirthReasonTable) {
        rebirthReasonTableService.update(rebirthReasonTable);
        return Result.success();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        rebirthReasonTableService.deleteById(id);
        return Result.success();
    }

}

