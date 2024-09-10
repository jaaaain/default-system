package com.jaaaain.defaultsystem.mapper;

import com.jaaaain.defaultsystem.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 客户表(CusTable)表数据库访问层
 * @since 2024-09-04 12:25:39
 */
@Mapper
public interface CusTableMapper {
    /**
     * 修改违约情况
     * @param id
     * @param status
     * @return
     */
    @Update("update cus_table set Breach_of_contract=#{status} where id=#{id}")
    int updateStatus(Integer id,Integer status);

    
}

