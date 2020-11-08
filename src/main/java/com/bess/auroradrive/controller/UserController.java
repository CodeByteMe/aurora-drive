package com.bess.auroradrive.controller;

import com.bess.auroradrive.config.JWTConfig;
import com.bess.auroradrive.model.dto.UserInfo;
import com.bess.auroradrive.model.entity.User;
import com.bess.auroradrive.model.vo.ResultVO;
import com.bess.auroradrive.service.UserService;
import com.bess.auroradrive.util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * UserController
 *
 * @Author BessCroft
 * @Date 2020/10/26 21:43
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(tags = "用户信息接口")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口" , notes = "管理员登录后台的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, type = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, type = "String")
    })
    public ResultVO Login(String username,String password) {
        log.info("用户名:" + username + ",密码:" + password);
        boolean login = userService.login(username, password);
        if (login) {
            String token = JWTUtil.createAccessToken(new User(username, null, null,1));
            return new ResultVO(0,"success",token);
        }
        return new ResultVO(1,"fail",null);
    }

    @GetMapping("/info")
    @ApiOperation(value = "用户信息查询接口" , notes = "管理员登录成功后查询信息的接口")
    @ApiImplicitParam(name = "token", value = "token验证信息", required = true, type = "String")
    public ResultVO Info(HttpServletRequest request) {
        String token = request.getHeader(JWTConfig.tokenHeader);
        log.info("用户请求了Info接口,Token为:" + token);
        UserInfo info = null;
        try {
            Jws<Claims> decrypt = JWTUtil.Decrypt(token);
            info = userService.getInfo();
            if (info != null) {
                return new ResultVO(0,"success",info);
            }
        } catch (Exception e) {
            log.error("Info接口异常:" + e);
        }
        return new ResultVO(1,"fail",null);
    }

    @PostMapping("/updateInfo")
    @ApiOperation(value = "用户信息修改接口" , notes = "修改用户信息的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickName", value = "用户昵称", required = true, type = "String"),
            @ApiImplicitParam(name = "avatarUrl", value = "用户头像地址", required = true, type = "String"),
            @ApiImplicitParam(name = "token", value = "token验证信息", required = true, type = "String")
    })
    public ResultVO updateInfo(String nickName,String avatarUrl,HttpServletRequest request) {
        String token = request.getHeader(JWTConfig.tokenHeader);
        log.info("用户请求了updateInfo接口,nickName为:" + nickName + ",avatarUrl为:" + avatarUrl);
        try {
            Jws<Claims> decrypt = JWTUtil.Decrypt(token);
            boolean b = userService.updateInfo(nickName, avatarUrl);
            if (b) {
                return new ResultVO(0,"success",new UserInfo(nickName, avatarUrl));
            }
        } catch (Exception e) {
            log.error("Info接口异常:" + e);
        }
        return new ResultVO(1,"fail",null);
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "用户密码修改接口" , notes = "修改用户密码的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lowPassWord", value = "旧密码", required = true, type = "String"),
            @ApiImplicitParam(name = "newPassWord", value = "新密码", required = true, type = "String"),
            @ApiImplicitParam(name = "confirmPassWord", value = "确认密码", required = true, type = "String"),
            @ApiImplicitParam(name = "token", value = "token验证信息", required = true, type = "String")
    })
    public ResultVO updateUser(String lowPassWord,String newPassWord,String confirmPassWord,HttpServletRequest request) {
        String token = request.getHeader(JWTConfig.tokenHeader);
        log.info("用户请求了updateUser接口,lowPassWord为:" + lowPassWord + ",newPassWord为:" + newPassWord + ",confirmPassWord为:" + confirmPassWord);
        try {
            Jws<Claims> decrypt = JWTUtil.Decrypt(token);
            boolean b = userService.updateUser(lowPassWord, newPassWord, confirmPassWord);
            if (b) {
                return new ResultVO(0,"success", null);
            }
        } catch (Exception e) {
            log.error("Info接口异常:" + e);
        }
        return new ResultVO(1,"fail",null);
    }

}