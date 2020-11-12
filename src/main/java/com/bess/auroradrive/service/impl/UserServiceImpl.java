package com.bess.auroradrive.service.impl;

import com.bess.auroradrive.mapper.SystemConfigMapper;
import com.bess.auroradrive.model.dto.UserInfo;
import com.bess.auroradrive.model.domain.SystemConfig;
import com.bess.auroradrive.service.UserService;
import com.bess.auroradrive.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 * UserServiceImpl
 *
 * @Author BessCroft
 * @Date 2020/10/30 14:36
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private SystemConfigMapper systemConfigMapper;

    @Override
    public boolean login(String username, String password) {
        SystemConfig systemConfig1 = systemConfigMapper.selectById(1);
        String userName = systemConfig1.getValue();
        SystemConfig systemConfig2 = systemConfigMapper.selectById(2);
        String Pwd = systemConfig2.getValue();
        log.info("userName:" + userName + ",Pwd:" + Pwd);
        if (MD5Util.md5(password).equals(Pwd) && username.equals(userName)) {
            return true;
        }
        return false;
    }

    @Override
    public UserInfo getInfo() {
        SystemConfig systemConfig1 = systemConfigMapper.selectById(3);
        String nickName = systemConfig1.getValue();
        SystemConfig systemConfig2 = systemConfigMapper.selectById(5);
        String avatarUrl = systemConfig2.getValue();
        return new UserInfo(nickName,avatarUrl);
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateInfo(String nickName, String avatarUrl) {
        int i = systemConfigMapper.updateById(new SystemConfig(3, "nickName", nickName, "昵称"));
        log.info("返回结果:" + i);
        int j = systemConfigMapper.updateById(new SystemConfig(5, "avatarUrl", avatarUrl, "用户头像"));
        if (i > 0 && j > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateUser(String lowPassWord, String newPassWord, String confirmPassWord) {
        String password = systemConfigMapper.selectById(2).getValue();
        if (password.equals(MD5Util.md5(lowPassWord))) {
            int i = systemConfigMapper.updateById(new SystemConfig(2, "password", MD5Util.md5(confirmPassWord), "(默认)密码"));
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

}
