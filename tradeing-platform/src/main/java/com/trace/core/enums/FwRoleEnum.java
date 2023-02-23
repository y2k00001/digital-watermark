package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 10:57
 */
@AllArgsConstructor
@Getter
public enum FwRoleEnum {

    LEGAL_PERSON(0,"法人" ),
    FINANCE(1,"财务"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (FwRoleEnum obj : FwRoleEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
