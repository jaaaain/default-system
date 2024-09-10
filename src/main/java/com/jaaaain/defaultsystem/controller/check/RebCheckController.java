package com.jaaaain.defaultsystem.controller.check;

import com.jaaaain.defaultsystem.entity.PageBean;
import com.jaaaain.defaultsystem.entity.Result;
import com.jaaaain.defaultsystem.entity.vo.RebInfoVO;
import com.jaaaain.defaultsystem.service.RebirthChecklistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 重生人工审核表(RebirthChecklist)表控制层
 * @since 2024-09-04 12:25:46
 */
@RestController
@Slf4j
public class RebCheckController {

    @Autowired
    private RebirthChecklistService rebirthChecklistService;

    /**
     * 分页查询
     * @param page,size,status
     * @return 查询结果
     */
    @GetMapping("/check/rebirth")
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer size,
                       @RequestParam(defaultValue = "") Integer status,
                       @RequestParam(defaultValue = "") String cusName) {
        log.info("status:{},cusName:{}",status,cusName);
        PageBean pageBean = rebirthChecklistService.queryByLimit(page,size,status,cusName);
        return Result.success(pageBean);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/check/rebirth/{id}")
    public Result queryVOById(@PathVariable("id") Integer id) {
        RebInfoVO rebInfo = rebirthChecklistService.queryVOById(id);
        log.info(String.valueOf(rebInfo));
        return Result.success(rebInfo);
    }

    /**
     * 编辑数据,改变status
     * @param id,status
     * @return 编辑结果
     */
    @PutMapping("/check/rebirth/{id}")
    public Result Check(@PathVariable("id") Integer id, Integer result) {
        log.info("{}审核result:{}",id,result);
        try{
            rebirthChecklistService.updateStatus(id,result);
            return Result.success();
        }catch (RuntimeException e){
            return Result.error(e.getMessage());
        }
    }
}

