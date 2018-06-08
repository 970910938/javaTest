package com.baizhi.controller;

import com.baizhi.entity.Broad;
import com.baizhi.service.BroadService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by skl on 2018/5/30.
 */
@Controller
@RequestMapping("/broad")
public class BroadController {
    @Autowired
    private BroadService broadServiceImpl;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<Broad> queryAll() {
        List<Broad> broads = broadServiceImpl.queryAll();
        return broads;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(Broad broad) {
        System.out.println(broad);
        broadServiceImpl.update(broad);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(Broad broad) {
        System.out.println(broad);
        broadServiceImpl.delete(broad);
    }


    /*上传图片 获取当前文件  存储位置  文件覆盖的问题（重命名）*/
    @RequestMapping(value = "/add")
    @ResponseBody
    /*MultipartFile img, String status, String desc, String title, HttpServletRequest request*/
    public void add(MultipartFile img, Integer status, String des, String title, HttpServletRequest request) {
        /*获取当前项目的项目的路径*/
        String realPath = request.getSession().getServletContext().getRealPath("/");
        /*创建当前项目的对象*/
        File file = new File(realPath);
        /*找到当前当前所在webapps的路径*/
        String webappsPath = file.getParent();
        /*上传的文件夹在此webapps中   获取上传文件夹的路径的对象*/
        File uploadPath = new File(webappsPath + "/upload");
        if (!uploadPath.exists()) {
            uploadPath.mkdir();
        }
        /*获取原始上传文件的文件名  1.jpg*/
        String oldFilename = img.getOriginalFilename();
        /*获取后缀名*/
        String extension = FilenameUtils.getExtension(oldFilename);
        UUID uuid = UUID.randomUUID();
        String newFilename = uuid.toString();
        /*获取新的文件名*/
        newFilename = newFilename + "." + extension;
        /*将图片上传到指定*/
        try {
            img.transferTo(new File(uploadPath.getPath(), newFilename));
            System.out.println(uploadPath.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Broad broad = new Broad();
        broad.setTitle(title);
        broad.setImgPath("\\" + "upload" + "\\" + newFilename);
        broad.setDes(des);
        broad.setStatus(status);
        broad.setDate(new Date());

        System.out.println(broad);
        broadServiceImpl.insert(broad);
    }
    /*接受专辑的信息封装对象，图片调用uploadutils方法建表时在childern中加入pid*/
    /*下载所需要的参数url 和 name可通过getselected方法从数据库中获取老名子和url，，，*/
    //public void down(String url, String name, HttpServletResponse response, HttpServletRequest request) {}

}
