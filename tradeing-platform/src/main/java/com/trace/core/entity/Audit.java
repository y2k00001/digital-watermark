package com.trace.core.entity;

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
 *
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Audit对象", description="")
public class Audit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审核表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "id 指向被审核的一切  买卖单/企业信息")
    private Integer firmId;

    @ApiModelProperty(value = "审核人名字")
    private String sender;

    @ApiModelProperty(value = "日期")
    private LocalDateTime date;

    @ApiModelProperty(value = "审核意见")
    private String advice;

    @ApiModelProperty(value = "审核记录状态(0-未审核，1-通过，2-驳回)")
    private Integer status;

    @ApiModelProperty(value = "买入信息表id")
    private Integer buyId;

    @ApiModelProperty(value = "卖出信息表id")
    private Integer sellId;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
