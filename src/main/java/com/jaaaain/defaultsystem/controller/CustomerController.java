package com.jaaaain.defaultsystem.controller;

import com.jaaaain.defaultsystem.entity.Result;
import com.jaaaain.defaultsystem.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    /**
     * 违约客户按地区统计
     * @return
     */
    @GetMapping("/customer/default/region")
    public Result getDefaultRegion() {
        log.info("违约客户按地区统计");
        return Result.success(customerService.selectDefaultByRegion());
    }

    /**
     * 违约客户按行业统计
     * @return
     */
    @GetMapping("/customer/default/industry")
    public Result getDefaultIndustry() {
        log.info("违约客户按行业统计");
        return Result.success(customerService.selectDefaultByIndustry());
    }

    /**
     * 重生客户按地区统计
     * @return
     */
    @GetMapping("/customer/rebirth/region")
    public Result getRebirthRegion() {
        log.info("重生客户按地区统计");
        return Result.success(customerService.selectRebirthByRegion());
    }

    /**
     * 重生客户按行业统计
     * @return
     */
    @GetMapping("/customer/rebirth/industry")
    public Result getRebirthIndustry() {
        log.info("重生客户按行业统计");
        return Result.success(customerService.selectRebirthByIndustry());
    }
}
