package com.bess.auroradrive.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * JWT配置类
 *
 * @Author BessCroft
 * @Date 2020/10/30 10:17
 */
@Component
@ConfigurationProperties(prefix = "jwt")
@PropertySource(value = {"classpath:/application.yml"}, encoding = "utf-8")
@Setter
public class JWTConfig {
    /**
     * 密钥KEY
     */
//    @Value("${jwt.secret}")
    public static String secret;
    /**
     * TokenKey
     */
//    @Value("${jwt.tokenHeader}")
    public static String tokenHeader;
    /**
     * Token前缀字符
     */
//    @Value("${jwt.tokenPrefix}")
    public static String tokenPrefix;
    /**
     * 过期时间
     */
//    @Value("${jwt.expiration}")
    public static Integer expiration;

    /**
     * 超时时间
     */
//    @Value("${jwt.access-token}")
    public static Integer accessToken;

    /**
     * 刷新token时间
     */
//    @Value("${jwt.refresh-token}")
    public static Integer refreshToken;

    /**
     * 不需要认证的接口
     */
//    @Value("${jwt.antMatchers}")
    public static String antMatchers;

}
