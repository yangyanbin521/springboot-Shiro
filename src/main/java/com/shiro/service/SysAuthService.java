package com.shiro.service;


import java.util.Set;

/**
 * @ClassName LoginService
 * @Author 杨彦斌
 * @Date 2019/9/20 10:52
 */
public interface SysAuthService {
    /**
     * 根据用户id查询权限
     */
    Set<String> selectPermsByUserId(Integer id);
}
