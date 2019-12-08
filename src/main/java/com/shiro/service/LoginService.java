package com.shiro.service;


import com.shiro.model.SysUser;

/**
 * @ClassName LoginService
 * @Author 杨彦斌
 * @Date 2019/9/20 10:52
 * 登录验证 ,注册
 * 此接口对于登录验证操作的接口
 */
public interface LoginService {
    /**
     * 登陆操作
     * @param username
     * @param password
     * @return
     */
    SysUser login(String username, String password);

    /**
     * 注册操作
     * @param user
     */
    void register(SysUser user);
}
