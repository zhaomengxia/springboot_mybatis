package com.springsecurityjwt.springsecurityjwt.filter;

import com.springsecurityjwt.springsecurityjwt.constant.ConstantKey;
import com.springsecurityjwt.springsecurityjwt.exception.TokenException;
import com.springsecurityjwt.springsecurityjwt.service.impl.GrantedAuthorityImpl;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 * @Author zhaomengxia  这个模块中登录有两种一种是使用spring specurity框架提供的默认登录url localhost:18081/login
 * 使用JwtAuthenticationTwoFilter这一个，注意WebSecurityConfig类里将 .addFilter(new JWTLoginFilter(authenticationManager()))
 *             和 .addFilter(new JwtAuthenticationTwoFilter(authenticationManager()))两个的注释放开，将 http.addFilterBefore(jwtAuthenticationTwoFilter(),UsernamePasswordAuthenticationFilter.class);注释
 *另一种是采用自己写的登录接口 url为http://localhost:18081/user/login 是将WebSecurityConfig中的http.addFilterBefore(jwtAuthenticationTwoFilter(),UsernamePasswordAuthenticationFilter.class);注释放开，将另外两个注释，本项目中是采用这一种方法
 * @create 2019/9/20 15:10
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    // 指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。

    private static final String JWT_SECRET = ConstantKey.SIGNING_KEY;// JWT密匙

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken=  getAuthention(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }


    private UsernamePasswordAuthenticationToken getAuthention(HttpServletRequest servletRequest){

        long start=System.currentTimeMillis();
        String token=servletRequest.getHeader("Authorization");
        if (token==null||token.isEmpty()){
            throw new TokenException("Token 不能为空！");
        }
        String stringKey = JWT_SECRET;
        String user=null;
        try {
        user= Jwts.parser()
                .setSigningKey(Base64.decodeBase64(stringKey))
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody()
                .getSubject();
        long end=System.currentTimeMillis();
        logger.info("执行时间：{}",end-start+"ms");

        if (user!=null){
            String[] split=user.split("-")[1].split(",");
            ArrayList<GrantedAuthority> authorities=new ArrayList<>();
            for (int i=0;i<split.length;i++){
                authorities.add(new GrantedAuthorityImpl(split[i]));
            }
            return new UsernamePasswordAuthenticationToken(user,null,authorities);
        }
        } catch (ExpiredJwtException e) {
            logger.error("Token已过期: {} " + e);
            throw new TokenException("Token已过期");
        } catch (UnsupportedJwtException e) {
            logger.error("Token格式错误: {} " + e);
            throw new TokenException("Token格式错误");
        } catch (MalformedJwtException e) {
            logger.error("Token没有被正确构造: {} " + e);
            throw new TokenException("Token没有被正确构造");
        } catch (SignatureException e) {
            logger.error("签名失败: {} " + e);
            throw new TokenException("签名失败");
        } catch (IllegalArgumentException e) {
            logger.error("非法参数异常: {} " + e);
            throw new TokenException("非法参数异常");
        }

        return null;

    }
}
