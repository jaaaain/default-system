package com.jaaaain.defaultsystem.controller;

controller;

import .entity.RebirthChecklist;
import .service.RebirthChecklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 重生人工审核表(RebirthChecklist)表控制层
 * @since 2024-09-04 12:25:46
 */
@RestController
@RequestMapping("rebirthChecklist")
public class RebirthChecklistController {

    @Autowired
    private RebirthChecklistService rebirthChecklistService;

    /**
     * 分页查询
     * @param rebirthChecklist 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list")
    public Result list(RebirthChecklist rebirthChecklist, PageRequest pageRequest) {
        rebirthChecklistService.queryByLimit(rebirthChecklist, pageRequest);
        return Result.success();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        rebirthChecklistService.queryById(id);
        return Result.success();
    }

    /**
     * 新增数据
     * @param rebirthChecklist 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(RebirthChecklist rebirthChecklist) {
        rebirthChecklistService.insert(rebirthChecklist);
        return Result.success();
    }

    /**
     * 编辑数据
     * @param rebirthChecklist 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(RebirthChecklist rebirthChecklist) {
        rebirthChecklistService.update(rebirthChecklist);
        return Result.success();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        rebirthChecklistService.deleteById(id);
        return Result.success();
    }

}

