package com.bess.auroradrive.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.bess.auroradrive.controller.aliyun.oss.config.OSSConfig;
import com.bess.auroradrive.service.OSSService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OSSServiceImpl
 *
 * @Author BessCroft
 * @Date 2020/11/13 22:12
 */
@Service
public class OSSServiceImpl implements OSSService {

    private ThreadLocal<OSS> OSSClient = new ThreadLocal<>();
    /**
     * 生成OSSClient
     * @return
     */
    @Override
    public OSS getOSSClient(OSSConfig ossConfig) {
        OSS oss = OSSClient.get();
        if (oss == null) {
            oss = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
            OSSClient.set(oss);
        }
        return oss;
    }

    /**
     * 列举文件。如果不设置KeyPrefix，则列举存储空间下的所有文件。如果设置KeyPrefix，则列举包含指定前缀的文件。
     * @return
     */
    @Override
    public List<OSSObjectSummary> getOSSObjectSummary(OSS ossClient, OSSConfig ossConfig) {
        // ObjectListing objectListing = ossClient.listObjects(ossConfig.getBucketName(), ossConfig.getKeyPrefix());
        ObjectListing objectListing = ossClient.listObjects(ossConfig.getBucketName());
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
//        for (OSSObjectSummary s : sums) {
//            System.out.println("\t" + s.getKey());
//        }
        return sums;
    }

    /**
     * 关闭连接
     * @param ossClient
     */
    @Override
    public void close(OSS ossClient) {
        ossClient.shutdown();
        OSSClient.remove();
    }

}
