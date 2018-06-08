package com.baizhi.util;

import com.baizhi.entity.FileParam;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by skl on 2018/5/31.
 * 需要的参数，上传的文件，请求（获取当前项目路径存放在webapps下），上传类型
 */

public class UploadUtils {
    public static final String FILE = "FILE";
    public static final String AUDIO = "AUDIO";
    public static FileParam upload(MultipartFile multipartFile, HttpServletRequest request,String type){
        /*获取当前醒目路径*/
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(realPath);
        /*找到webapps路径*/
        String webappPath = file.getParent();
        String url;
        File uploadPath;
        if(type.equals(FILE)){
            /*根据类型判断所上传的文件夹【路径】*/
            uploadPath = new File(webappPath+"/upload");
            url="/upload";
        }else{
            uploadPath = new File(webappPath+"/audio");
            url = "/audio";
        }if(!uploadPath.exists()){
            uploadPath.mkdir();
        }
        /*上传之前的文件名*/
        String oldname = multipartFile.getOriginalFilename();
        /*获取上传文件的后缀名*/
        String extension = FilenameUtils.getExtension(oldname);
        UUID uuid = UUID.randomUUID();
        String newname = uuid.toString();
        newname = newname+"."+extension;
        /*上传到指定的文件夹*/
        try {
            //上传到指定的文件夹
            multipartFile.transferTo(new File(uploadPath.getPath(), newname));
        } catch (IOException e) {
            e.printStackTrace();
        }
    /*可将返回的url和老名子封装成对象存入数据库中*/
        return new FileParam(url+"/"+newname,oldname);
    }
}
