package com.jaaaain.defaultsystem.mapper;

import com.jaaaain.defaultsystem.entity.DefaultChecklist;
import com.jaaaain.defaultsystem.entity.vo.DefInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 违约认定人工审核表(DefaultChecklist)表数据库访问层
 * @since 2024-09-04 12:25:46
 */
 @Mapper
public interface DefaultChecklistMapper {
    /**
     * 查询数据,可根据审核状态进行筛选
     * @return 对象列表
     */
    List<DefInfoVO> VOlist(Integer status,String cusName);

    /**
     * 通过ID查询单条数据
     */
    DefInfoVO queryVOById(Integer id);

    /**
     * 通过ID查询单条数据
     */
    @Select("select * from default_checklist where id=#{id}")
    DefaultChecklist queryById(Integer id);

    /**
     * 审核
     * @param status 审核是否通过，1：通过，2：未通过
     * @return 影响行数
     */
    @Update("update default_checklist set status=#{status},deter_modi_time=NOW() where id=#{id}")
    int updateStatus(Integer id,Integer status);

    /**
     *
     * @param userId
     * @return
     */
    @Select("select id from default_checklist where Cus_id=#{cusId} order by Deter_appli_time desc limit 1")
    Integer queryByCus(Integer cusId);
    
}

