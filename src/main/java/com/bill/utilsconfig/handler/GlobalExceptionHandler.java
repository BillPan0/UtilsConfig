package com.bill.utilsconfig.handler;


import com.bill.utilsconfig.common.ResultBody;
import com.bill.utilsconfig.common.ResultStatusEnum;
import com.bill.utilsconfig.exception.CustomException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Bill
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param e 异常对象
     * @return 响应体
     */
    @ExceptionHandler(value = CustomException.class)
    public ResultBody<String> customExceptionHandler(CustomException e){
        log.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     * @param e 异常对象
     * @return 响应体
     */
    @ExceptionHandler(value =NullPointerException.class)
    public ResultBody<String> exceptionHandler(NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return ResultBody.error(ResultStatusEnum.Format_ERROR);
    }


    /**
     * 处理其他异常
     * @param e 异常对象
     * @return 响应体
     */
    @ExceptionHandler(value =Exception.class)
    public ResultBody<String> exceptionHandler(Exception e){
        log.error("未知异常！原因是:",e);
        return ResultBody.error(ResultStatusEnum.INTERNAL_SERVER_ERROR);
    }
}
