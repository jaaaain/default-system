package com.jaaaain.defaultsystem.mapper;

import com.jaaaain.defaultsystem.entity.Customer;
import com.jaaaain.defaultsystem.entity.DefaultChecklist;
import com.jaaaain.defaultsystem.entity.RebirthChecklist;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ProposersMapper {
    /**
     * 未违约且系统判断可能违约的列表
     *
     * @return
     */
    @Select("select * from cus_table where breach_of_contract = 0 or Breach_of_contract = 2")
    List<Customer> listDefault();

    /**
     * 提交违约申请，人工认定违约表单插入违约审核表
     *
     * @param id
     * @param
     * @param
     * @param deterAppliTime
     */
    @Insert("insert into default_checklist(cus_id,def_id,severity,Certifier,deter_appli_time,exterior_rate,remark) " +
            "values (#{defaultChecklist.cusId}, #{defaultChecklist.defId}, #{defaultChecklist.severity},#{defaultChecklist.certifier}, #{defaultChecklist.deterAppliTime}, #{defaultChecklist.exteriorRate}, #{defaultChecklist.remark})")
    void postDefault(Integer id, DefaultChecklist defaultChecklist);

    /**
     * 已违约且系统判断不违约的列表
     *
     * @return
     */
    @Select("select * from cus_table where breach_of_contract = 1 or Breach_of_contract = 3")
    List<Customer> listRebirth();

    /**
     * 提交重生申请
     * @param id
     * @param rebirthChecklist
     */
    @Insert("INSERT INTO rebirth_checklist(rebirth_reason_id, def_id, rebirth_appli_time,Certifier) " +
            "SELECT #{rebirthChecklist.rebirthReasonId}, #{rebirthChecklist.defId}, #{rebirthChecklist.rebirthAppliTime},#{rebirthChecklist.certifier} ")
    void postRebirth(Integer id, RebirthChecklist rebirthChecklist);
}