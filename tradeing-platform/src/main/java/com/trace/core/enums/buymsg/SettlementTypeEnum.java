package com.trace.core.enums.buymsg;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 11:07
 */

@AllArgsConstructor
@Getter
public enum SettlementTypeEnum {



    ONE_VOTE_SETTLEMENT(0,"一票结算" ),
    TWO_VOTE_SETTLEMENT(1,"二票结算"),
    RAILWAY_TICKET(2,"铁路大票"),
    COAL_TAX_RECEIPT(3,"煤款税票"),
    OTHER(4,"其他"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (SettlementTypeEnum obj : SettlementTypeEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
