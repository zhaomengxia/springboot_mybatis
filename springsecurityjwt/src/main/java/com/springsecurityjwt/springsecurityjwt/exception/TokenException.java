package com.springsecurityjwt.springsecurityjwt.exception;

/**
 * @Author zhaomengxia
 * @create 2019/9/20 15:18
 */
public class TokenException extends BaseException{

    private static final long serialVersionUID = 1L;

    public TokenException(String message) {
        super(message);
    }
}
