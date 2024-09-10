package com.jaaaain.defaultsystem.service;


import com.jaaaain.defaultsystem.entity.Customer;
import com.jaaaain.defaultsystem.entity.DefaultChecklist;
import com.jaaaain.defaultsystem.entity.RebirthChecklist;

import java.util.List;

public interface ProposersService {
    /**
     * 未违约且系统判断可能违约的列表
     * @return
     */
    List<Customer> listDefault();

    /**
     * 提交违约申请
     * @param id
     * @param
     */
    void postDefault(Integer id,String token, DefaultChecklist defaultChecklist);

    /**
     * 已违约且系统判断不违约的列表
     * @return
     */
    List<Customer> listRebirth();

    /**
     * 提交重生申请
     * @param id
     * @param token
     * @param rebirthChecklist
     */
    void postRebirth(Integer id, String token, RebirthChecklist rebirthChecklist);
}
