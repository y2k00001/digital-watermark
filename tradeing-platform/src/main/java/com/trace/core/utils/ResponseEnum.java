package com.trace.core.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ResponseEnum {

    SUCCESS(0, "成功"),
    ERROR(-1, "服务器内部错误"),

    //-1xx 服务器错误
    BAD_SQL_GRAMMAR_ERROR(-101, "sql语法错误"),
    SERVLET_ERROR(-102, "servlet请求异常"), //-2xx 参数校验
    UPLOAD_ERROR(-103, "文件上传错误"),
    EXPORT_DATA_ERROR(104, "数据导出失败"),


    //-2xx 参数校验
    USERNAME_NULL_ERROR(-201, "用户名不能为空"),
    PASSWORD_NULL_ERROR(-202, "密码不能为空"),
    TRUENAME_NULL_ERROR(-203, "姓名不能为空"),
    MOBILE_NULL_ERROR(-204, "手机号码不能为空"),
    USERNAME_EXIST_ERROR(-207,"用户名已经存在"),
    USER_NOT_EXIST_ERROR(-208,"用户不存在"),
    PASSWORD_NOT_RIGHT_ERROR(-209,"密码不正确"),
    LOGIN_AUTH_ERROR(-211,"用户未登录"),
    NOT_SYSTEM_ADMIN_ERROR(-212,"用户不是管理员"),
    MOBILE_FORMAT_ERROR(-213,"手机格式不对"),
    FIRMID_NULL_ERROR(-214, "企业号不能为空"),
    INFORMATION_NULL_ERROR(-215, "提交信息包含不允许的空值"),
    QUERY_INFORMATION_IS_NULL_ERROR(-216, "查询的信息 不存在"),
    SELLID_NULL_ERROR(-214, "卖方不能为空"),

    TITLE_NOT_NULL_ERROR(-501,"标题不能为空"),
    INFO_NOT_NULL_ERROR(-502,"内容不能为空"),
    USER_NOT_NULL_ERROR(-503,"资讯人员不能为空"),

    USER_BIND_IDCARD_EXIST_ERROR(-301, "身份证号码已绑定"),
    USER_NO_BIND_ERROR(302, "用户未绑定"),
    USER_NO_AMOUNT_ERROR(303, "用户信息未审核"),
    USER_AMOUNT_LESS_ERROR(304, "您的借款额度不足"),
    LEND_INVEST_ERROR(305, "当前状态无法投标"),
    LEND_FULL_SCALE_ERROR(306, "已满标，无法投标"),
    NOT_SUFFICIENT_FUNDS_ERROR(307, "余额不足，请充值"),

    PAY_UNIFIEDORDER_ERROR(401, "统一下单错误"),

    ALIYUN_SMS_LIMIT_CONTROL_ERROR(160038, "短信验证码发送过于频繁"),//业务限流
    ALIYUN_SMS_LIMIT2_CONTROL_ERROR(160040, "当天验证码请求已经达到上限"),//业务限流
    ALIYUN_SMS_ERROR(160050, "短信发送失败"),//其他失败

    WEIXIN_CALLBACK_PARAM_ERROR(-601, "回调参数不正确"),
    WEIXIN_FETCH_ACCESSTOKEN_ERROR(-602, "获取access_token失败"),
    WEIXIN_FETCH_USERINFO_ERROR(-603, "获取用户信息失败"),
    ;
    private Integer code;//状态码
    private String message;//消息
}
