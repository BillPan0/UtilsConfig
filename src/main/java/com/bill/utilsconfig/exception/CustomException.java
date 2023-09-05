package com.bill.utilsconfig.exception;

import com.bill.utilsconfig.exception.iface.BaseExceptionInfoInterface;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Bill
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public CustomException() {
        super();
    }

    /**
     * 构造方法，用于手动抛出异常CustomException时调用构造Exception
     * @param baseExceptionInfoInterface 自定义异常信息枚举类
     */
    public CustomException(BaseExceptionInfoInterface baseExceptionInfoInterface) {
        super(baseExceptionInfoInterface.getResultMsg());
        this.errorCode = baseExceptionInfoInterface.getResultCode();
        this.errorMsg = baseExceptionInfoInterface.getResultMsg();
    }

    public CustomException(BaseExceptionInfoInterface baseExceptionInfoInterface, Throwable cause) {
        super(baseExceptionInfoInterface.getResultMsg(), cause);
        this.errorCode = baseExceptionInfoInterface.getResultCode();
        this.errorMsg = baseExceptionInfoInterface.getResultMsg();
    }

    public CustomException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public CustomException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public CustomException(String errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
