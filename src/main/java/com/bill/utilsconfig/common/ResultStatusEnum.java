package com.bill.utilsconfig.common;

import com.bill.utilsconfig.exception.iface.BaseExceptionInfoInterface;
import lombok.Getter;

/**
 * @author Bill
 */

@Getter
public enum ResultStatusEnum implements BaseExceptionInfoInterface {
    //数据操作状态\错误定义
    SUCCESS("200","操作成功"),
    Format_ERROR("400","（错误的请求方法）请求的数据格式不符合要求"),
    AUTHORIZED_ERROR("401","（未授权）当前请求未授权"),
    ACCESS_ERROR("403","（禁止）用户未认证，请求被禁止"),
    ASSET_ERROR("404","（未找到）未找到该资源"),
    METHOD_DISABLED_ERROR("405","（方法禁用) 禁用请求中指定的方法"),
    TIMEOUT_ERROR("408","（请求超时) 服务器等候请求时发生超时"),
    CONFLICT_ERROR("409","（冲突）服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息"),
    INTERNAL_SERVER_ERROR("500","服务器内部错误"),
    UNAVAILABLE_ERROR("503","服务器暂时无法处理请求");

    //状态码
    private final String code;
    //状态信息
    private final String msg;

    ResultStatusEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getResultCode() {
        return this.code;
    }

    @Override
    public String getResultMsg() {
        return this.msg;
    }
}
