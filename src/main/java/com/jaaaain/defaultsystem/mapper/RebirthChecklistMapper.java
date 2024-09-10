package com.jaaaain.defaultsystem.mapper;

import com.jaaaain.defaultsystem.entity.RebirthChecklist;
import com.jaaaain.defaultsystem.entity.vo.RebInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 重生人工审核表(RebirthChecklist)表数据库访问层
 * @since 2024-09-04 12:25:46
 */
 @Mapper
public interface RebirthChecklistMapper {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Select("select * from rebirth_checklist where id=#{id}")
    RebirthChecklist queryById(Integer id);

    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    RebInfoVO queryVOById(Integer id);

    /**
     * 查询数据,可根据审核状态进行筛选
     * @return 对象列表
     */
    List<RebInfoVO> VOlist(Integer status,String cusName);

    /**
     * 审核
     * @param status 审核是否通过，1：通过，2：未通过
     * @return 影响行数
     */
    @Update("update rebirth_checklist set status=#{status},rebirth_modi_time=NOW() where id=#{id}")
    int updateStatus(Integer id,Integer status);
}

