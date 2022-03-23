package com.demo.task.controller;

import com.demo.task.entity.User;
import com.demo.task.exception.ServiceException;
import com.demo.task.service.UserService;
import com.demo.task.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆相关controller
 *
 * @author  linsm
 * @date 2022/3/14 8:19 下午
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public R login(String account, String password, HttpServletRequest request) throws Exception {
        User user = userService.getLoginUser(account,password);
        if(user != null) {
            //登陆成功重定向,保存session
            request.getSession().setAttribute("user", user);
        } else {
            throw new ServiceException("用户名或密码错误");
        }
        return R.ok(user);
    }

    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath()+"login.html");
    }
}
