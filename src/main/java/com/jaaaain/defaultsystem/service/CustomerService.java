package com.jaaaain.defaultsystem.service;

import com.jaaaain.defaultsystem.entity.Response;

public interface CustomerService {
    Response selectDefaultByRegion();
    Response selectRebirthByRegion();
    Response selectDefaultByIndustry();
    Response selectRebirthByIndustry();
}
