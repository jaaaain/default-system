package com.jaaaain.defaultsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 重生认定人工审核表(RebirthChecklist)实体类
 * @since 2024-09-07 03:45:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebirthChecklist implements Serializable {
    private Integer id;// 重生审核编号
    private Integer rebirthReasonId;// 重生原因编号
    private Integer defId;// 违约审核编号
    private LocalDateTime rebirthAppliTime;// 重生申请时间
    private Integer status;// 审核状态
    private Integer certifier;// 重生认定人
    private LocalDateTime rebirthModiTime;// 认定审核时间
    private String remark;// 备注
}

