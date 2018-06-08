package com.baizhi.service;

import com.baizhi.dao.PersonDao;
import com.baizhi.entity.Person;
import com.baizhi.entity.Province;
import com.baizhi.entity.SexDate;
import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by skl on 2018/6/4.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    public SexDate queryprovince() {
        SexDate sexDate = new SexDate();
        sexDate.setBoy(personDao.queryprovince("男"));
        sexDate.setGril(personDao.queryprovince("女"));
        return sexDate;
    }

    public List<Person> queryAll() {
        List<Person> list = personDao.queryAll();
        return list;
    }

    public void inport(List<Person> list) {
        personDao.insert(list);
        System.out.println("我是service--"+list);
    }

}
