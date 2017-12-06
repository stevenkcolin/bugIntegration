package com.aethercoder.exception;

import com.aethercoder.exception.entity.ReqExceptionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ReqExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 异常处理方法
     * 返回500
     */

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)  // 500
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ReqExceptionEntity handleException(Exception ex) {
        logger.error("Exception", ex);
        return ReqExceptionEntity.bulid(ex.getMessage(), ex.getStackTrace());
    }


}
