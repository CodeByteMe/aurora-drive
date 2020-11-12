package com.bess.auroradrive.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * JWTConfig
 *
 * @Author BessCroft
 * @Date 2020/10/31 21:33
 */
@Component
public class JWTConfig {

    /**
     * 密钥KEY
     */
    public static String secret;

    /**
     * TokenKey
     */
    public static String tokenHeader;

    /**
     * Token前缀字符
     */
    public static String tokenPrefix;

    /**
     * 过期时间
     */
    public static Integer expiration;

    /**
     * 超时时间
     */
    public static Integer accessToken;

    /**
     * 刷新token时间
     */
    public static Integer refreshToken;

    /**
     * 不需要认证的接口
     */
    public static String antMatchers;

    @Value("${jwt.base64-secret}")
    public void setSecret(String secret) {
        JWTConfig.secret = secret;
    }

    @Value("${jwt.tokenHeader}")
    public void setTokenHeader(String tokenHeader) {
        JWTConfig.tokenHeader = tokenHeader;
    }

    @Value("${jwt.tokenPrefix}")
    public void setTokenPrefix(String tokenPrefix) {
        JWTConfig.tokenPrefix = tokenPrefix;
    }

    @Value("${jwt.expiration}")
    public void setExpiration(Integer expiration) {
        JWTConfig.expiration = expiration;
    }

    @Value("${jwt.access-token}")
    public void setAccessToken(Integer accessToken) {
        JWTConfig.accessToken = accessToken;
    }

    @Value("${jwt.refresh-token}")
    public void setRefreshToken(Integer refreshToken) {
        JWTConfig.refreshToken = refreshToken;
    }

    @Value("${jwt.antMatchers}")
    public void setAntMatchers(String antMatchers) {
        JWTConfig.antMatchers = antMatchers;
    }
}
