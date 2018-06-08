package com.baizhi.service;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Albuma;
import com.baizhi.entity.Albumb;
import com.baizhi.entity.Echarts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by skl on 2018/6/1.
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;
    public List<Albuma> queryAll() {
        List<Albuma> albumas = albumDao.queryAll();
        return albumas ;
    }
    /*添加专辑*/
    public void add(Albuma albuma) {
        albuma.setCreateDate(new Date());
        albumDao.add(albuma);
        System.out.println("我是albuma"+albuma);

    }
    /*添加章节*/
    public void addzj(Albumb albumb) {
        albumDao.addzj(albumb);

        List<Albuma> list = albumDao.queryAll();
        Integer count=0;
        for (Albuma aa:list) {
            if(aa.getId()==albumb.getPid()){
                count = aa.getCount();
                if(count==null)count=0;
                count++;
                albumDao.updateCount(aa.getId(),count);
            }
        }
        System.out.println("我是list--"+list);
        System.out.println("service-----已执行");
    }
    /*查询每个专辑下的章节数*/
    public List<Echarts> queryZj(){
        List<Albuma> albumas = albumDao.queryAll();
        List<Echarts> echarts1 = new ArrayList<Echarts>();
        for (Albuma aa:albumas
                ) {
            Echarts echarts = new Echarts();
            echarts.setName(aa.getName());
            echarts.setNumber(aa.getChildren().size());
            echarts1.add(echarts);
        }
        System.out.println(echarts1);
        return echarts1;
    }
}
