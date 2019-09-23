package com.springsecurityjwt.springsecurityjwt.filter;

import com.springsecurityjwt.springsecurityjwt.constant.ConstantKey;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @Author zhaomengxia
 * @create 2019/9/23 13:30
 */
@Component
public class JwtTokenProvider {
    private static final String JWT_SECRET = ConstantKey.SIGNING_KEY;// JWT密匙
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
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
    public String successfulAuthentication(HttpServletResponse response,
                                            Authentication authResult) throws IOException, ServletException {

        String token = null;
        String authentication=null;
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
            authentication="Bearer " + token;
            response.addHeader("Authorization", authentication);
            System.out.println(authentication);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authentication;
    }
    public String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        String[] s=claims.getSubject().split("-");

        return s[0];
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
