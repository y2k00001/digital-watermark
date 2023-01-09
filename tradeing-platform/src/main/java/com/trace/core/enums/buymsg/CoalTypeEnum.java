package com.trace.core.enums.buymsg;

import com.trace.core.enums.TransTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 11:07
 */

@AllArgsConstructor
@Getter
public enum CoalTypeEnum {



    BITUMINOUS_COAL(0,"烟煤" ),
    APPROVED(1,"无烟煤"),
    LIGNITElignite(2,"褐煤"),
    WITHDRAW(3,"贫瘦煤"),
    OTHER(4,"其他"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (CoalTypeEnum obj : CoalTypeEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }
}
