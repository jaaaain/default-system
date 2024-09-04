package com.jaaaain.defaultsystem.controller;

controller;

import .entity.User;
import .service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 * @since 2024-09-04 12:25:46
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list")
    public Result list(User user, PageRequest pageRequest) {
        userService.queryByLimit(user, pageRequest);
        return Result.success();
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        userService.queryById(id);
        return Result.success();
    }

    /**
     * 新增数据
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public Result add(User user) {
        userService.insert(user);
        return Result.success();
    }

    /**
     * 编辑数据
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public Result edit(User user) {
        userService.update(user);
        return Result.success();
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result deleteById(Integer id) {
        userService.deleteById(id);
        return Result.success();
    }

}

