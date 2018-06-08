package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by skl on 2018/5/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userServiceImpl;
    @RequestMapping("/catagory")
    @ResponseBody
    public List<Menu> test(){
        List<Menu> menus = userServiceImpl.queryCategory();
        return menus;
    }
}
