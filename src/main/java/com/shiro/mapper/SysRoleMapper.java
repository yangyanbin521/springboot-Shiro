package com.shiro.mapper;

import com.shiro.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SysRoleMapper
 * @Author 杨彦斌
 * @Date 2019/9/21 9:52
 */
@Mapper
public interface SysRoleMapper {
    /**
     * 根据用户id 查询角色
     */
    List<SysRole> selectRolesByUserId(@Param("userid") Integer userId);
}
