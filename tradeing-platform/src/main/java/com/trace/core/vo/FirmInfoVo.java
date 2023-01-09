package com.trace.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Another
 * @date 2022/9/23 10:53
 */

@Data
@ApiModel("企业附件资料")
public class FirmInfoVo {

    @ApiModelProperty("企业名称")
    private String firmname;

    @ApiModelProperty("企业法人")
    private String represent;

    @ApiModelProperty(value = "注册地")
    private String area;

    @ApiModelProperty(value = "注册资金")
    private BigDecimal registerFund;

    @ApiModelProperty("联系方式")
    private String telephone;

    @ApiModelProperty(value = "传真")
    private String fax;

    @ApiModelProperty(value = "企业邮箱")
    private String email;

    @ApiModelProperty(value = "开户行")
    private String bankname;

    @ApiModelProperty(value = "煤源信息")
    private String coalmesg;

    @ApiModelProperty(value = "运输方式和保障能力")
    private String transportmesg;

    @ApiModelProperty(value = "企业介绍")
    private String firminfo;

    @ApiModelProperty(value = "审核状态(0-未审核，1-通过，2-未通过)")
    private Integer status;

    @ApiModelProperty(value = "审核意见")
    private String advice;

    @ApiModelProperty(value = "企业附件资料")
    private List<FirmAttachVO> firmAttachList;


}
