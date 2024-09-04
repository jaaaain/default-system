package com.jaaaain.defaultsystem.entity;

import java.io.Serializable;

/**
 * 客户表(CusTable)实体类
 * @since 2024-09-04 12:25:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CusTable implements Serializable {
    private Integer id;// 客户号
    private String cusName;// 客户名
    private Integer gender;// 性别
    private String region;// 区域
    private String industry;// 行业
    private String contact;// 联系方式
    private String clique;// 集团
    private Integer breachOfContract;// 违约情况
    private Integer value;// 违约阈值
}

