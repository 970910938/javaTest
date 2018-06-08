package com.baizhi.service;

import com.baizhi.entity.Broad;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by skl on 2018/5/30.
 */
public interface BroadService {
    public List<Broad> queryAll();
    public void insert(@Param("broad") Broad broad);
    public void delete(@Param("broad") Broad broad);
    public void update(@Param("broad") Broad broad);
}
