package com.baizhi.service1;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.PersonDao;
import com.baizhi.entity.Albuma;
import com.baizhi.entity.Person;
import com.baizhi.entity1.Body1;
import com.baizhi.util.SendMSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by skl on 2018/6/6.
 */
@Service
public class AlbumTestServiceImpl implements AlbumTestService {
    @Autowired
    private AlbumDao albumDao;
    private PersonDao personDao;
    private final Integer NUM = 6;

    /*第一个*/
    public Body1 queryAlbuma() {
        List<Albuma> list = albumDao.queryAll();
        Body1 body = new Body1();
        for (Albuma albuma : list) {
            albuma.setChildren(null);
        }
        body.setBodylist1(list);
        return body;
    }

    /*第三 个*/
    public Map<String, Object> queryAll() {
        List<Albuma> albumas = albumDao.queryAll();
        Map<String, Object> map = new HashMap<String, Object>();
        for (Albuma albuma : albumas) {
            map.put("introduction", albuma);
        }
        return map;
    }

    public int insert(Person person) {
        /*person的增删改查
        *
        * */

        return 0;
    }

    public Person query(String phone, String password) {
        return null;
    }

    public int update(Person person) {
        /*根据选填的uid查询出person 如果有返回该对象*/
        JSONObject jsonObject = new JSONObject();
          /*没有输出错误信息
            *   jsonObject.put("error",-200);
                jsonObject.put("errmsg","密码错误");
                return jsonObject;
            * */
        return 0;
    }


    /*第四个*/
    public JSONObject login(String phoneNumber, String password) {
        JSONObject jsonObject = new JSONObject();
        List<Person> list = personDao.queryAll();
        for (int i = 0; i < list.size(); i++) {
            if (phoneNumber.equals("111") & password.equals("222")) {
                /*根据账号密码进行查询所有用户*/
                /*如果存在返回该用户信息并存入jsonObject中
                *   jsonObject.put("id", user.getId());
                    jsonObject.put("name", user.getName());
                    jsonObject.put("password", user.getPassword());
                    jsonObject.put("date", user.getDate());
                    return jsonObject;
                * */
                return jsonObject;
            }
        }
        if (jsonObject == null) {
            /*输出错误信息
            *   jsonObject.put("error",-200);
                jsonObject.put("errmsg","电话号码已存在错误");
                return jsonObject;
            * */
            return jsonObject;
        }
        return jsonObject;
    }

    /*7获取验证码接口*/
        /*将收到的电话号码借助阿里大于发送验证信息*/
    public void test(String phone) throws ClientException {
        JSONObject jsonObject = new JSONObject();
        String code = "";
        Random r = new Random(new Date().getTime());
        for (int i = 0; i < NUM; i++) {
            code = code + r.nextInt(10);
        }
        SendMSG.sendMsg(phone,code);
        /*将验证码存放到redis中和用户输入的进行比较
        * 成功
        *jsonObject.put("result","success");
        *
        * */

    }
}
