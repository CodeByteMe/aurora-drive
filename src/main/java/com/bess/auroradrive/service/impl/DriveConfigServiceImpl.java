package com.bess.auroradrive.service.impl;

import com.bess.auroradrive.mapper.DriveConfigMapper;
import com.bess.auroradrive.model.domain.DriveConfig;
import com.bess.auroradrive.service.DriveConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * driveConfigService业务层处理
 * 
 * @author ruoyi
 * @date 2020-11-12
 */
@Service
public class DriveConfigServiceImpl implements DriveConfigService {
    @Resource
    private DriveConfigMapper driveConfigMapper;

    /**
     * 查询driveConfig
     * 
     * @param configId driveConfigID
     * @return driveConfig
     */
    @Override
    @Transactional
    public DriveConfig selectDriveConfigById(Long configId) {
        return driveConfigMapper.selectDriveConfigById(configId);
    }

    /**
     * 查询driveConfig列表
     *
     * @return driveConfig
     */
    @Override
    @Transactional
    public List<DriveConfig> selectDriveConfigList() {
        return driveConfigMapper.selectDriveConfigList();
    }

    /**
     * 新增driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean insertDriveConfig(DriveConfig driveConfig) {
        return driveConfigMapper.insertDriveConfig(driveConfig) > 0;
    }

    /**
     * 修改driveConfig
     * 
     * @param driveConfig driveConfig
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateDriveConfig(DriveConfig driveConfig) {
        return driveConfigMapper.updateDriveConfig(driveConfig) > 0;
    }

    /**
     * 删除driveConfig信息
     * 
     * @param configId driveConfigID
     * @return 结果
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean deleteDriveConfigById(Long configId) {
        return driveConfigMapper.deleteDriveConfigById(configId) > 0;
    }

    /**
     * 更新cacheEnable
     *
     * @param configId
     * @param cacheEnable
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateCacheEnable(Long configId, boolean cacheEnable) {
        return driveConfigMapper.updateCacheEnable(configId, cacheEnable) > 0;
    }

}
