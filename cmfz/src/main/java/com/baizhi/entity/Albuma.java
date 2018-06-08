package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by skl on 2018/6/1.
 * 专辑
 */
public class Albuma implements Serializable{
    private Integer id;
    private String name;
    private Integer count;
    private Date createDate;
    private String score;
    private String author;
    private String broadCast;
    private String brief;
    private String img;
    private List<Albumb> children;

    @Override
    public String toString() {
        return "Albuma{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", createDate=" + createDate +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", img='" + img + '\'' +
                ", children=" + children +
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Albumb> getChildren() {
        return children;
    }

    public void setChildren(List<Albumb> children) {
        this.children = children;
    }

    public Albuma() {
    }

    public Albuma(Integer id, String name, Integer count, Date createDate, String score, String author, String broadCast, String brief, String img, List<Albumb> children) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.createDate = createDate;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.img = img;
        this.children = children;
    }
}
