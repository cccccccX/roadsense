package com.roadsense.common.exception;

/**
 * author  Edith
 * created  2023/12/27 21:42
 */
//用户名错误
public class AccountNotFoundException extends BaseException{
    public AccountNotFoundException(){}
    public AccountNotFoundException(String msg){
        super(msg);
    }
}
