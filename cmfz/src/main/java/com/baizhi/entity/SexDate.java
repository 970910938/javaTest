package com.baizhi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skl on 2018/6/4.
 */
public class SexDate {
    List<Province> gril=new ArrayList<Province>();
    List<Province> boy=new ArrayList<Province>();

    public SexDate(List<Province> gril, List<Province> boy) {
        this.gril = gril;
        this.boy = boy;
    }

    public SexDate() {
    }

    public List<Province> getGril() {
        return gril;
    }

    public void setGril(List<Province> gril) {
        this.gril = gril;
    }

    public List<Province> getBoy() {
        return boy;
    }

    public void setBoy(List<Province> boy) {
        this.boy = boy;
    }

    @Override
    public String toString() {
        return "SexDate{" +
                "gril=" + gril +
                ", boy=" + boy +
                '}';
    }
}
