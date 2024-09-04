package com.jaaaain.defaultsystem.service;

service;

import
import com.jaaaain.defaultsystem.entity.RebirthChecklist; .RebirthChecklist;

/**
 * 重生人工审核表(RebirthChecklist)表服务接口
 * @since 2024-09-04 12:25:46
 */
public interface RebirthChecklistService {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    RebirthChecklist queryById(Integer id);

    /**
     * 分页查询
     * @param rebirthChecklist 筛选条件
     * @return 查询结果
     */
    PageBean queryByLimit(Integer page, Integer size, RebirthChecklist rebirthChecklist);

    /**
     * 新增数据
     * @param rebirthChecklist 实例对象
     * @return 实例对象
     */
    RebirthChecklist insert(RebirthChecklist rebirthChecklist);

    /**
     * 修改数据
     * @param rebirthChecklist 实例对象
     * @return 实例对象
     */
    RebirthChecklist update(RebirthChecklist rebirthChecklist);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
