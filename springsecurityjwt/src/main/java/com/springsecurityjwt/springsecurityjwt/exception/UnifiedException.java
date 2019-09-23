package com.springsecurityjwt.springsecurityjwt.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author zhaomengxia
 * @create 2019/9/20 16:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("unused")
public class UnifiedException extends RuntimeException {
    private static final long serialVersionUID = -3663785648260762719L;

    public UnifiedException(String message){
        this.message = message;
    }

    public UnifiedException(ExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }




    private Integer code;

    private String message;

    public UnifiedException(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    private IEnum iEnum;
}
