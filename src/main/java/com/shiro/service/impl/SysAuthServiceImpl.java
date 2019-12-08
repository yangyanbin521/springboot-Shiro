package com.shiro.service.impl;


import com.shiro.mapper.SysAuthMapper;
import com.shiro.model.SysAuth;
import com.shiro.service.SysAuthService;
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
public class SysAuthServiceImpl implements SysAuthService {
    @Autowired
    private SysAuthMapper authMapper;

    /**
     * 根据用户id查询权限
     */
    @Override
    public Set<String> selectPermsByUserId(Integer userId) {
        List<SysAuth> perms = authMapper.selectAuthsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysAuth perm : perms) {
            if (perm != null && StringUtils.isNotEmpty(perm.getMenuName())) {
                permsSet.addAll(Arrays.asList(perm.getMenuName().trim().split(",")));
            }
        }
        return permsSet;
    }
}
