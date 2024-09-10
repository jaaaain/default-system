package com.jaaaain.defaultsystem.service;

import com.jaaaain.defaultsystem.entity.PageBean;
import com.jaaaain.defaultsystem.entity.vo.DefInfoVO;
import org.springframework.transaction.annotation.Transactional;

/**
 * 违约认定人工审核表(DefaultChecklist)表服务接口
 * @since 2024-09-04 12:25:46
 */
public interface DefaultChecklistService {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DefInfoVO queryById(Integer id);

    /**
     * 分页查询
     * @param page,size,status
     * @return 查询结果
     */
    PageBean queryByLimit(Integer page, Integer size,Integer status,String cusName);

    /**
     * 审核
     * @param id,status 审核是否通过，1：通过，2：未通过
     * @return 影响行数
     */
    @Transactional
    void updateStatus(Integer id, Integer status);
}
