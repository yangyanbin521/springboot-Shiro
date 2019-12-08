package com.shiro.mapper;

import com.shiro.model.SysAuth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName SysAuthMapper
 * @Author 杨彦斌
 * @Date 2019/9/21 10:08
 */
@Mapper
public interface SysAuthMapper {
    /**
     * 根据用户id查询权限
     */
    List<SysAuth> selectAuthsByUserId(Integer userId);
}
