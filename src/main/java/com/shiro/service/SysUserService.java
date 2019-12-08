package com.shiro.service;

import com.shiro.model.SysUser;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author 杨彦斌
 * @Date 2019/12/8 15:30
 */
public interface SysUserService {
    /**
     * 查询用户信息
     */
    List<SysUser> findUserList();

    /**
     * 根据用户名查询用户
     */
    SysUser findUserByLoginName(String username);

    /**
     * 新增用户  (注册)
     */
    void register(SysUser user);
}
