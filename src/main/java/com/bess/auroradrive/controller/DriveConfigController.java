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
import java.io.Serializable;
import java.util.List;

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
public class DriveConfigController implements Serializable {

    @Resource
    private DriveConfigService driveConfigService;

    @GetMapping("/list")
    @ApiOperation(value = "驱动器列表接口" , notes = "查询driveConfig列表")
    public ResultVO list() {
        List<DriveConfig> driveConfigs = driveConfigService.selectDriveConfigList();
        return new ResultVO(0,"success",driveConfigs);
    }

    @GetMapping(value = "/getInfo/{configId}")
    @ApiOperation(value = "根据单个驱动器id查询信息" , notes = "获取driveConfig详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "configId", value = "驱动器id", required = true, type = "Long"),
            @ApiImplicitParam(name = "token", value = "token验证信息", required = true, type = "String")
    })
    public ResultVO getInfo(@PathVariable("configId") Long configId) {
        DriveConfig driveConfig = driveConfigService.selectDriveConfigById(configId);
        return new ResultVO(0,"success",driveConfig);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "新增driveConfig接口" , notes = "新增驱动器配置信息")
    @ApiImplicitParam(name = "driveConfig", value = "驱动器实例", required = true, type = "DriveConfig")
    public ResultVO add(@RequestBody DriveConfig driveConfig) {
        boolean b = driveConfigService.insertDriveConfig(driveConfig);
        if (b) {
            return new ResultVO(0,"success",null);
        } else {
            return new ResultVO(1,"fail",null);
        }
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "修改driveConfig接口" , notes = "修改驱动器配置信息")
    @ApiImplicitParam(name = "driveConfig", value = "驱动器实例", required = true, type = "DriveConfig")
    public ResultVO update(@RequestBody DriveConfig driveConfig) {
        boolean b = driveConfigService.updateDriveConfig(driveConfig);
        if (b) {
            return new ResultVO(0,"success",null);
        } else {
            return new ResultVO(1,"fail",null);
        }
    }

	@DeleteMapping("/delete/{configId}")
    @ApiOperation(value = "删除driveConfig接口" , notes = "删除驱动器配置")
    @ApiImplicitParam(name = "configId", value = "驱动器id", required = true, type = "Long")
    public ResultVO remove(@PathVariable Long configId) {
        boolean b = driveConfigService.deleteDriveConfigById(configId);
        if (b) {
            return new ResultVO(0,"success",null);
        } else {
            return new ResultVO(1,"fail",null);
        }
    }

    @PutMapping(value = "/update/cache/{configId}/{cacheEnable}")
    @ApiOperation(value = "修改cacheEnable接口" , notes = "修改驱动器缓存状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "configId", value = "驱动器id", required = true, type = "Long"),
            @ApiImplicitParam(name = "cacheEnable", value = "缓存开启状态", required = true, type = "Boolean")
    })
    public ResultVO updateCache(@PathVariable Long configId, @PathVariable Boolean cacheEnable) {
        boolean b = driveConfigService.updateCacheEnable(configId, cacheEnable);
        if (b) {
            return new ResultVO(0,"success",null);
        } else {
            return new ResultVO(1,"fail",null);
        }
    }

}
