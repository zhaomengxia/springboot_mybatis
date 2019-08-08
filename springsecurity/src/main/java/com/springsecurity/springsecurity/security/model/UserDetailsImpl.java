package com.springsecurity.springsecurity.security.model;

import com.springsecurity.springsecurity.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/8/8 11:37
 * 1.在我们的程序中，必须要有一个类，实现UserDetailsService这个接口
 * 并且重写它的loadUserByUsername(String s)这个函数
 * 还必须要有一个类，实现UserDetails接口并重写其中的几个方法。
 * 因为这涉及到Spring Security框架的认证原理。在用户登录的时候，程序将用户输入的用户名
 * 和密码封装成一个类对象。然后根据用户名取数据库中查找用户的数据，封装成一个类对象放在内存中。
 * 将用户输入的数据与数据库中的数据进行比对，
 * 若密码正确就把用户信息的封装（包含身份信息、细节信息等）
 * 存到SecurityContextHolder中（类似session），使用的时候取出来即可。
 * 2.上诉过程中从数据库取出的用户信息封装不是简单的User实例，
 * 而是一个实现了UserDetails这个接口的类的对象，这个对象
 * 里面不仅有用户的账号密码信息，还有一些判断账号是否可用、判断账号是否过期、判断账号是否被锁定的函数。
 * 3.在验证过程中，负责根据用户输入的用户名返回数据库中用户信息的封装这个功能的就是Service，它实现了UserDetailsService，重写了
 * 它的loadUserByUsername(String s)方法，这个方法就是根据用户名返回了UserDetails的一个具体实现。
 */
public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private List<Role> roles;

    @Autowired
    private RoleService roleService;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(User user) {
        this.username = username;
        this.password = password;
    }

    public UserDetailsImpl(User user, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities=new ArrayList<>();
        for (Role role:roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 判断账号是否已经过期，默认没有过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 判断账号是否被锁定，默认没有锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断信用凭证是否过期，默认没有过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断账号是否可用，默认可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
