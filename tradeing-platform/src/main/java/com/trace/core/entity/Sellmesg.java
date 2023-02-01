package com.trace.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

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
@ApiModel(value="Sellmesg对象", description="")
public class Sellmesg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖方报价信息")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "卖方firmid")
    private Integer firmId;

    @ApiModelProperty(value = "意向成交企业id")
    private Integer buyid;

    //@value = "figure变动金额")
    // 数据库里面没有对应列,但是需要使用 在Mapper:sql语句 , 加
    //@TableField(exist = false)使用表外数据
    @TableField(exist = false)
    private BigDecimal figure;

    // 数据库里面没有对应列,但是需要使用
    @TableField(exist = false)
    private Integer fwId;

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

    @ApiModelProperty(value = "发站")
    private String sendarea;

    @ApiModelProperty(value = "空干基灰分")
    private BigDecimal ash;

    @ApiModelProperty(value = "全水分")
    private BigDecimal water;

    @ApiModelProperty(value = "保证金(全认为要保金,  字段是金额/￥元")
    private BigDecimal offerbond;

    @ApiModelProperty(value = "现货单状态（0-保存未提交，1-未审核，2-驳回重填，3-通过发布，4-下架待签合同，5-合同确认，6-出售结束")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

    @TableField(exist = false)
    private String advice;

    @TableField(exist = false)
    private String firmname;

    @TableField(exist = false)
    private String represent;


}
