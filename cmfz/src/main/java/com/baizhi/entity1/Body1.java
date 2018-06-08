package com.baizhi.entity1;

import com.baizhi.entity.Albuma;

import java.util.List;

/**
 * Created by skl on 2018/6/6.
 */
public class Body1 {
    private List<Albuma> bodylist1;

    @Override
    public String toString() {
        return "Body1{" +
                "bodylist1=" + bodylist1 +
                '}';
    }

    public List<Albuma> getBodylist1() {
        return bodylist1;
    }

    public void setBodylist1(List<Albuma> bodylist1) {
        this.bodylist1 = bodylist1;
    }

    public Body1() {
    }

    public Body1(List<Albuma> bodylist1) {
        this.bodylist1 = bodylist1;
    }
}
