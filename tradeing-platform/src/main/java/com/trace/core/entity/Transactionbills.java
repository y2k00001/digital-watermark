package com.trace.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value="Transactionbills对象", description="")
@Accessors(chain = true)
public class Transactionbills implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "合同订单并表")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "购买方")
    private Integer buyid;

    @ApiModelProperty(value = "供货方")
    private Integer sellid;

    @ApiModelProperty(value = "合同文件路径")
    private String agreementpath;

    @ApiModelProperty(value = "现货信息/牌id")
    private Integer sellmesgId;

    @ApiModelProperty(value = "采购信息/牌id")
    private Integer buymesgId;

    @ApiModelProperty(value = "合同订单状态（0-传合同待确认，1-合同确认生效&生成订单，2-确认收货&闭终合同订单)")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
