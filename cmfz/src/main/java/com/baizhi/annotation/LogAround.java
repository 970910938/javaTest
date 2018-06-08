package com.baizhi.annotation;



import com.baizhi.dao.LogDao;
import com.baizhi.entity.Admin;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by skl on 2018/6/6.
 * 该类为为原始类添加额外功能的代理类
 * 对service中必要的方法进行日志记录
 */

public class LogAround implements MethodInterceptor {
    @Autowired
    private LogDao logDao;
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        /*什么事*/
        Method method = methodInvocation.getMethod();
        /*获取该注解的对象信息*/
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        /*获取所加自定义注解的方法的名字*/
        String name = annotation.name();
        System.out.println("当前所进行的操作为"+name);

        /*什么时间*/
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        System.out.println("时间为"+s);

        Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println("我是decl"+declaredAnnotation);
        }

        /*什么人*/
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        Admin admin = (Admin)session.getAttribute("admin1");
        System.out.println("操作人员"+admin.getName());
        System.out.println("环绕通知前");
        /*模拟有此注解的原始方法*/
        Object res = methodInvocation.proceed();
        System.out.println("环绕通知后");
        StringBuffer sb = new StringBuffer();
        sb.append(admin.getName());
        sb.append("在");
        sb.append(s);
        sb.append("操作了");
        sb.append(name);
        System.out.println("我是sb----"+sb);
        logDao.insertLog(sb+"");
        return res;
    }
}
