package com.jaaaain.defaultsystem.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 重生人工审核表(RebirthChecklist)实体类
 * @since 2024-09-04 12:25:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebirthChecklist implements Serializable {
    private Integer id;// 重生审核编号
    private String rebirthReasonId;// 重生原因编号
    private Integer defId;// 违约审核编号
    private Date rebirthAppliTime;// 重生申请时间
    private Integer status;// 审核状态
}

