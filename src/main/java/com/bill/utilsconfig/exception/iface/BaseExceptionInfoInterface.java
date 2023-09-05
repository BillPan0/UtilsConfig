package com.bill.utilsconfig.exception.iface;

/**
 * 枚举类和自定义异常类的接口类
 * @author Bill
 */
public interface BaseExceptionInfoInterface {
    /**
     * 错误码获取，基类接口方法
     * @return 错误码
     */
    String getResultCode();

    /**
     * 错误描述获取，基类接口方法
     * @return 错误描述
     */
    String getResultMsg();
}
