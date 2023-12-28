package com.roadsense.common.exception;

/**
 * author  Edith
 * created  2023/12/27 21:41
 */
//登录失败
public class LoginFailedException extends BaseException{
    public LoginFailedException(){}

    public LoginFailedException(String msg){
        super(msg);
    }
}
