package com.baizhi.dao;

import com.baizhi.entity.Albuma;
import com.baizhi.entity.Albumb;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by skl on 2018/6/1.
 */
public interface AlbumDao {
    public List<Albuma> queryAll();
    public void add(@Param("albuma") Albuma albuma);
    public void addzj(@Param("albumb")Albumb albumb);
    public void updateCount(@Param("id")Integer id,@Param("count")Integer count);
    /*查看专辑里有多少章节*/
    //public void queryzj()
}
