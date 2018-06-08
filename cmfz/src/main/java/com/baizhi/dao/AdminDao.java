package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * Created by skl on 2018/5/29.
 */
public interface AdminDao {
    public Admin login(@Param("admin") Admin admin);
    public void modfiy(@Param("admin") Admin admin);
}
