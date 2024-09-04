package com.jaaaain.defaultsystem.mapper;

mapper;

import .entity.User;
import java.util.List;

/**
 * (User)表数据库访问层
 * @since 2024-09-04 12:25:46
 */
 @Mapper
public interface UserMapper {
    /**
     * 通过ID查询单条数据
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询指定行数据
     * @param user 查询条件
     * @return 对象列表
     */
    List<User> queryByLimit(User user);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 新增数据
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 批量新增数据（foreach）
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<User> entities);

    /**
     * 修改数据
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 批量更新数据（foreach）
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常
     */
    int UpdateBatch(List<User> entities);
    
}

