package com.bess.auroradrive.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SystemConfig
 *
 * @Author BessCroft
 * @Date 2020/10/10 23:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "系统实例", description = "对应SystemConfig表中的字段")
public class SystemConfig {

    @ApiModelProperty(value = "id", dataType = "Integer", required = true)
    private Integer id;

    @ApiModelProperty(value = "键", dataType = "String", required = true)
    private String key;

    @ApiModelProperty(value = "值", dataType = "String", required = true)
    private String value;

    @ApiModelProperty(value = "说明", dataType = "String", required = true)
    private String remark;
}
