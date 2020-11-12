/*
*  Copyright 2019-2020 Zheng Jie
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package com.bess.auroradrive.model.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @description /
* @author Bess Croft
* @date 2020-11-11
**/
@Data
public class DriveConfigDto implements Serializable {

    /** ID */
    private Long configId;

    /** 驱动器名称 */
    private String driveName;

    /** 存储类型 */
    private String driveType;

    /** 缓存 */
    private Boolean cacheEnable;

    /** 云存储服务名称 */
    private String cloudName;

    /** 账号 */
    private String cloudAccount;

    /** 密码 */
    private String cloudPwd;

    /** 加速域名 */
    private String acceleratedDomainName;

    /** 根路径 */
    private String rootPath;
}