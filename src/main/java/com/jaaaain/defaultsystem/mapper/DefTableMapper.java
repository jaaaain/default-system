package com.jaaaain.defaultsystem.mapper;

mapper;

import .entity.DefTable;
import java.util.List;

/**
 * 违约风险原因表(DefTable)表数据库访问层
 * @since 2024-09-04 12:25:45
 */
 @Mapper
public interface DefTableMapper {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DefTable queryById(Integer id);

    /**
     * 查询指定行数据
     * @param defTable 查询条件
     * @return 对象列表
     */
    List<DefTable> queryByLimit(DefTable defTable);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 新增数据
     * @param defTable 实例对象
     * @return 影响行数
     */
    int insert(DefTable defTable);

    /**
     * 批量新增数据（foreach）
     * @param entities List<DefTable> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<DefTable> entities);

    /**
     * 修改数据
     * @param defTable 实例对象
     * @return 影响行数
     */
    int update(DefTable defTable);

    /**
     * 批量更新数据（foreach）
     * @param entities List<DefTable> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常
     */
    int UpdateBatch(List<DefTable> entities);
    
}

