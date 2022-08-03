package com.nvclouds.medusaskadicommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GlobalEnums {
    //系统异常模块
    SYSTEM_PARAMS_ERRO(1000,"参数校验异常消息","参数校验异常消息"),
    SYSTEM_DATA_NOT_EXIST(10001,"当前数据不存在","当前数据不存在"),
    REQUEST_INVALID_PARAM(4001, "invalid param", "无效参数"),
    NOT_LOGGED_IN(4011, "not logged in", "未登录"),
    PASSWORD_INCORRECT(4012, "password incorrect", "密码错误"),
    AUTH_EXCEPTION(4031, "auth exception", "权限错误"),
    NOT_FOUNT(4041, "not found", "未找到"),
    DELETED(4101, "deleted", "已删除"),
    EXISTED(4221, "existed", "已存在"),
    INTERNAL_SERVER_ERROR(5001, "internal server error", "系统内部错误"),
    UNKNOWN_SERVER_ERROR(5002, "unknown server error", "系统未知错误"),
    NULL_POINTER_EXCEPTION(5003, "null pointer exception", "空指针异常");
    private final int code; //状态码
    private final String description; //描述
    private final String msg; //状态码消息

}
