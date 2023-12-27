package com.roadsense.common.exception;

/**
 * author  Edith
 * created  2023/12/27 21:32
 */
public class BaseException extends RuntimeException{
    public BaseException(){}

    public BaseException(String msg){
        super(msg);
    }
}
