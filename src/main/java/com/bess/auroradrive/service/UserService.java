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
    public boolean login(String username, String password);

    /**
     * 查询用户信息
     * @return
     */
    public UserInfo getInfo();

    /**
     * 更新用户信息
     * @param nickName
     * @param avatarUrl
     * @return
     */
    public boolean updateInfo(String nickName, String avatarUrl);

    /**
     * 修改用户密码
     * @param lowPassWord
     * @param newPassWord
     * @param confirmPassWord
     * @return
     */
    public boolean updateUser(String lowPassWord,String newPassWord,String confirmPassWord);
}
