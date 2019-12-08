package com.shiro.service.impl;


import com.shiro.mapper.SysRoleMapper;
import com.shiro.model.SysRole;
import com.shiro.service.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName LoginServiceImpl
 * @Author 杨彦斌
 * @Date 2019/9/20 10:53
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 根据用户id查询角色
     */
    @Override
    public Set<String> selectRoleKeys(Integer userId) {
        List<SysRole> perms = sysRoleMapper.selectRolesByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms) {
            if (perm != null && StringUtils.isNotEmpty(perm.getRoleName())) {
                permsSet.addAll(Arrays.asList(perm.getRoleName().trim().split(",")));
            }
        }
        return permsSet;
    }
}
