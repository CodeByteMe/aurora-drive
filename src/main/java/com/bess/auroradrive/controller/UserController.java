package com.bess.auroradrive.controller;

import com.bess.auroradrive.mapper.SystemConfigMapper;
import com.bess.auroradrive.model.entity.User;
import com.bess.auroradrive.model.vo.ResultVO;
import com.bess.auroradrive.service.UserService;
import com.bess.auroradrive.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private SystemConfigMapper systemConfigMapper;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录接口" , notes = "管理员登录后台的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, type = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, type = "String")
    })
    public ResultVO Login(String username,String password) {
        log.info("用户名:" + username + "，密码:" + password);
        boolean login = userService.login(username, password);
        if (login) {
            String token = JWTUtil.createAccessToken(new User(username, null, null,1));
            return new ResultVO(0,"success",token);
        }
        return new ResultVO(1,"fail",null);
    }

}