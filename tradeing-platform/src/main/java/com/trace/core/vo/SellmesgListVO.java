package com.trace.core.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("卖方挂牌销售单展示列表")//为了publicSellList 卖方挂牌公共区销售单展示缩略列表 左连接卖单和公司
public class SellmesgListVO {

    @ApiModelProperty(value = "卖方报价信息")
    private Integer id;

    @ApiModelProperty(value = "卖方firmid")
    private Integer firmId;

    @ApiModelProperty(value = "企业全名")
    private String firmname;

    @ApiModelProperty(value = "发站")
    private String sendarea;

    @ApiModelProperty(value = "煤种煤炭分类(0-烟煤,1-无烟煤,2-褐煤,3-贫瘦煤,4-其他)")
    private Integer coaltype1;

    @ApiModelProperty(value = "煤种商业分类(0-原煤,1-混煤,2-中煤,3-煤泥,4-其他)")
    private Integer coaltype2;

    @ApiModelProperty(value = "卖方报价数量(万吨)")
    private BigDecimal num;

    @ApiModelProperty(value = "热值KCal/kg")
    private BigDecimal kcal;

    @ApiModelProperty(value = "煤单价元/吨")
    private BigDecimal price;

    @ApiModelProperty(value = "全硫%")
    private BigDecimal sulfur;

    @ApiModelProperty(value = "产地")
    private String prodarea;

    @ApiModelProperty(value = "运费单价元/吨")
    private BigDecimal freight;

    @ApiModelProperty(value = "1挥发分%")
    private BigDecimal vol1;

    @ApiModelProperty(value = "2挥发分%")
    private BigDecimal vol2;

    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal ash;

    @ApiModelProperty(value = "全水分")
    private BigDecimal water;

    @ApiModelProperty(value = "保证金(全认为要保金,  字段是金额/￥元")
    private BigDecimal offerbond;

    @ApiModelProperty(value = "现货单状态（0-保存未提交，1-未审核，2-驳回重填，3-通过发布，4-下架待签合同，5-合同确认，6-出售结束")
    private Integer status;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "营业执照")
    private String licenseNo;

    @ApiModelProperty(value = "传真")
    private String fax;

    @ApiModelProperty(value = "邮政编码")
    private String postal;

    @ApiModelProperty(value = "注册资金")
    private BigDecimal registerFund;

}
