package com.baizhi.entity1;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by skl on 2018/6/6.
 */
public class Body implements Serializable {

    private String img;
    private String name;
    private String author;
    private String type;
    private Integer count;
    private Date  createDate;

    @Override
    public String toString() {
        return "Body{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", count=" + count +
                ", createDate=" + createDate +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Body() {
    }

    public Body(String img, String name, String author, String type, Integer count, Date createDate) {
        this.img = img;
        this.name = name;
        this.author = author;
        this.type = type;
        this.count = count;
        this.createDate = createDate;
    }
}
