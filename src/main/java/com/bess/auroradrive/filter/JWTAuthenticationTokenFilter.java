package com.bess.auroradrive.filter;

import com.bess.auroradrive.config.JWTConfig;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
@Component
@WebFilter("/*")
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

        String uri = request.getRequestURI();

        if (uri.contains("swagger-")|| uri.contains("api-docs") || uri.contains("/user/login")
            || uri.contains("favicon") || uri.contains("/doc.html") || uri.contains("/webjars/**")) {
            filterChain.doFilter(request,response);
        } else if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(200);
            return;
        } else {
            String tokenHeader = request.getHeader(JWTConfig.tokenHeader);
            log.info(tokenHeader);
            if (null != tokenHeader && tokenHeader.startsWith((JWTConfig.tokenPrefix))) {
                try {
                    // 截取JWT前缀
                    String token = tokenHeader.replace(JWTConfig.tokenPrefix, "");
                    // 解析JWT
                    Claims claims = Jwts.parser()
                            .setSigningKey(JWTConfig.secret)
                            .parseClaimsJws(token)
                            .getBody();
                    filterChain.doFilter(request, response);
                } catch (ExpiredJwtException e) {
                    log.info("Token过期:" ,e);
                    return;
                } catch (UnsupportedJwtException e) {
                    log.info("Token无效:" ,e);
                    return;
                } catch (MalformedJwtException e) {
                    log.info("Token无效:" ,e);
                    return;
                } catch (SignatureException e) {
                    log.info("Token无效:" ,e);
                    return;
                } catch (IllegalArgumentException e) {
                    log.info("Token无效:" ,e);
                    return;
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
