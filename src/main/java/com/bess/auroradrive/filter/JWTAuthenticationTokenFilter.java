package com.bess.auroradrive.filter;

import com.bess.auroradrive.config.JWTConfig;
import com.bess.auroradrive.model.entity.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器，主要用于处理预检请求和校验Token的正确性
 *
 * @Author BessCroft
 * @Date 2020/10/30 9:54
 */
@Slf4j
public class JWTAuthenticationTokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        response.setHeader("Access-Control-Allow-Origin","*");      //设置允许跨域
        response.setHeader("Access-Control-Allow-Methods","*");     //设置允许多种请求方式
        response.setHeader("Access-Control-Max-Age","3600");        //设置跨域缓存的最大时间
        response.setHeader("Access-Control-Allow-Headers","*");     //设置允许携带header
        response.setHeader("Access-Control-Allow-Credentials","*"); //设置允许携带cookie

        // 判断是否为预检请求
        if (!"OPTIONS".equalsIgnoreCase(request.getMethod())) {
            log.info("非预检请求");
            // 获取请求头中的Token
            String tokenHeader = request.getHeader(JWTConfig.tokenHeader);
            if (null != tokenHeader && tokenHeader.startsWith((JWTConfig.tokenPrefix))) {
                try {
                    // 截取JWT前缀
                    String token = tokenHeader.replace(JWTConfig.tokenPrefix, "");
                    // 解析JWT
                    Claims claims = Jwts.parser()
                            .setSigningKey(JWTConfig.secret)
                            .parseClaimsJws(token)
                            .getBody();
                    // 获取用户名
                    String username = claims.getSubject();
                    String userId = claims.getId();
                    // 组装实例
                    User user = new User();
                    user.setUserId(Integer.parseInt(userId));
                    user.setUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, userId);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } catch (ExpiredJwtException e) {
                    log.info("Token过期:" ,e);
                } catch (UnsupportedJwtException e) {
                    log.info("Token无效:" ,e);
                } catch (MalformedJwtException e) {
                    log.info("Token无效:" ,e);
                } catch (SignatureException e) {
                    log.info("Token无效:" ,e);
                } catch (IllegalArgumentException e) {
                    log.info("Token无效:" ,e);
                }
            }
            filterChain.doFilter(request, response);
        } else {
            log.info("预检请求");
            response.setStatus(200);
            return;
        }

    }

    @Override
    public void destroy() {

    }
}
