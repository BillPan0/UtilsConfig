package com.bill.utilsconfig.common;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Bill
 */
@Data
public class ResultBody<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //响应代码
    private String code;
    //响应信息
    private String msg;
    //响应数据
    private T data;

    public ResultBody(){
    }

    public ResultBody(ResultStatusEnum resultStatusEnum, T data){
        this.code = resultStatusEnum.getCode();
        this.msg = resultStatusEnum.getResultMsg();
        this.data = data;
    }


    /**
     * 成功返回结果，第一个<T>为方法的泛型，第二个<T>是返回值的泛型
     * @param msg 成功信息
     */
    public static ResultBody<String> success(String msg) {
        ResultBody<String> resultBody = new ResultBody<>();
        resultBody.setCode(ResultStatusEnum.SUCCESS.getCode());
        resultBody.setMsg(msg);
        resultBody.setData(null);
        return resultBody;
    }

    /**
     * 成功返回结果，第一个<T>为方法的泛型，第二个<T>是返回值的泛型，第三个<T>为操作数据的泛型。
     * @param data 成功数据
     */
    public static <T> ResultBody<T> success(T data) {
        return new ResultBody<>(ResultStatusEnum.SUCCESS, data);
    }

    /**
     * 成功返回结果，第一个<T>为方法的泛型，第二个<T>是返回值的泛型，第三个<T>为操作数据的泛型。
     * @param data 成功数据
     */
    public static <T> ResultBody<T> success(String msg, T data) {
        ResultBody<T> resultBody = new ResultBody<>(ResultStatusEnum.SUCCESS, data);
        resultBody.setMsg(msg);
        return resultBody;
    }


    /**
     * 失败的情况，有错误码，代码流程中抛出的错误信息导致的常规错误
     * @param msg 服务端错误信息
     */
    public static ResultBody<String> error(ResultStatusEnum resultStatusEnum, String msg) {
        ResultBody<String> resultBody = new ResultBody<>();
        resultBody.setCode(resultStatusEnum.getCode());
        resultBody.setMsg(msg);
        resultBody.setData(null);
        return resultBody;
    }

    /**
     * 失败的情况，有错误码，代码流程中抛出的错误信息导致的常规错误
     * @param resultStatusEnum 服务端错误信息枚举类
     */
    public static ResultBody<String> error(ResultStatusEnum resultStatusEnum) {
        ResultBody<String> resultBody = new ResultBody<>();
        resultBody.setCode(resultStatusEnum.getCode());
        resultBody.setMsg(resultStatusEnum.getMsg());
        resultBody.setData(null);
        return resultBody;
    }

    /**
     * 失败的情况，自定义错误码，业务流程中抛出的错误信息导致的业务相关错误
     * @param msg 服务端错误信息
     */
    public static ResultBody<String> error(String code, String msg) {
        ResultBody<String> resultBody = new ResultBody<>();
        resultBody.setCode(code);
        resultBody.setMsg(msg);
        resultBody.setData(null);
        return resultBody;
    }

    /**
     * 定义格式化方式
     * @return JSON格式化字符串
     */
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
