package com.bess.auroradrive.controller;

import com.bess.auroradrive.model.domain.DriveConfig;
import com.bess.auroradrive.model.vo.ResultVO;
import com.bess.auroradrive.service.DriveConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * driveConfigController
 * 
 * @author ruoyi
 * @date 2020-11-12
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/drive")
@Api(tags = "驱动器信息接口")
public class DriveConfigController {

    @Resource
    private DriveConfigService driveConfigService;

    @GetMapping("/list")
    @ApiOperation(value = "驱动器列表接口" , notes = "查询driveConfig列表")
    public ResultVO list() {
        log.info("用户请求了list接口");
        return new ResultVO(0,"success",null);
    }

    @GetMapping(value = "/getInfo/{configId}")
    @ApiOperation(value = "根据单个驱动器id查询信息" , notes = "获取driveConfig详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "configId", value = "驱动器id", required = true, type = "Long"),
            @ApiImplicitParam(name = "token", value = "token验证信息", required = true, type = "String")
    })
    public ResultVO getInfo(@PathVariable("configId") Long configId) {
        log.info("用户请求了getInfo接口");
        return new ResultVO(0,"success",null);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增driveConfig接口" , notes = "新增驱动器配置信息")
    @ApiImplicitParam(name = "driveConfig", value = "驱动器实例", required = true, type = "DriveConfig")
    public ResultVO add(@RequestBody DriveConfig driveConfig) {
        log.info("用户请求了add接口");
        return new ResultVO(0,"success",null);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "修改driveConfig接口" , notes = "修改驱动器配置信息")
    @ApiImplicitParam(name = "driveConfig", value = "驱动器实例", required = true, type = "DriveConfig")
    public ResultVO update(@RequestBody DriveConfig driveConfig) {
        log.info("用户请求了update接口");
        return new ResultVO(0,"success",null);
    }

    /**
     * 删除driveConfig
     */
	@DeleteMapping("/delete/{configId}")
    @ApiOperation(value = "删除driveConfig接口" , notes = "删除驱动器配置")
    @ApiImplicitParam(name = "configId", value = "驱动器id", required = true, type = "Long")
    public ResultVO remove(@PathVariable Long configId) {
        log.info("用户请求了remove接口");
        return new ResultVO(0,"success",null);
    }

}
