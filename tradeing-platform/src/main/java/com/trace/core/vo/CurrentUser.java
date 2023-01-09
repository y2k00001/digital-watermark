package com.trace.core.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Another
 * @date 2022/9/20 17:52
 */

@Data
public class CurrentUser {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "角色(0-管理人员，1-资讯发布人员，）")
    private Integer type;


}
