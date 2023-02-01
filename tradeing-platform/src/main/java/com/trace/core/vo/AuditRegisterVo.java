package com.trace.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Another
 * @date 2022/9/22 9:07
 */

@Data
@ApiModel("企业用户注册审核表")
public class AuditRegisterVo {

    @ApiModelProperty("审核表id")
    private Integer id;

    @ApiModelProperty("企业组织代码")
    private String orgNo;

    @ApiModelProperty("企业名称")
    private String firmname;

    @ApiModelProperty("企业法人")
    private String represent;

    @ApiModelProperty("联系方式")
    private String telephone;

    @ApiModelProperty("营业执照")
    private String licenseNo;

    @ApiModelProperty("税务登记证")
    private String taxNo;

    @ApiModelProperty(value = "审核状态(0-未审核，1-通过，2-未通过)")
    private Integer status;


}
