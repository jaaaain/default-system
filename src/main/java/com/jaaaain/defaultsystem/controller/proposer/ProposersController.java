package com.jaaaain.defaultsystem.controller.proposer;

import com.jaaaain.defaultsystem.entity.DefaultChecklist;
import com.jaaaain.defaultsystem.entity.RebirthChecklist;
import com.jaaaain.defaultsystem.entity.Result;
import com.jaaaain.defaultsystem.service.ProposersService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proposers")
@Slf4j
public class ProposersController  {
    @Autowired
    private ProposersService proposersService;

    /**
     * 获取未违约且系统判断可能违约的列表
     * @return
     */
    @GetMapping("/default")
    public Result listDefault(){
        return Result.success(proposersService.listDefault());
    }

    /**
     * 提交违约申请
     * @param id
     * @param defaultChecklist
     * @return
     */
    @PostMapping("/default/{id}")
    public Result postDefault(@PathVariable Integer id,
                              @RequestBody DefaultChecklist defaultChecklist,
                              HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        log.info("提交违约申请:{},JWT:{}",defaultChecklist,token);
        proposersService.postDefault(id,token,defaultChecklist);
        return Result.success();
    }

    /**
     * 获取已违约且系统判断不违约的列表
     * @return
     */
    @GetMapping("/rebirth")
    public Result listRebirth(){
        return Result.success(proposersService.listRebirth());
    }

    /**
     * 提交重生申请
     * @param id
     * @param rebirthReasonId
     * @return
     */
    @PostMapping("/rebirth/{id}")
    public Result postRebirth(@PathVariable Integer id,
                              @RequestBody RebirthChecklist rebirthChecklist,
                              HttpServletRequest request){
        String token = request.getHeader("Authorization");
        proposersService.postRebirth(id,token,rebirthChecklist);
        return Result.success();
    }

}
