package com.bess.auroradrive;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.bess.auroradrive.controller.aliyun.oss.config.OSSConfig;
import com.bess.auroradrive.service.OSSService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@SpringBootTest
class AuroraDriveApplicationTests {

    private OSSConfig ossConfig;

    @Resource
    private OSSService ossService;

    @Test
    void contextLoads() {

        ossConfig = new OSSConfig("oss-cn-shanghai.aliyuncs.com","","","aliyun-wb-emxaeb2ucy","","");

        OSS ossClient = ossService.getOSSClient(ossConfig);

        List<OSSObjectSummary> ossObjectSummary = ossService.getOSSObjectSummary(ossClient, ossConfig);
        for (OSSObjectSummary s : ossObjectSummary) {
            System.out.println("\t" + s.getKey());
        }

        ossClient.getObject(new GetObjectRequest(ossConfig.getBucketName(), ossObjectSummary.get(1).getKey()), new File("测试文件1"));

        ossService.close(ossClient);
    }

}
