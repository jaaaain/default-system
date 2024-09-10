package com.jaaaain.defaultsystem.controller.check;

import com.jaaaain.defaultsystem.entity.PageBean;
import com.jaaaain.defaultsystem.entity.Result;
import com.jaaaain.defaultsystem.entity.vo.DefInfoVO;
import com.jaaaain.defaultsystem.service.DefaultChecklistService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 违约认定人工审核表(DefaultChecklist)表控制层
 * @since 2024-09-04 12:25:45
 */
@Slf4j
@RestController
public class DefCheckController {

    @Autowired
    private DefaultChecklistService defaultChecklistService;

    /**
     * 分页查询,可根据审核状态进行筛选
     * @param page,size,status
     * @return 查询结果
     */
    @GetMapping("/check/default")
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "") Integer status,
                       @RequestParam(defaultValue = "") String cusName) {
        log.info("status={}",status);
        PageBean pageBean = defaultChecklistService.queryByLimit(page,size,status,cusName);
        return Result.success(pageBean);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/check/default/{id}")
    public Result queryById(@PathVariable("id") Integer id) {
        DefInfoVO defInfoVO = defaultChecklistService.queryById(id);
        return Result.success(defInfoVO);
    }

    /**
     * 编辑数据,改变status，审核时间
     * @param id,status
     * @return 编辑结果
     */
    @PutMapping("/check/default/{id}")
    public Result Check(@PathVariable Integer id,Integer result
//                        ,HttpServletRequest request
    ) {
        log.info("{}审核result:{}",id,result);
//        String token = request.getHeader("token");
        try{
            defaultChecklistService.updateStatus(id,result);
            return Result.success();
        }catch (RuntimeException e){
            return Result.error(e.getMessage());
        }
    }
}

