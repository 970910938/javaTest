package com.baizhi.service;

import com.baizhi.entity.Person;
import com.baizhi.entity.Province;
import com.baizhi.entity.SexDate;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by skl on 2018/6/4.
 */
public interface PersonService {
    public SexDate queryprovince();
    public List<Person> queryAll();
    public void inport(List<Person> list);

}
