package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 11:07
 */

@AllArgsConstructor
@Getter
public enum UserRoleEnum {


    IT_MANAGEMENT_PERSONNEL(0, "管理人员"),
    INFORMATION_RELEASE_PERSONNEL(1, "资讯发布人员"),
    ;

    private Integer status;
    private String msg;

    public static String getTransTypeName(int transType) {
        for (TransTypeEnum obj : TransTypeEnum.values()) {
            if (transType == obj.getTransType().intValue()) {
                return obj.getTransTypeName();
            }
        }
        return "";
    }

}
