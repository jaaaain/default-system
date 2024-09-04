package com.jaaaain.defaultsystem.entity;

import java.io.Serializable;

/**
 * 违约风险原因表(DefTable)实体类
 * @since 2024-09-04 12:25:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefTable implements Serializable {
    private Integer id;// 违约原因编号
    private String defReason;// 违约原因
    private Integer enabled;
}

