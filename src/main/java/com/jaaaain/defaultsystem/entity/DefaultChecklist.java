package com.jaaaain.defaultsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 违约认定人工审核表(DefaultChecklist)实体类
 * @since 2024-09-07 03:45:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultChecklist implements Serializable {
    private Integer id;// 违约审核编号
    private Integer cusId;// 客户号
    private Integer defId;// 违约原因编号
    private Integer severity;// 严重程度
    private Integer certifier;// 认定人
    private LocalDateTime deterAppliTime;// 认定申请时间
    private Integer exteriorRate;// 外部最新等级
    private String remark;// 备注
    private Integer status;// 审核状态
    private LocalDateTime deterModiTime;// 认定审核时间
}

