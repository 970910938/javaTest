package com.baizhi.controller;

import com.baizhi.entity.Person;
import com.baizhi.entity.Province;
import com.baizhi.entity.SexDate;
import com.baizhi.entity.User;
import com.baizhi.service.PersonService;

import com.baizhi.util.CustomerExportUtil;
import com.baizhi.util.InportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import java.util.Date;
import java.util.List;


/**
 * Created by skl on 2018/6/4.
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personServiceImpl;

    @RequestMapping("query")
    @ResponseBody
    public SexDate queryProvince() {
        return personServiceImpl.queryprovince();
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public List<Person> queryPerson() {
        return personServiceImpl.queryAll();
    }


    @ResponseBody
    @RequestMapping("/customerExport")
    public void customerExport(String titles, String fileds, HttpServletResponse response) {
        //数据行
        List<Person> users = personServiceImpl.queryAll();
        CustomerExportUtil.customerExport(users, titles, fileds, response);
    }
    @ResponseBody
    @RequestMapping("/importExport")
    public void importExport(MultipartFile multipartFile) {
        //数据行
        List<Person> list = InportUtil.importExcel(multipartFile);
        personServiceImpl.inport(list);
    }
}


