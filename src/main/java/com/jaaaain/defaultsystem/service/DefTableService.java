package com.jaaaain.defaultsystem.service;

service;

import
import com.jaaaain.defaultsystem.entity.DefTable; .DefTable;

/**
 * 违约风险原因表(DefTable)表服务接口
 * @since 2024-09-04 12:25:45
 */
public interface DefTableService {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DefTable queryById(Integer id);

    /**
     * 分页查询
     * @param defTable 筛选条件
     * @return 查询结果
     */
    PageBean queryByLimit(Integer page, Integer size, DefTable defTable);

    /**
     * 新增数据
     * @param defTable 实例对象
     * @return 实例对象
     */
    DefTable insert(DefTable defTable);

    /**
     * 修改数据
     * @param defTable 实例对象
     * @return 实例对象
     */
    DefTable update(DefTable defTable);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
