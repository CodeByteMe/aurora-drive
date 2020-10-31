package com.bess.auroradrive.service;

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
}
