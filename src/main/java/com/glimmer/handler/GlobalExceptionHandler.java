package com.glimmer.handler;


import com.glimmer.constant.HttpStatusConstant;
import com.glimmer.constant.MessageConstant;
import com.glimmer.exception.*;
import com.glimmer.result.Result;
import com.glimmer.vo.StatusVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常并进行处理
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ResponseEntity exceptionHandler(BaseException ex){
        log.error("异常信息：{}", ex.getMessage());
        StatusVO statusVO = StatusVO.builder()
                .status(1) // 0-正常 1-异常
                .message(ex.getMessage()).build();
        return new ResponseEntity(Result.error(HttpStatusConstant.SERVICE_UNAVAILABLE,statusVO,ex.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }


    /**
     * 统一处理SQL异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ResponseEntity exceptionHandler(SQLException ex) {
        log.error("异常信息：{}",ex.getMessage());
        /**
         * 统一处理其他SQL异常
         */
        StatusVO statusVO = StatusVO.builder()
                .status(1)
                .message(MessageConstant.UNKNOWN_ERROR)
                .build();
        return new ResponseEntity(Result.error(HttpStatusConstant.SERVICE_UNAVAILABLE, statusVO,MessageConstant.UNKNOWN_ERROR),HttpStatus.SERVICE_UNAVAILABLE);
    }

}
