package com.jaaaain.defaultsystem.service;

service;

import
import com.jaaaain.defaultsystem.entity.RebirthReasonTable; .RebirthReasonTable;

/**
 * 重生原因表(RebirthReasonTable)表服务接口
 * @since 2024-09-04 12:25:46
 */
public interface RebirthReasonTableService {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    RebirthReasonTable queryById(Integer id);

    /**
     * 分页查询
     * @param rebirthReasonTable 筛选条件
     * @return 查询结果
     */
    PageBean queryByLimit(Integer page, Integer size, RebirthReasonTable rebirthReasonTable);

    /**
     * 新增数据
     * @param rebirthReasonTable 实例对象
     * @return 实例对象
     */
    RebirthReasonTable insert(RebirthReasonTable rebirthReasonTable);

    /**
     * 修改数据
     * @param rebirthReasonTable 实例对象
     * @return 实例对象
     */
    RebirthReasonTable update(RebirthReasonTable rebirthReasonTable);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
