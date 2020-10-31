package com.bess.auroradrive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.bess.auroradrive.mapper")
public class AuroraDriveApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuroraDriveApplication.class, args);
    }

}
