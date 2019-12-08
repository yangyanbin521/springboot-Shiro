package com.shiro.model;

import lombok.Data;

/**
 * @ClassName SysUser
 * @Author 杨彦斌
 * @Date 2019/12/8 15:33
 */
@Data
public class SysUser {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 颜值
     */
    private String salt;
}
