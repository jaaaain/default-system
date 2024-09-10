package com.jaaaain.defaultsystem.service.impl;

import com.jaaaain.defaultsystem.entity.CustomerByIndustry;
import com.jaaaain.defaultsystem.entity.CustomerByRegion;
import com.jaaaain.defaultsystem.entity.Response;
import com.jaaaain.defaultsystem.mapper.CustomerMapper;
import com.jaaaain.defaultsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Response selectDefaultByRegion() {
        List<CustomerByRegion> cus=customerMapper.selectDefaultCustomerByRegion();
        List<String> region=cus.stream().map(CustomerByRegion::getRegion).collect(Collectors.toList());
        List<Integer> count=cus.stream().map(CustomerByRegion::getCount).collect(Collectors.toList());
        return new Response(region,count);
    }

    @Override
    public Response selectRebirthByRegion() {
        List<CustomerByRegion> cus=customerMapper.selectRebirthCustomerByRegion();
        List<String> region=cus.stream().map(CustomerByRegion::getRegion).collect(Collectors.toList());
        List<Integer> count=cus.stream().map(CustomerByRegion::getCount).collect(Collectors.toList());
        return new Response(region,count);
    }

    @Override
    public Response selectDefaultByIndustry() {
        List<CustomerByIndustry> cus=customerMapper.selectDefaultCustomerByIndustry();
        List<String> industry=cus.stream().map(CustomerByIndustry::getIndustry).collect(Collectors.toList());
        List<Integer> count=cus.stream().map(CustomerByIndustry::getCount).collect(Collectors.toList());
        return new Response(industry,count);

    }

    @Override
    public Response selectRebirthByIndustry() {
        List<CustomerByIndustry> cus=customerMapper.selectRebirthCustomerByIndustry();
        List<String> industry=cus.stream().map(CustomerByIndustry::getIndustry).collect(Collectors.toList());
        List<Integer> count=cus.stream().map(CustomerByIndustry::getCount).collect(Collectors.toList());
        return new Response(industry,count);
    }
}
