package com.shiro.model;

import lombok.Data;

/**
 * @ClassName SysAuth
 * @Author 杨彦斌
 * @Date 2019/9/21 8:37
 */
@Data
public class SysAuth {
    /**
     * 菜单ID
     */
    private Integer menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 父菜单ID
     */
    private Integer parentId;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    private String menuType;
    /**
     * 权限标识
     */
    private String perms;

    /**
     * 备注
     */
    private String remark;

}
