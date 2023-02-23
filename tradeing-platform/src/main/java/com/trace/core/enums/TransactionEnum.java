package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 10:57
 */
@AllArgsConstructor
@Getter
public enum TransactionEnum {

    NO_TRANSFER_CONTRACT(0,"传合同待确认" ),
    CONTRACT_CONFIRMATION(1,"合同确认生效&生成订单"),
    CONFIRM_RECEIPT(2,"确认收货&闭终合同订单"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (TransactionEnum obj : TransactionEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
