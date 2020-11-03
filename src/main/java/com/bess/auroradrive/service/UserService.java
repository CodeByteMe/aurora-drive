package com.bess.auroradrive.service;

import com.bess.auroradrive.model.dto.UserInfo;

/**
 * UserService
 *
 * @Author BessCroft
 * @Date 2020/10/30 12:11
 */
public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username,String password);

    /**
     * 查询用户信息
     * @return
     */
    public UserInfo getInfo();
}
