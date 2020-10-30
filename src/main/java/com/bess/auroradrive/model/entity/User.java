package com.bess.auroradrive.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User
 *
 * @Author BessCroft
 * @Date 2020/10/30 10:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实例", description = "包含用户名、密码和昵称")
public class User {

    @ApiModelProperty(value = "用户名", dataType = "String", required = true)
    private String username;

    @ApiModelProperty(value = "密码", dataType = "String", required = true)
    private String password;

    @ApiModelProperty(value = "昵称", dataType = "String", required = true)
    private String nickName;

    @ApiModelProperty(value = "用户id", dataType = "Integer", required = true)
    private Integer userId;

}
