package com.trace.core.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Another
 * @date 2022/9/26 17:31
 */

@Data
@ApiModel("买方需求采购信息审核")
public class BuyMesgVO {

    @ApiModelProperty(value = "买方需求采购信息    需求书6.3买方挂牌")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "申请单位id")
    private Integer firmId;

    @ApiModelProperty(value = "申请单位")
    private String buyfirmName;

    @ApiModelProperty(value = "单据编号")
    private String documentNo;

    @ApiModelProperty(value = "申请人")
    private String applicant;

    @ApiModelProperty(value = "签发人")
    private String issuer;

    @ApiModelProperty(value = "申请日期")
    private LocalDateTime applicationDate;

    @ApiModelProperty(value = "采购单状态（0-保存未提交，1-未审核，2-驳回重填，3-通过发布，4-下架待签合同，5-合同确认，6-采购结束")
    private Integer status;


}
