package com.trace.core.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Buymesg对象", description="")
public class Buymesg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "买方需求采购信息    需求书6.3买方挂牌")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "申请单位id")
    private Integer firmId;

    @ApiModelProperty(value = "意向供货企业id  卖方id")
    private Integer sellid;


    //@value = "figure变动金额")
    // 数据库里面没有对应列,但是需要使用 在Mapper:sql语句 , 加
    //@TableField(exist = false)使用表外数据
    @TableField(exist = false)
    private BigDecimal figure;

    // 数据库里面没有对应列,但是需要使用
    @TableField(exist = false)
    private Integer fwId;

    @ApiModelProperty(value = "申请单位")
    private String buyfirmName;

    @ApiModelProperty(value = "单据编号")
    private String documentNo;

    @ApiModelProperty(value = "申请人")
    private String applicant;

    @ApiModelProperty(value = "签发人")
    private String issuer;

    @ApiModelProperty(value = "申请日期")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applicationDate;

    @ApiModelProperty(value = "交货时间前")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliverytime1;

    @ApiModelProperty(value = "交货时间后")
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliverytime2;

    @ApiModelProperty(value = "煤种煤炭分类(0-烟煤,1-无烟煤,2-褐煤,3-贫瘦煤,4-其他)")
    private Integer coaltype1;

    @ApiModelProperty(value = "煤种商业分类(0-原煤,1-混煤,2-中煤,3-煤泥,4-其他)")
    private Integer coaltype2;

    @ApiModelProperty(value = "买方采购数量(万吨)")
    private BigDecimal num;

    @ApiModelProperty(value = "运费单价元/吨")
    private BigDecimal freight;

    @ApiModelProperty(value = "煤单价元/吨")
    private BigDecimal price;

    @ApiModelProperty(value = "运输方式(0-火车,1-汽车,2-船运,3-其他)")
    private Integer shiptype;

    @ApiModelProperty(value = "交货地点")
    private String deliveryplace;

    @ApiModelProperty(value = "结算方式(0-一票结算,1-二票结算,2-铁路大票,3-煤款税票,4-其他)")
    private Integer transactionmode;

    @ApiModelProperty(value = "验收方式(0-到厂验收,1-到厂第三方验收,2-港口第三方验收)")
    private Integer acceptancemode;

    @ApiModelProperty(value = "结算付款方式(0-现汇或承兑汇票,1-本票,2-支票,3-信用卡)")
    private Integer paymentmode;

    @ApiModelProperty(value = "报价保证金(全认为要保金,  字段是金额/￥元")
    private BigDecimal offerbond;

    @ApiModelProperty(value = "履约保证金   本版本不使用")
    private Boolean performbond;

    @ApiModelProperty(value = "收到基低位热值KCal/kg ,,发热量Qnet")
    private BigDecimal kcal;

    @ApiModelProperty(value = "全硫%  ,St,ar")
    private BigDecimal sulfur;

    @ApiModelProperty(value = "全水分M")
    private BigDecimal water;

    @ApiModelProperty(value = "基灰分")
    private BigDecimal ash;

    @ApiModelProperty(value = "收到基挥发分%")
    private BigDecimal vol1;

    @ApiModelProperty(value = "收到基挥发分%")
    private BigDecimal vol2;

    @ApiModelProperty(value = "空干水分M")
    private BigDecimal kwater;

    @ApiModelProperty(value = "空干全硫%  ,St,ar")
    private BigDecimal ksulfur;

    @ApiModelProperty(value = "空干1挥发分%")
    private BigDecimal kvol1;

    @ApiModelProperty(value = "空干2挥发分%")
    private BigDecimal kvol2;

    @ApiModelProperty(value = "干基高位热值KCal/kg ,,发热量Qnet")
    private BigDecimal gkcal;

    @ApiModelProperty(value = "干基全硫%  ,St,ar")
    private BigDecimal gsulfur;

    @ApiModelProperty(value = "干基1挥发分%")
    private BigDecimal gvol1;

    @ApiModelProperty(value = "干基2挥发分%")
    private BigDecimal gvol2;

    @ApiModelProperty(value = "粒度mm")
    private String granularity;

    @ApiModelProperty(value = "灰熔点")
    private String melting;

    @ApiModelProperty(value = "哈式可磨系数")
    @TableField("HGI")
    private String hgi;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "逻辑删除(1-已删除，0-未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

    @ApiModelProperty(value = "采购单状态（0-保存未提交，1-未审核，2-驳回重填，3-通过发布，4-下架待签合同，5-合同确认，6-采购结束")
    private Integer status;

    @TableField(exist = false)
    private String coalType3;

    @TableField(exist = false)
    private String coalType4;

    @TableField(exist = false)
    private String shipType1;

    @ApiModelProperty(value = "结算方式(0-一票结算,1-二票结算,2-铁路大票,3-煤款税票,4-其他)")
    @TableField(exist = false)
    private String transactionMode1;

    @ApiModelProperty(value = "验收方式(0-到厂验收,1-到厂第三方验收,2-港口第三方验收)")
    @TableField(exist = false)
    private String acceptanceMode1;

    @ApiModelProperty(value = "结算付款方式(0-现汇或承兑汇票,1-本票,2-支票,3-信用卡)")
    @TableField(exist = false)
    private String paymentMode1;


    @TableField(exist = false)
    private String advice;


}
