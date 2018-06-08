package com.baizhi.service;

import com.baizhi.entity.Albuma;
import com.baizhi.entity.Albumb;
import com.baizhi.entity.Echarts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by skl on 2018/6/1.
 */
public interface AlbumService {
    public List<Albuma> queryAll();
    public List<Echarts> queryZj();
    public void add(@Param("albuma") Albuma albuma);
    public void addzj(@Param("albumb")Albumb albumb);
}
