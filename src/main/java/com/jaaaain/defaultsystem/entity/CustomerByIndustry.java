package com.jaaaain.defaultsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerByIndustry {
    private String industry;
    private Integer count;
}
