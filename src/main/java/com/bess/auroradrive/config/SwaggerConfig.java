package com.bess.auroradrive.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置信息
 *
 * @Author BessCroft
 * @Date 2020/10/30 10:28
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

    /**
     * Docket对象用于设置接口说明信息
     * @return docket
     */
    @Bean
    public Docket getDocket(){
        //Docket对象用于设置接口说明信息
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bess.auroradrive.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    public ApiInfo getApiInfo(){
        ApiInfoBuilder builder = new ApiInfoBuilder()
                .title("极光网盘接口文档")
                .description("一款还行的网盘")
                .version("0.0.1")
                .contact(new Contact("Bess Croft","https://52bess.com","besscroft@foxmail.com"));
        ApiInfo apiInfo = builder.build();
        return apiInfo;
    }
}
