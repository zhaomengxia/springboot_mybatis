package com.springsecurityjwt.springsecurityjwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springsecurityjwt.springsecurityjwt.constant.ConstantKey;
import com.springsecurityjwt.springsecurityjwt.exception.ExceptionEnum;
import com.springsecurityjwt.springsecurityjwt.exception.UnifiedException;
import com.springsecurityjwt.springsecurityjwt.model.User;
import com.springsecurityjwt.springsecurityjwt.model.UserPrincipal;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 验证用户名密码正确之后，生成一个token，并将token返回给客户端，该方法继承自UsernamePasswordAuthenticationFilter。
 * 重写其中的两个方法attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 *
 * @Author zhaomengxia
 * @create 2019/9/20 14:38
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private static final String JWT_SECRET = ConstantKey.SIGNING_KEY;// JWT密匙
    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        String stringKey = JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    //接收并解析用户凭证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String token = null;
        try {
            Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();

            List roleList = new ArrayList();

            for (GrantedAuthority grantedAuthority :
                    authorities) {
                roleList.add(grantedAuthority.getAuthority());
            }
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            //设置签发时间  当前时间
            calendar.setTime(new Date());

            calendar.add(Calendar.HOUR, 10);//设置10个小时
            Date time = calendar.getTime();
            SecretKey secretKey = generalKey();
            token = Jwts.builder().setSubject(authResult.getName() + "-" + roleList)
                    .setIssuedAt(now)//签发时间
                    .setExpiration(time)//token有效时长
                    .signWith(SignatureAlgorithm.HS256,secretKey)
                    .compact();
            response.addHeader("Authorization", "Bearer " + token);
            System.out.println("Bearer " + token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
