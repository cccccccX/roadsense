package com.roadsense.handler;

import com.roadsense.common.result.Result;
import com.roadsense.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * author  Edith
 * created  2023/12/27 21:44
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        log.error("异常信息: {}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

}
