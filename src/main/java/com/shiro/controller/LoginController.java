package com.shiro.controller;

import com.shiro.exception.BaseException;
import com.shiro.model.SysUser;
import com.shiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录  注册操作  忘记我  注销登录
 *
 * @ClassName LoginController
 * @Author mr.yang
 * @Date 2019/12/8 21:02
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录跳转页面
     */
    @GetMapping("/loginView")
    public String loginView() {
        return "login";
    }
    /**
     * 登录成功跳转页面
     */
    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "loginSuccess";
    }

    /**
     * 注册跳转页面
     */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * 注册操作
     *
     * @param user
     */
    @PostMapping("/register")
    public String register(SysUser user) {

        try {
            loginService.register(user);
            return "login";
        } catch (BaseException e) {
            System.out.println("用户已存在");
            return null;
        }
    }

    /**
     * 登录操作
     */
    @PostMapping("/login")
    public String login(String userName, String password, Model model) {
        /**
         *  UsernamePasswordToken参数说明
         *  String username;  //用户
         *  char[] password;  //密码
         *  boolean rememberMe; //记住密码
         *  String host;  //主机
         */
        //1.用户名/密码的认证机制
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        //2 .获取Subject 使用shiro编写认证操作
        Subject subject = SecurityUtils.getSubject();
        try {
            //3.执行登录方法
            subject.login(token);
            //获取用户信息的方法
            SysUser user = (SysUser) subject.getPrincipal();
            System.out.println("用户信息" + user.toString());
            //登陆成功
            //跳转到登录成功页面
            return "redirect:/login/loginSuccess";
        } catch (UnknownAccountException e) {
            //用户不存在
            model.addAttribute("msg", "用户不存在");
            return "login";
        } catch (AuthenticationException e) {
            //用户不存在
            model.addAttribute("msg", "用户或者密码错误");
            return "login";
        }
    }
}
