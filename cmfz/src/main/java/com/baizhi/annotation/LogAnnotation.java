package com.baizhi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by skl on 2018/6/6.
 * string 为注解属性类型
 * name 为属性
 */
@Target(ElementType.METHOD )
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    /*通过反射可获取service方法上所加该注解的方法名*/
    String name();
}
