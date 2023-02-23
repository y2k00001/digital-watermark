package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 10:57
 */
@AllArgsConstructor
@Getter
public enum EnterpriseTypeEnum {

    SUPPLIER(0,"供应商" ),
    TRADERS(1,"贸易商"),
    PURCHASER(2,"采购商"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (EnterpriseTypeEnum obj : EnterpriseTypeEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
