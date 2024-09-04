package com.jaaaain.defaultsystem.service;

service;

import
import com.jaaaain.defaultsystem.entity.CusTable; .CusTable;

/**
 * 客户表(CusTable)表服务接口
 * @since 2024-09-04 12:25:41
 */
public interface CusTableService {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    CusTable queryById(Integer id);

    /**
     * 分页查询
     * @param cusTable 筛选条件
     * @return 查询结果
     */
    PageBean queryByLimit(Integer page, Integer size, CusTable cusTable);

    /**
     * 新增数据
     * @param cusTable 实例对象
     * @return 实例对象
     */
    CusTable insert(CusTable cusTable);

    /**
     * 修改数据
     * @param cusTable 实例对象
     * @return 实例对象
     */
    CusTable update(CusTable cusTable);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
