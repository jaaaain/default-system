package com.jaaaain.defaultsystem.mapper;

mapper;

import .entity.DefaultChecklist;
import java.util.List;

/**
 * 违约认定人工审核表(DefaultChecklist)表数据库访问层
 * @since 2024-09-04 12:25:46
 */
 @Mapper
public interface DefaultChecklistMapper {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    DefaultChecklist queryById(Integer id);

    /**
     * 查询指定行数据
     * @param defaultChecklist 查询条件
     * @return 对象列表
     */
    List<DefaultChecklist> queryByLimit(DefaultChecklist defaultChecklist);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 新增数据
     * @param defaultChecklist 实例对象
     * @return 影响行数
     */
    int insert(DefaultChecklist defaultChecklist);

    /**
     * 批量新增数据（foreach）
     * @param entities List<DefaultChecklist> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<DefaultChecklist> entities);

    /**
     * 修改数据
     * @param defaultChecklist 实例对象
     * @return 影响行数
     */
    int update(DefaultChecklist defaultChecklist);

    /**
     * 批量更新数据（foreach）
     * @param entities List<DefaultChecklist> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常
     */
    int UpdateBatch(List<DefaultChecklist> entities);
    
}

