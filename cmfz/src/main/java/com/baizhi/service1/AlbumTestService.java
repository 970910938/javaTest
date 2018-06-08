package com.baizhi.service1;


import com.baizhi.entity.Albuma;
import com.baizhi.entity.Person;
import com.baizhi.entity1.Body;
import com.baizhi.entity1.Body1;

import java.util.List;
import java.util.Map;

/**
 * Created by skl on 2018/6/6.
 */
public interface AlbumTestService {
    public Body1 queryAlbuma();
    public Map<String,Object> queryAll();
    public int insert(Person person);
    public Person query(String phone,String password);
    public int update (Person person);
}
