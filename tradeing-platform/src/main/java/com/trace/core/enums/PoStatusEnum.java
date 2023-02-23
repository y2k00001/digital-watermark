package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 11:07
 */
@AllArgsConstructor
@Getter
public enum PoStatusEnum {


    SAVE_NOT_SUBMITTED(0, "保存未提交"),
    UNAPPROVED(1, "未审核"),
    REJECT_REFILLING(2, "驳回重填"),
    PASS_PUBLISHING(3, "通过发布"),
    OFF_SHELF_CONTRACT(4, "下架待签合同"),
    CONTRACT_CONFIRMATION(5, "合同确认"),
    END_OF_PROCUREMENT(6, "采购结束"),
    ;

    private Integer status;
    private String msg;

    public static String getMsg(int transType) {
        for (PoStatusEnum obj : PoStatusEnum.values()) {
            if (transType == obj.getStatus().intValue()) {
                return obj.getMsg();
            }
        }
        return "";
    }

}
