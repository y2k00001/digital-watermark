package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransTypeEnum {

    RECHARGE(0,"充值"),
    DEPOSIT_PAYMENT(1,"缴纳保证金"),
    THAW(2,"解冻"),
    PLATFORM_COMMISSION(3,"平台抽佣"),
    WITHDRAW(4,"提现"),
    ;

    private Integer transType ;
    private String transTypeName;


    public static String getTransTypeName(int transType) {
        for (TransTypeEnum obj : TransTypeEnum.values()) {
            if (transType == obj.getTransType().intValue()) {
                return obj.getTransTypeName();
            }
        }
        return "";
    }

}
