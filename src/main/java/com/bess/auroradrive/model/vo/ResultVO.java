package com.bess.auroradrive.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResultVO
 *
 * @Author BessCroft
 * @Date 2020/10/30 11:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "响应封装实例", description = "响应前端json字符串的实例对象")
public class ResultVO {

    @ApiModelProperty(value = "返回的执行结果状态码", dataType = "Integer", required = true)
    private Integer code;

    @ApiModelProperty(value = "返回的执行结果消息", dataType = "String", required = true)
    private String msg;

    @ApiModelProperty(value = "返回的执行结果", dataType = "Object", required = true)
    private Object data;

}
