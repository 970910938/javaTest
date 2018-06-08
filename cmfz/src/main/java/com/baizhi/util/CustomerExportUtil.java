package com.baizhi.util;

import com.baizhi.entity.Person;
import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by skl on 2018/6/5.
 * 文件导出
 */
public class CustomerExportUtil {
    public static void customerExport(List<Person> users, String titles, String fileds, HttpServletResponse response) {


        //标题行
        String[] title = titles.split(",");
        System.out.println("英文文件名--"+titles);
        String[] allFiled = fileds.split(",");
        System.out.println("文件名--"+fileds);
        Workbook workbook = new HSSFWorkbook();

        DataFormat dataFormat = workbook.createDataFormat();

        short format = dataFormat.getFormat("yyyy-MM-dd");

        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setDataFormat(format);

        Sheet sheet = workbook.createSheet("工作表");

        Row row = sheet.createRow(0);

        for (int i = 0; i < title.length; i++) {
            String s = title[i];
            Cell cell = row.createCell(i);
            cell.setCellValue(s);
        }
        //数据行
       // List<User> users = Arrays.asList(new User(0, "小黑0", "1234560", new Date()), new User(1, "小黑1", "1234561", new Date()), new User(2, "小黑2", "1234562", new Date()), new User(3, "小黑3", "1234563", new Date()), new User(4, "小黑4", "1234564", new Date()));

        for (int i = 0; i < users.size(); i++) {
            Row dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < allFiled.length; j++) {
                Cell cell = dataRow.createCell(j);
                //填充 id  name  password
                Class<? extends Person> userClass = users.get(i).getClass();
                String methodName = "get" + allFiled[j].substring(0, 1).toUpperCase() + allFiled[j].substring(1);
                try {
                    Object invoke = userClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                    if (invoke instanceof Date) {
                        sheet.setColumnWidth(j,18*256);
                        cell.setCellStyle(cellStyle);
                        cell.setCellValue((Date) invoke);
                    } else {
                        cell.setCellValue(invoke.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        String name = "用户自定义导出的数据.xls";
        String fileName = "";
        try {
            fileName = new String(name.getBytes("UTF-8"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;fileName=" + fileName);
        response.setContentType("application/vnd.ms-excel");
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
