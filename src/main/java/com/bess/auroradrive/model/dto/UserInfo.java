package com.bess.auroradrive.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserInfo
 *
 * @Author BessCroft
 * @Date 2020/11/3 13:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户Info信息", description = "包含用户昵称、用户头像url")
public class UserInfo {

    @ApiModelProperty(value = "用户昵称", dataType = "String", required = true)
    private String nickName;

    @ApiModelProperty(value = "用户头像地址", dataType = "String", required = true)
    private String avatarUrl;

}
