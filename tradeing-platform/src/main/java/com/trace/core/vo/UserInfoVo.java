package com.trace.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Another
 * @date 2022/9/20 9:46
 */

@Data
@ApiModel(description = "用户信息对象")
public class UserInfoVo {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真名")
    private String truename;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "角色(0-管理人员，1-资讯发布人员，）")
    private Integer type;

    @ApiModelProperty(value = "JWT访问令牌")
    private String token;


}
