package com.baizhi.controller1;

import com.baizhi.entity.Albuma;
import com.baizhi.entity1.Body;
import com.baizhi.entity1.Body1;
import com.baizhi.service1.AlbumTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by skl on 2018/6/6.
 */
@Controller
@RequestMapping("/test")
public class AlbumTest {
    @Autowired
    private AlbumTestService albumTestServiceImpl;
    @RequestMapping("/queryAlbuma")
    @ResponseBody
    public Body1 album(){
        Body1 body1 = albumTestServiceImpl.queryAlbuma();
        System.out.println(body1);
        return body1;
    }
    @RequestMapping("/queryAlbuma3")
    @ResponseBody
    public Map<String, Object>album3(){
        Map<String, Object> map = albumTestServiceImpl.queryAll();
        System.out.println(map.get("introduction"));
        return map;
    }

}
