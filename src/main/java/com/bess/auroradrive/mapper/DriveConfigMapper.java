package com.bess.auroradrive.mapper;

import com.bess.auroradrive.model.domain.DriveConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * driveConfigMapper接口
 * 
 * @author ruoyi
 * @date 2020-11-12
 */
public interface DriveConfigMapper 
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
     * @return driveConfig集合
     */
    public List<DriveConfig> selectDriveConfigList();

    /**
     * 新增driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    public int insertDriveConfig(DriveConfig driveConfig);

    /**
     * 修改driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    public int updateDriveConfig(DriveConfig driveConfig);

    /**
     * 删除driveConfig
     * 
     * @param configId driveConfigID
     * @return 结果
     */
    public int deleteDriveConfigById(Long configId);

    /**
     * 更新缓存状态
     *
     * @param configId
     * @param cacheEnable
     * @return
     */
    public int updateCacheEnable(@Param("configId") Long configId,
                                 @Param("cacheEnable") boolean cacheEnable);

}
