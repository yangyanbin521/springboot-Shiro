package com.shiro.service.impl;

import com.shiro.exception.BaseException;
import com.shiro.mapper.SysUserMapper;
import com.shiro.model.SysUser;
import com.shiro.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Author 杨彦斌
 * @Date 2019/12/8 15:29
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 查询用户信息
     */
    @Override
    public List<SysUser> findUserList() {
        return userMapper.findUserList();
    }

    /**
     * 根据用户名查询用户
     */
    @Override
    public SysUser findUserByLoginName(String username) {
        return userMapper.findUserByLoginName(username);
    }

    /**
     * 新增用户  (注册)
     */
    @Override
    public void register(SysUser user) {
        //查看库中是否有该用户
        SysUser user2 = userMapper.findUserByLoginName(user.getUsername());
        if (user2!=null){
            throw new BaseException("用户已存在");
        }

        // 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */
        String newPs = new SimpleHash("MD5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(newPs);
        user.setSalt(salt.toHex());
        userMapper.register(user);
    }
}
