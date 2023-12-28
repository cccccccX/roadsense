package com.roadsense.common.exception;

/**
 * author  Edith
 * created  2023/12/28 17:57
 */
//用户名重复
public class AccountRepeatException extends BaseException{
    public AccountRepeatException(){}

    public AccountRepeatException(String msg){
        super(msg);
    }
}
