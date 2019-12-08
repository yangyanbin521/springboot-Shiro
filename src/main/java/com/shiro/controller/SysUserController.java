package com.shiro.controller;

import com.shiro.model.SysUser;
import com.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserController
 * @Author mr.yang
 * @Date 2019/12/8 15:29
 */
@Controller
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    /**
     * 查询用户信息
     */
    @GetMapping("/findUserList")
    @ResponseBody
    public List<SysUser> findUserList() {
        List<SysUser> userList = userService.findUserList();
        return userList;
    }
}
