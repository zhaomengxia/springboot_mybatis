package com.springsecurityjwt.springsecurityjwt.exception;

/**
 * @Author zhaomengxia
 * @create 2019/9/20 15:21
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
