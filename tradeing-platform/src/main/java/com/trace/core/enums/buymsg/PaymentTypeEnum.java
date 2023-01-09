package com.trace.core.enums.buymsg;

import com.trace.core.enums.TransTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 11:42
 */

@AllArgsConstructor
@Getter
public enum PaymentTypeEnum {

    CASH_EXCHANGE(0, "现汇或承兑汇票"),
    PROMISSORY_NOTE(1, "本票"),
    CHECK(2, "支票"),
    CREDIT_CARD(3, "信用卡"),
    OTHER(4, "其他"),
    ;
    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (PaymentTypeEnum obj : PaymentTypeEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
