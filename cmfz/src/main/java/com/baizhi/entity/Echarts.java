package com.baizhi.entity;

/**
 * Created by skl on 2018/6/3.
 */
public class Echarts {
    private String name;
    private Integer number;

    @Override
    public String toString() {
        return "Echarts{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
