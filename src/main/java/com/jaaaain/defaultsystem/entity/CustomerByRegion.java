package com.jaaaain.defaultsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerByRegion {
    private String region;
    private Integer count;
}
