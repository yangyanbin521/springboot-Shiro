package com.shiro.service.impl;


import com.shiro.exception.user.UserNotExistsException;
import com.shiro.model.SysUser;
import com.shiro.service.LoginService;
import com.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @ClassName LoginServiceImpl
 * @Author 杨彦斌
 * @Date 2019/9/20 10:53
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SysUserService userService;

    /**
     * 登录操作
     * @param username
     * @param password
     * @return
     */
    @Override
    public SysUser login(String username, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new UserNotExistsException();
        }
        //根据用户名查询用户
        SysUser user = userService.findUserByLoginName(username);
        if (user == null) {
            //用户不存在异常
            throw new UserNotExistsException();
        }
        return user;
    }

    /**
     * 注册操作
     * @param user
     */
    @Override
    public void register(SysUser user) {
        userService.register(user);
    }
}
