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
public enum CommercialTypeEnum {



    RAW_COAL(0,"原煤" ),
    COAL_BLEND(1,"混煤"),
    MEDIUM_COAL(2,"中煤"),
    SLIME(3,"煤泥"),
    OTHER(4,"其他"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (CommercialTypeEnum obj : CommercialTypeEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
