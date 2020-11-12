package com.bess.auroradrive.service.impl;

import com.bess.auroradrive.mapper.DriveConfigMapper;
import com.bess.auroradrive.model.domain.DriveConfig;
import com.bess.auroradrive.service.DriveConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * driveConfigService业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-12
 */
@Service
public class DriveConfigServiceImpl implements DriveConfigService
{
    @Resource
    private DriveConfigMapper driveConfigMapper;

    /**
     * 查询driveConfig
     * 
     * @param configId driveConfigID
     * @return driveConfig
     */
    @Override
    public DriveConfig selectDriveConfigById(Long configId)
    {
        return driveConfigMapper.selectDriveConfigById(configId);
    }

    /**
     * 查询driveConfig列表
     * 
     * @param driveConfig driveConfig
     * @return driveConfig
     */
    @Override
    public List<DriveConfig> selectDriveConfigList(DriveConfig driveConfig)
    {
        return driveConfigMapper.selectDriveConfigList(driveConfig);
    }

    /**
     * 新增driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    @Override
    public int insertDriveConfig(DriveConfig driveConfig)
    {
        return driveConfigMapper.insertDriveConfig(driveConfig);
    }

    /**
     * 修改driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    @Override
    public int updateDriveConfig(DriveConfig driveConfig)
    {
        return driveConfigMapper.updateDriveConfig(driveConfig);
    }

    /**
     * 删除driveConfig信息
     * 
     * @param configId driveConfigID
     * @return 结果
     */
    @Override
    public int deleteDriveConfigById(Long configId)
    {
        return driveConfigMapper.deleteDriveConfigById(configId);
    }
}
