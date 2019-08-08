package com.springsecurity.springsecurity.security.component;

import com.springsecurity.springsecurity.security.model.Menu;
import com.springsecurity.springsecurity.security.model.Role;
import com.springsecurity.springsecurity.security.service.MenuService;
import com.springsecurity.springsecurity.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 14:41
 * 实现这个接口FilterInvocationSecurityMetadataSource，供系统调用，加注解@Component
 * 作用是在用户请求一个地址的时候，截获这个地址，告诉程序访问这个地址需要哪些权限角色。
 */
@Component
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource{

    @Autowired
    private MenuService menuService;

    /**
     * 接收用户请求地址，返回访问该地址需要的所有权限
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //用户的请求地址
        String url=((FilterInvocation)o).getRequestUrl();
        //如果登录页面就不需要权限
        if ("/login".equals(url)){
            return null;
        }
        Menu menu=menuService.getMenuByUrl(url);
        //如果没有匹配的url则说明都可以访问
        if (menu==null){
            return SecurityConfig.createList("ROLE_LOGIN");
        }
        //将menu所需要的角色按框架要求返回
        List<Role> roles=menuService.getAll(menu.getMenuId());
        int size=roles.size();
        String[] values=new String[size];

        for (int i=0;i<size;i++){
            values[i]=roles.get(i).getRoleName();
        }
        return SecurityConfig.createList(values);

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
