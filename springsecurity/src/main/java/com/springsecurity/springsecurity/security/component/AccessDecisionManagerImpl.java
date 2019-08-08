package com.springsecurity.springsecurity.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 15:12
 *
 * 写一个类实现接口AccessDecisionManager，给类添加注解@Component。
 * 接收FilterInvocationSecurityMetadataSourceImpl返回的访问当前url所需要的权限的
 * 列表，下面decide方法的第三个参数，并结合当前用户的信息（decide方法的第一个参数），决定用户是否可以访问这个url。
 *
 * 当前这个类的功能是：根据当前用户的信息，和目标url涉及到的权限，判断用户是否可以访问。
 * 判断的规则是：当前用户只要匹配到url权限中的一个role即可。
 *
 */
@Component
public class AccessDecisionManagerImpl  implements AccessDecisionManager{
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //利用迭代器遍历目标url的权限列表
        Iterator<ConfigAttribute> iterator=collection.iterator();
        while (iterator.hasNext()){
            ConfigAttribute configAttribute=iterator.next();

            String needRole=configAttribute.getAttribute();

            if ("ROLE_LOGIN".equals(needRole)){
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new BadCredentialsException("未登录");
                }else
                    return;
            }
            //遍历当前用户所具有的权限
            Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority:authorities){
                if (grantedAuthority.getAuthority().equals(needRole)){
                    return;
                }
            }

        }
        //这里说明没有匹配到应有的权限
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
