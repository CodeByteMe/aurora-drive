package com.bess.auroradrive.model.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
* driveConfig对象 drive_config*
* @author Bess Croft
* @date 2020-11-11
**/
@Data
@TableName(value = "drive_config")
@ApiModel(value = "驱动器实例", description = "对应DriveConfig表中的字段")
public class DriveConfig implements Serializable {

    @TableId(value = "config_id")
    @ApiModelProperty(value = "configId", dataType = "Long", required = true)
    private Long configId;

    @TableField(value = "drive_name")
    @ApiModelProperty(value = "驱动器名称", dataType = "String", required = true)
    private String driveName;

    @TableField(value = "drive_type")
    @ApiModelProperty(value = "存储类型", dataType = "String", required = true)
    private String driveType;

    @TableField(value = "cache_enable")
    @ApiModelProperty(value = "缓存", dataType = "Boolean", required = true)
    private Boolean cacheEnable;

    @TableField(value = "cloud_name")
    @ApiModelProperty(value = "云存储服务名称", dataType = "String", required = true)
    private String cloudName;

    @TableField(value = "cloud_account")
    @ApiModelProperty(value = "账号", dataType = "String", required = true)
    private String cloudAccount;

    @TableField(value = "cloud_pwd")
    @ApiModelProperty(value = "密码", dataType = "String", required = true)
    private String cloudPwd;

    @TableField(value = "accelerated_domain_name")
    @ApiModelProperty(value = "加速域名", dataType = "String", required = true)
    private String acceleratedDomainName;

    @TableField(value = "root_path")
    @ApiModelProperty(value = "根路径", dataType = "String", required = true)
    private String rootPath;

}