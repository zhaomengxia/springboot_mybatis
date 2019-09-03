package com.springboot_springdatajpa.springdatajpa;

import com.alibaba.fastjson.JSON;
import com.springboot_springdatajpa.springdatajpa.model.AuthModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Java反射注解妙用（获取所有接口说明）
 * 这里用反射来获取所有接口的信息，接口再多，也不过几秒钟的事情
 * @Author zhaomengxia
 * @create 2019/9/3 14:29
 */
public class AnnoTest {

    public static void main(String[] args) {

        getRequestMappingMethod("com.springboot_springdatajpa.springdatajpa.controller");
    }



    private static void getRequestMappingMethod(String scanPackage){
        //设置扫描路径
        Reflections reflections=new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(scanPackage)).addScanners(new MethodAnnotationsScanner()));

        //扫描包内带有@RequiresPermissions注解的所有方法集合
        Set<Method> methods=reflections.getMethodsAnnotatedWith(RequiresPermissions.class);

        List<AuthModel> authModels=new ArrayList<>();
        Date now=new Date();

        //循环获取方法
        methods.forEach(method -> {
            String methodType="";
                //获取类上的RequestMapping注解的值，作为请求的基础路径
                String authUrl = method.getDeclaringClass().getAnnotation(RequestMapping.class).value()[0];

                if (method.getAnnotation(PutMapping.class) != null) {
                    methodType = "put";
                    if (method.getAnnotation(PutMapping.class).value().length > 0) {
                        authUrl = method.getAnnotation(PutMapping.class).value()[0];
                    }
                } else if (method.getAnnotation(GetMapping.class) != null) {
                    methodType = "get";
                    if (method.getAnnotation(GetMapping.class).value().length > 0) {
                        authUrl = method.getAnnotation(GetMapping.class).value()[0];
                    }
                } else if (method.getAnnotation(PostMapping.class) != null) {
                    methodType = "post";
                    if (method.getAnnotation(PostMapping.class).value().length > 0) {
                        authUrl = method.getAnnotation(PostMapping.class).value()[0];
                    }
                } else if (method.getAnnotation(DeleteMapping.class) != null) {
                    methodType = "delete";
                    if (method.getAnnotation(DeleteMapping.class).value().length > 0) {
                        authUrl = method.getAnnotation(DeleteMapping.class).value()[0];
                    }
                }

                AuthModel authModel = new AuthModel();
                authModel.setMethodType(methodType);
                authModel.setAuthUniqueMark(method.getAnnotation(RequiresPermissions.class).value()[0]);
                authModel.setAuthUrl(authUrl);
                    authModel.setAuthName(method.getDeclaringClass().getAnnotation(Api.class).value() +
                            "-" + method.getAnnotation(ApiOperation.class).value());
                authModel.setCreateTime(now);
                authModels.add(authModel);
        });

        System.out.println(JSON.toJSONString(authModels));

    }
}
