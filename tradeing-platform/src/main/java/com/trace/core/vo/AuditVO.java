package com.trace.core.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author Another
 * @date 2022/9/26 9:26
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Audit对象", description = "")
public class AuditVO {


    @ApiModelProperty(value = "审核表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "审核意见")
    private String advice;

    @ApiModelProperty(value = "审核记录状态(1-通过，2-驳回)")
    private Integer status;

}
