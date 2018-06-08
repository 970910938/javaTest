package com.baizhi.entity;

/**
 * Created by skl on 2018/5/31.
 */
public class FileParam {
    private String url;
    private String oldname;

    @Override
    public String toString() {
        return "FileParam{" +
                "url='" + url + '\'' +
                ", oldname='" + oldname + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public FileParam() {
    }

    public FileParam(String url, String oldname) {
        this.url = url;
        this.oldname = oldname;
    }
}
