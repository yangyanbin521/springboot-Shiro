package com.shiro.mapper;

import com.shiro.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName SysUserMapper
 * @Author 杨彦斌
 * @Date 2019/12/8 15:29
 */
@Mapper
public interface SysUserMapper {
    /**
     * 查询所有用户信息
     */
    List<SysUser> findUserList();

    /**
     * 根据名称查询用户信息
     */
    SysUser findUserByLoginName(String password);

    /**
     * 新增用户(注册)
     */
    void register(SysUser user);
}
