package com.jaaaain.defaultsystem.service.impl;

import com.jaaaain.defaultsystem.entity.Customer;
import com.jaaaain.defaultsystem.entity.DefaultChecklist;
import com.jaaaain.defaultsystem.entity.RebirthChecklist;
import com.jaaaain.defaultsystem.mapper.CusTableMapper;
import com.jaaaain.defaultsystem.mapper.DefaultChecklistMapper;
import com.jaaaain.defaultsystem.mapper.ProposersMapper;
import com.jaaaain.defaultsystem.service.ProposersService;
import com.jaaaain.defaultsystem.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProposersServiceImpl implements ProposersService {
    @Autowired
    private ProposersMapper proposersMapper;
    @Autowired
    private CusTableMapper cusTableMapper;
    @Autowired
    private DefaultChecklistMapper defaultChecklistMapper;

    /**
     * 未违约且系统判断可能违约的列表
     * @return
     */
    public List<Customer> listDefault(){
        return proposersMapper.listDefault();
    }

    /**
     * 提交违约申请
     * @param id
     * @param
     *
     */
    public void postDefault(Integer id,String token, DefaultChecklist defaultChecklist){
        System.out.println(token);
        Claims claims = JwtUtils.parseJwt(token);
        Integer userId = (Integer) claims.get("id");
        System.out.println("userId:"+userId);
        defaultChecklist.setCertifier(userId);
        defaultChecklist.setDeterAppliTime(LocalDateTime.now());
        cusTableMapper.updateStatus(id,2);
        proposersMapper.postDefault(id,defaultChecklist);
    }

    /**
     * 已违约且系统判断不违约的列表
     * @return
     */
    public List<Customer> listRebirth(){
        return proposersMapper.listRebirth();
    }

     /**
     *提交重生申请
     * @param id
     * @param token
     * @param rebirthChecklist
     */
    public void postRebirth(Integer id,String token,RebirthChecklist rebirthChecklist){
        Claims claims = JwtUtils.parseJwt(token);
        Integer userId = (Integer) claims.get("id");
        System.out.println("userId:"+userId);
        rebirthChecklist.setCertifier(userId);
        rebirthChecklist.setRebirthAppliTime(LocalDateTime.now());
        System.out.println("cusId:"+id);
        Integer defId = defaultChecklistMapper.queryByCus(id);
        System.out.println("defId:"+defId);
        rebirthChecklist.setDefId(defId);
        cusTableMapper.updateStatus(id,3);
        proposersMapper.postRebirth(id,rebirthChecklist);
    }
}
