package com.springsecurityjwt.springsecurityjwt.dto;

import com.springsecurityjwt.springsecurityjwt.model.UserPrincipal;

/**
 * @Author zhaomengxia
 * @create 2019/9/23 11:00
 */
public class JwtAuthenticationResponse {
    private String accessToken;

    private String tokenType = "Bearer";

    private Object userInfo;

    public JwtAuthenticationResponse(String accessToken, Object userInfo) {
        this.accessToken = accessToken;
        this.userInfo = userInfo;
    }

    public Object getUserInfo() {
        return userInfo;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
