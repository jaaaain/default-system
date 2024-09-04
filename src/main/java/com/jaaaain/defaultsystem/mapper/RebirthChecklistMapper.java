package com.jaaaain.defaultsystem.mapper;

mapper;

import .entity.RebirthChecklist;
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
    RebirthChecklist queryById(Integer id);

    /**
     * 查询指定行数据
     * @param rebirthChecklist 查询条件
     * @return 对象列表
     */
    List<RebirthChecklist> queryByLimit(RebirthChecklist rebirthChecklist);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 新增数据
     * @param rebirthChecklist 实例对象
     * @return 影响行数
     */
    int insert(RebirthChecklist rebirthChecklist);

    /**
     * 批量新增数据（foreach）
     * @param entities List<RebirthChecklist> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<RebirthChecklist> entities);

    /**
     * 修改数据
     * @param rebirthChecklist 实例对象
     * @return 影响行数
     */
    int update(RebirthChecklist rebirthChecklist);

    /**
     * 批量更新数据（foreach）
     * @param entities List<RebirthChecklist> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常
     */
    int UpdateBatch(List<RebirthChecklist> entities);
    
}

