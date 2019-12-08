package com.shiro.service;


import java.util.Set;

/**
 * 角色service
 * @ClassName SysRoleService
 * @Author 杨彦斌
 * @Date 2019/9/20 10:52
 */
public interface SysRoleService {
    Set<String> selectRoleKeys(Integer id);
}
