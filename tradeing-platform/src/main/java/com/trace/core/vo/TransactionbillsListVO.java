package com.trace.core.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("买方挂牌采购单展示列表")//为了publicBuyList 买方挂牌公共区销售单展示缩略列表 买单左连接公司
public class TransactionbillsListVO {

    @ApiModelProperty(value = "合同订单并表")
    private Integer id;

    @ApiModelProperty(value = "供货方")
    private String sellfirmname;

    @ApiModelProperty(value = "购买方")
    private String buyfirmname;

    @ApiModelProperty(value = "合同文件路径")
    private String agreementpath;

    @ApiModelProperty(value = "合同订单状态（0-传合同待确认，1-合同确认生效&生成订单，2-确认收货&闭终合同订单)")
    private Integer status;

    @ApiModelProperty(value = "现货信息/牌id")
    private Integer sellmesgId;

    @ApiModelProperty(value = "采购信息/牌id")
    private Integer buymesgId;

    @ApiModelProperty(value = "购买方")
    private Integer buyid;

    @ApiModelProperty(value = "供货方")
    private Integer sellid;


}
