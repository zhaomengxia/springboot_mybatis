package com.springsecurityjwt.springsecurityjwt.config;

import com.springsecurityjwt.springsecurityjwt.filter.JWTLoginFilter;
import com.springsecurityjwt.springsecurityjwt.filter.JwtAuthenticationFilter;
import com.springsecurityjwt.springsecurityjwt.filter.JwtAuthenticationTwoFilter;
import com.springsecurityjwt.springsecurityjwt.handler.Http401AuthenticationEntryPoint;
import com.springsecurityjwt.springsecurityjwt.service.impl.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author zhaomengxia
 * @create 2019/9/16 14:00
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Bean
    public JwtAuthenticationTwoFilter jwtAuthenticationTwoFilter(){
        return new JwtAuthenticationTwoFilter();
    }

    private static final String[] AUTH_WHITELIST = {
            // -- register url
            "/user/signup",
            "/user/addTask",
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/user/login",
            "/login",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LogoutConfigurer<HttpSecurity> httpSecurityLogoutConfigurer=http.cors().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                   .authenticationEntryPoint(new Http401AuthenticationEntryPoint("Basic realm=\"MyApp\""))
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();

//        http.addFilterBefore(jwtAuthenticationTwoFilter(),UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService,bCryptPasswordEncoder));
    }
}
