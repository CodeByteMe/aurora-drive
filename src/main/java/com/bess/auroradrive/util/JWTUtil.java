package com.bess.auroradrive.util;

import com.bess.auroradrive.config.JWTConfig;
import com.bess.auroradrive.model.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT工具类
 *
 * @Author BessCroft
 * @Date 2020/10/30 10:13
 */
public class JWTUtil {

    /**
     * 生成Token
     * @param user 用户实体
     * @return Token
     */
    public static String createAccessToken(User user) {
        String token = Jwts.builder()
                // 放入用户ID
                .setId(user.getUserId() + "")
                // 放入用户名
                .setSubject(user.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("Aurora")
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS256, JWTConfig.secret)
                .compact();
        return JWTConfig.tokenPrefix + token;
    }

    /**
     * 解码Token
     * @param token
     * @return
     */
    public static Jws<Claims> Decrypt(String token) {
        return Jwts.parser().setSigningKey(JWTConfig.secret).parseClaimsJws(token);
    }

}
