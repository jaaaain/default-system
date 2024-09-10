package com.jaaaain.defaultsystem.mapper;

import com.jaaaain.defaultsystem.entity.CustomerByIndustry;
import com.jaaaain.defaultsystem.entity.CustomerByRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper {
    @Select("select region,count(*) as count from cus_table where breach_of_contract=1 group by region")
    List<CustomerByRegion> selectDefaultCustomerByRegion();

    List<CustomerByRegion> selectRebirthCustomerByRegion();

    @Select("select industry,count(*) as count from cus_table where breach_of_contract=1 group by industry")
    List<CustomerByIndustry> selectDefaultCustomerByIndustry();

    List<CustomerByIndustry> selectRebirthCustomerByIndustry();
}
