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
public enum AcceptanceTypeEnum {


    FACTORY_ACCEPTANCE(0, "到厂验收"),
    FACTORY_ThIRD_ACCEPTANCE(1, "到厂第三方验收"),
    PORT_ACCEPTANCE(2, "港口第三方验收"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (AcceptanceTypeEnum obj : AcceptanceTypeEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
