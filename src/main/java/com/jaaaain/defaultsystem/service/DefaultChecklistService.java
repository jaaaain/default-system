package com.jaaaain.defaultsystem.service;

service;

import
import com.jaaaain.defaultsystem.entity.DefaultChecklist; .DefaultChecklist;

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
    DefaultChecklist queryById(Integer id);

    /**
     * 分页查询
     * @param defaultChecklist 筛选条件
     * @return 查询结果
     */
    PageBean queryByLimit(Integer page, Integer size, DefaultChecklist defaultChecklist);

    /**
     * 新增数据
     * @param defaultChecklist 实例对象
     * @return 实例对象
     */
    DefaultChecklist insert(DefaultChecklist defaultChecklist);

    /**
     * 修改数据
     * @param defaultChecklist 实例对象
     * @return 实例对象
     */
    DefaultChecklist update(DefaultChecklist defaultChecklist);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
