package com.baizhi.controller;

import com.baizhi.entity.Albuma;
import com.baizhi.entity.Albumb;
import com.baizhi.entity.Echarts;
import com.baizhi.entity.FileParam;
import com.baizhi.service.AlbumService;
import com.baizhi.util.FileSizeFormater;
import com.baizhi.util.UploadUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by skl on 2018/5/31.
 */
@Controller
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumServiceImpl;
    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Albuma> queryAll(){
        List<Albuma> list = albumServiceImpl.queryAll();
        System.out.println(list);
        return list;
    }
    /*添加专辑*/
    @RequestMapping("/addzhuanji")
    @ResponseBody
    public void add(String name,String score,MultipartFile multipartFile, HttpServletRequest request){
        //System.out.println(add_id);
        FileParam param = UploadUtils.upload(multipartFile, request, UploadUtils.FILE);
        String img = param.getUrl();
        Albuma albuma = new Albuma();
        albuma.setName(name);
        albuma.setScore(score);
        albuma.setImg(img);
        albumServiceImpl.add(albuma);


    }
    /*章节里边有 id,name,size,url,pid,time */
    @RequestMapping("/add")
    @ResponseBody
    public void addzj(MultipartFile multipartFile,Integer pid,HttpServletRequest request){
        FileParam fileParam = UploadUtils.upload(multipartFile, request, UploadUtils.AUDIO);
        String url = fileParam.getUrl();
        String oldname = fileParam.getOldname();
        Albumb albumb = new Albumb();
        albumb.setPid(pid);
        albumb.setName(oldname);
        albumb.setUrl(url);
        albumb.setTime("20");
        String s = FileSizeFormater.addSize(multipartFile.getSize());
        albumb.setSize(s);
        albumServiceImpl.addzj(albumb);
        System.out.println("controller-----已执行");
    }

    /**
     *
     * @param url   文件的存储位置
     * @param name 下载后的新名字
     * @param response
     * @param request
     */
    @RequestMapping("/down")
    @ResponseBody
    public void downLoad(String url, String name, HttpServletResponse response,HttpServletRequest request){
        /*当前项目的路径*/
        String projectPath = request.getSession().getServletContext().getRealPath("/");
        /*当前项目路径的对象*/
        File file = new File(projectPath);
        String webappsPath = file.getParent();
        String filePath = webappsPath + url;
        /*需要下载的文件对象*/
        File downFile = new File(filePath);
        /*将文件下载到浏览器上  设置响应头、响应类型*/
        String filename=null;
        try {
           filename = new String(name.getBytes("UTF-8"),"ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition","attachment;fileName="+filename);
        response.setContentType("audio/mpeg");
        //响应出去
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(downFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   @RequestMapping("/echarts")
   @ResponseBody
   public List<Echarts> echarts(){
       List<Echarts> list = albumServiceImpl.queryZj();
       System.out.println(list);
       return list;
   }

}
