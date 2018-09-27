package com.baizhi.util;

import com.baizhi.entity.Person;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by skl on 2018/6/5.
 * 文件导入xxx.xls
 */
public class InportUtil {
    public static List<Person> importExcel(MultipartFile multipartFile){
        Workbook workbook = null;

        List<Person> rows = new ArrayList<Person>();
        try {
            InputStream inputStream = multipartFile.getInputStream();
             workbook = new HSSFWorkbook(inputStream);
            Sheet sheet=null;
            /*一张表225个判断有几张表*/
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheet = workbook.getSheetAt(i);
            }
            /*获取表的总行数*/
            int rowsnum = sheet.getLastRowNum();
            for (int i = 1; i <=rowsnum; i++) {
                Row row = sheet.getRow(i);
                Person person = new Person();
                /*lastCellNum是总的格数*/
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    //Cell cell = row.getCell(j);
                    System.out.println(row.getLastCellNum());
                    switch (j){
                        case 0: person.setId        (row.getCell(0).getStringCellValue()); break;
                        case 1: person.setPhoneNum   (row.getCell(1).getStringCellValue()); break;
                        case 2: person.setUsername   (row.getCell(2).getStringCellValue()); break;
                        case 3: person.setPassword  (row.getCell(3).getStringCellValue()); break;
                        case 4: person.setSalt      (row.getCell(4).getStringCellValue()); break;
                        case 5: person.setDharmaName(row.getCell(5).getStringCellValue()); break;
                        case 6: person.setProvince  (row.getCell(6).getStringCellValue()); break;
                        case 7: person.setCity      (row.getCell(7).getStringCellValue()); break;
                        case 8: person.setSex       (row.getCell(8).getStringCellValue()); break;
                        case 9: person.setSign      (row.getCell(9).getStringCellValue()); break;
                        case 10: person.setHeadPic  (row.getCell(10).getStringCellValue()); break;
                        case 11: person.setDate     (row.getCell(11).getDateCellValue()); break;
                        case 12: person.setStatus   (row.getCell(12).getStringCellValue()); break;
                        default: break;
                    }
                }
                rows.add(person);
                System.out.println(rows);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;

    }
}
