package com.bess.auroradrive.service;

import com.bess.auroradrive.model.domain.DriveConfig;

import java.util.List;

/**
 * driveConfigService接口
 * 
 * @author ruoyi
 * @date 2020-11-12
 */
public interface DriveConfigService
{
    /**
     * 查询driveConfig
     * 
     * @param configId driveConfigID
     * @return driveConfig
     */
    public DriveConfig selectDriveConfigById(Long configId);

    /**
     * 查询driveConfig列表
     * 
     * @param driveConfig driveConfig
     * @return driveConfig集合
     */
    public List<DriveConfig> selectDriveConfigList();

    /**
     * 新增driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    public boolean insertDriveConfig(DriveConfig driveConfig);

    /**
     * 修改driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    public boolean updateDriveConfig(DriveConfig driveConfig);

    /**
     * 删除driveConfig信息
     * 
     * @param configId driveConfigID
     * @return 结果
     */
    public boolean deleteDriveConfigById(Long configId);

    /**
     * 更新cacheEnable
     *
     * @param configId
     * @param cacheEnable
     * @return
     */
    public boolean updateCacheEnable(Long configId, boolean cacheEnable);
}
