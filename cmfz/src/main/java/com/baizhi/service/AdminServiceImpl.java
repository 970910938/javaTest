package com.baizhi.service;

import com.baizhi.annotation.LogAnnotation;
import com.baizhi.annotation.LogTest;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by skl on 2018/5/29.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    public Admin login(Admin admin) {
        Admin admin1 = adminDao.login(admin);
        return admin1;
    }
    @LogTest(value = "这是个测试")
    @LogAnnotation(name = "修改密码")
    public void modfiy(Admin admin){
        System.out.println("密码修改为"+admin.getPassword());
        adminDao.modfiy(admin);
    }
}
