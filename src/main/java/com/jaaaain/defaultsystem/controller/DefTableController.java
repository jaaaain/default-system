package com.jaaaain.defaultsystem.controller;

controller;

import .entity.DefTable;
import .service.DefTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 违约风险原因表(DefTable)表控制层
 * @since 2024-09-04 12:25:45
 */
@RestController
@RequestMapping("defTable")
public class DefTableController {

    @Autowired
    private DefTableService defTableService;

    /**
     * 分页查询
     * @param defTable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list")
    public Result list(DefTable defTable, PageRequest pageRequest) {
        defTableService.queryByLimit(defTable, pageRequest);
        return Result.success();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        defTableService.queryById(id);
        return Result.success();
    }

    /**
     * 新增数据
     * @param defTable 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(DefTable defTable) {
        defTableService.insert(defTable);
        return Result.success();
    }

    /**
     * 编辑数据
     * @param defTable 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(DefTable defTable) {
        defTableService.update(defTable);
        return Result.success();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        defTableService.deleteById(id);
        return Result.success();
    }

}

