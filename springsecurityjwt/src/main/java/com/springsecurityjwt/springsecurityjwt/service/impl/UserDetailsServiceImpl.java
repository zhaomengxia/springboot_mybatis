package com.springsecurityjwt.springsecurityjwt.service.impl;

import com.springsecurityjwt.springsecurityjwt.dto.JwtAuthenticationResponse;
import com.springsecurityjwt.springsecurityjwt.dto.UserDTO;
import com.springsecurityjwt.springsecurityjwt.filter.JwtTokenProvider;
import com.springsecurityjwt.springsecurityjwt.model.User;
import com.springsecurityjwt.springsecurityjwt.model.UserPrincipal;
import com.springsecurityjwt.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Collections.emptyList;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    /**
     * 通过构造器注入UserRepository
     * @param userRepository
     */
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findAllByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());
    }


    public UserDTO findAll(String name){
      User users=userRepository.findAllByUsername(name);
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(users,userDTO);
        return userDTO;
    }

    @Transactional
    public UserDetails loadUserByUserName(String userName){
        User user=userRepository.findAllByUsername(userName);
        return UserPrincipal.create(user);
    }

    public JwtAuthenticationResponse login(String username, String password, HttpServletResponse response) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String token=jwtTokenProvider.successfulAuthentication(response,authenticate);
        return new JwtAuthenticationResponse(token,  authenticate.getPrincipal());
    }


}
