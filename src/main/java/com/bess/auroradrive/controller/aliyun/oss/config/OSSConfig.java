package com.bess.auroradrive.controller.aliyun.oss.config;

import lombok.*;

/**
 * OSSConfig
 *
 * @Author BessCroft
 * @Date 2020/11/13 21:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OSSConfig {

    /**
     * endpoint是访问OSS的域名
     */
    private String endpoint;

    /**
     * accessKeyId和accessKeySecret是OSS的访问密钥
     */
    private String accessKeyId;

    private String accessKeySecret;

    /**
     * Bucket用来管理所存储Object的存储空间
     */
    private String bucketName;

    /**
     * Object是OSS存储数据的基本单元，称为OSS的对象，也被称为OSS的文件
     */
    private String firstKey;

    /**
     * 文件前缀
     */
    private String KeyPrefix;

}
