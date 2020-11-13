package com.bess.auroradrive.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObjectSummary;
import com.bess.auroradrive.controller.aliyun.oss.config.OSSConfig;

import java.util.List;

/**
 * OSSService
 *
 * @Author BessCroft
 * @Date 2020/11/13 22:11
 */
public interface OSSService {

    /**
     * 生成OSSClient
     */
    public OSS getOSSClient(OSSConfig ossConfig);

    /**
     * 列举文件
     */
    public List<OSSObjectSummary> getOSSObjectSummary(OSS ossClient, OSSConfig ossConfig);

    /**
     * 下载文件
     */


    /**
     * 关闭连接
     */
    public void close(OSS ossClient);

}
