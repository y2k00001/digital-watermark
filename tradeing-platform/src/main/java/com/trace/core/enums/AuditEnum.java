package com.trace.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Another
 * @date 2022/9/16 10:57
 */

@AllArgsConstructor
@Getter
public enum AuditEnum {

    UNAPPROVED(0,"未审核" ),
    ADOPT(1,"通过"),
    REJECT(2,"驳回"),
    ;

    private Integer status;
    private String msg;



}
