package com.shiro.model;

import lombok.Data;

import java.util.List;

/**
 * @ClassName SysRole
 * @Author 杨彦斌
 * @Date 2019/9/21 8:35
 */
@Data
public class SysRole {
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色可有多个权限、对应role_auth
     */
    private List<SysAuth> sysAuthList;
}
