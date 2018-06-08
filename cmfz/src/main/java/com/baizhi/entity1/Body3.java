package com.baizhi.entity1;

import com.baizhi.entity.Albuma;

/**
 * Created by skl on 2018/6/6.
 */
public class Body3 {
    private Albuma albuma;

    public Body3() {
    }

    @Override
    public String toString() {
        return "Body3{" +
                "albuma=" + albuma +
                '}';
    }

    public Albuma getAlbuma() {
        return albuma;
    }

    public void setAlbuma(Albuma albuma) {
        this.albuma = albuma;
    }

    public Body3(Albuma albuma) {
        this.albuma = albuma;
    }
}
