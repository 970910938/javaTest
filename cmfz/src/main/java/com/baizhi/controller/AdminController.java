package com.baizhi.controller;

import com.baizhi.annotation.LogTest;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by skl on 2018/5/29.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminServiceImpl;

    //验证码
    @RequestMapping(value = "/img")
    public String imgAction(HttpSession session, HttpServletResponse response) {
        CreateValidateCode cvc = new CreateValidateCode();
        String code2 = cvc.getCode();
        session.setAttribute("code2", code2);
        System.out.println("生成的验证码——" + code2);
        try {
            cvc.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String encode, Admin admin, HttpSession session, HttpServletResponse response) {
        System.out.println("接受的验证码--" + encode);
        Admin admin1 = adminServiceImpl.login(admin);
        System.out.println(admin1);
        String code = encode.toLowerCase();
        session.setAttribute("admin1", admin1);
        String code2 = (String) session.getAttribute("code2");
        if (code.trim().equals(code2.trim()) && admin1 != null) {
            return "success";
        } else {
            throw new RuntimeException("验证码有问题");
        }
    }

    @RequestMapping("/modfiy")
    @ResponseBody
    public String modfiy(String password,HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin1");
        admin.setPassword(password);
       adminServiceImpl.modfiy(admin);
       session.setAttribute("admin1",admin);
        //System.out.println(admin);
        return "success";
    }
    @RequestMapping("/logout")
    //@ResponseBody
    public String logout(HttpSession session) {
        session.removeAttribute("admin1");
        System.out.println("清楚成功");
        return "redirect:/login.jsp";
    }
}

