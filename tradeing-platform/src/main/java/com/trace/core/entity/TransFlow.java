package com.trace.core.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 交易流水表
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TransFlow对象", description="交易流水表")
public class TransFlow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "交易流水 编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "企业用户fw_id")
    private Integer fwId;

    @ApiModelProperty(value = "用户名称")
    private String fwName;

    @ApiModelProperty(value = "交易单号")
    private String transNo;

    @ApiModelProperty(value = "交易类型(0-预存充值，1-缴纳保金，2-解冻，3-平台抽佣)")
    private Integer transType;

    @ApiModelProperty(value = "交易类型名称")
    private String transTypeName;

    @ApiModelProperty(value = "交易金额")
    private BigDecimal transAmount;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "交易凭证图片路径")
    private String url;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
