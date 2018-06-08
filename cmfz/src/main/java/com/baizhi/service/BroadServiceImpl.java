package com.baizhi.service;

import com.baizhi.dao.BroadDao;
import com.baizhi.entity.Broad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by skl on 2018/5/30.
 */
@Service
public class BroadServiceImpl implements BroadService {
        @Autowired
        private BroadDao broadDao;
    public List<Broad> queryAll() {
        List<Broad> list = broadDao.queryAll();
        return list;
    }

    public void insert(Broad broad) {
        broadDao.insert(broad);
    }

    public void delete(Broad broad) {
        broadDao.delete(broad);
    }

    public void update(Broad broad) {
        broadDao.update(broad);
    }
}
