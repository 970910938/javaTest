package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by skl on 2018/5/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public List<Menu> queryCategory() {
        List<Menu> menus = userDao.queryCategory();
        return menus;
    }
}
