package com.bess.auroradrive.service.service;

import com.bess.auroradrive.mapper.SystemConfigMapper;
import com.bess.auroradrive.model.dto.UserInfo;
import com.bess.auroradrive.model.entity.SystemConfig;
import com.bess.auroradrive.service.UserService;
import com.bess.auroradrive.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
