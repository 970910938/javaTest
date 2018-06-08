package com.baizhi.dao;

import com.baizhi.entity.Person;
import com.baizhi.entity.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by skl on 2018/6/4.
 */
public interface PersonDao {
    public List<Province> queryprovince(String sex);
    public List<Person> queryAll();
    public void insert(List<Person> list);

}
