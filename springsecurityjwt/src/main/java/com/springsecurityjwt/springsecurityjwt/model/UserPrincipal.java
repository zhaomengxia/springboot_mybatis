package com.springsecurityjwt.springsecurityjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author zhaomengxia
 * @create 2019/9/23 10:45
 */
@Data
public class UserPrincipal implements UserDetails {

    private long userId;
    private String username;
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private String sex;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private String token;
    public UserPrincipal(long userId, String username, String realname, String avatar, String phone, String email, String sex, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.realname = realname;
        this.avatar = avatar;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        return new UserPrincipal(
                user.getUserId(),
                user.getUsername(),
                user.getRealname(),
                user.getAvatar(),
                user.getPhone(),
                user.getEmail(),
                user.getSex(),
                authorities
        );
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
