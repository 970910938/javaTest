package com.baizhi.entity;

import java.io.Serializable;

public class Province implements Serializable {
    private String name;
    private long value;

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Province() {
    }

    public Province(String name, long value) {
        this.name = name;
        this.value = value;
    }
}
