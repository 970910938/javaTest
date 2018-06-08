package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by skl on 2018/6/1.
 * 章节
 */
public class Albumb implements Serializable {
    private Integer id;
    private String name;
    private String size;
    private String url;
    private Integer pid;
    private String time;

    @Override
    public String toString() {
        return "Albumb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", time='" + time + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Albumb() {
    }

    public Albumb(Integer id, String name, String size, String url, Integer pid, String time) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.url = url;
        this.pid = pid;
        this.time = time;
    }
}
