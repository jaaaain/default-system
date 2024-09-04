package com.jaaaain.defaultsystem.entity;

import java.io.Serializable;

/**
 * 重生原因表(RebirthReasonTable)实体类
 * @since 2024-09-04 12:25:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RebirthReasonTable implements Serializable {
    private Integer id;// 重生原因编号
    private String rebirthReason;// 重生原因
}

