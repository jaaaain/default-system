package com.jaaaain.defaultsystem.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebInfoVO {
    private Integer id;
    private String cusName; // 客户姓名
    private String defReason; // 违约原因
    private Integer severity; // 严重程度
    private String certifierName; // 申请人姓名
    private String checkerName; // 审核人姓名
    private LocalDateTime deterAppliTime; // 认定申请时间
    private LocalDateTime deterModifiedTime; // 认定审核时间
    private Integer exteriorRate; // 最新外部等级
    private String rebReason; // 重生原因
    private Integer status; // 审核状态
    private String remark; // 备注
}
