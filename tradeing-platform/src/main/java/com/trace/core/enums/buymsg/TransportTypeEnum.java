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
public enum TransportTypeEnum {



    TRAIN(0,"火车" ),
    AUTOMOBILE(1,"汽车"),
    SHIPPING(2,"船运"),
    OTHER(3,"其他"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (TransportTypeEnum obj : TransportTypeEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
