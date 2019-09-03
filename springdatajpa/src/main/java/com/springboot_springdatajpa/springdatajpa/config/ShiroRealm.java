package com.springboot_springdatajpa.springdatajpa.config;

import com.springboot_springdatajpa.springdatajpa.model.MenuModel;
import com.springboot_springdatajpa.springdatajpa.model.RoleModel;
import com.springboot_springdatajpa.springdatajpa.model.UserModel;
import com.springboot_springdatajpa.springdatajpa.repository.MenuDAO;
import com.springboot_springdatajpa.springdatajpa.repository.UserRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @Author zhaomengxia
 * @create 2019/9/3 10:06
 */
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuDAO menuDAO;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo"+principalCollection.toString());
        UserModel userModel=userRepository.findByUsername((String) principalCollection.getPrimaryPrincipal());
        //把principals放session中，key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(userModel.getUserId()),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();

        List<RoleModel> roleModels=menuDAO.findByUserID(userModel.getUserId());
        for (RoleModel roleModel:roleModels){
            info.addRole(roleModel.getRoleName());
        }

        List<MenuModel> menuModels=menuDAO.findByUserId(userModel.getUserId());
        for (MenuModel menuModel:menuModels){
            info.addStringPermission(menuModel.getPermission());
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo"+authenticationToken.toString());

        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;

        String userName=token.getUsername();
        logger.info(userName+token.getPassword());

        UserModel userModel=userRepository.findByUsername(userName);
        if (userModel!=null){
            Session session=SecurityUtils.getSubject().getSession();
            session.setAttribute("userModel",userModel);
            return new SimpleAuthenticationInfo(userName,userModel.getPassword(),getName());
        }
        else{
            return null;
        }

    }
}
