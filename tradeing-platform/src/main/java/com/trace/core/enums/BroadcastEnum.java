package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 11:07
 */
@AllArgsConstructor
@Getter
public enum BroadcastEnum {

    UNAPPROVED(0,"未审核" ),
    APPROVED(1,"审核通过"),
    WITHDRAW(2,"撤回"),
    ;

    private Integer status;
    private String msg;


}
