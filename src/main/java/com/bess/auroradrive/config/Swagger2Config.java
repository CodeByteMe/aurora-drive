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
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Config {

    /**
     * Docket对象用于设置接口说明信息
     * @return docket
     */
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.bess.auroradrive.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("极光网盘接口文档")
                .description("一款还行的网盘")
                .termsOfServiceUrl("https://52bess.com")
                .contact(new Contact("Bess Croft","https://52bess.com","besscroft@foxmail.com"))
                .version("0.0.1")
                .build();
    }

}
