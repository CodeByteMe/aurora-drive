package com.bess.auroradrive.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * SystemConfig
 *
 * @Author BessCroft
 * @Date 2020/10/10 23:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemConfig {
    private Integer id;
    private String key;
    private String value;
    private String remark;
}
