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
import java.time.LocalDateTime;

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
@ApiModel(value="Broadcast对象", description="")
@Accessors(chain = true)
public class Broadcast implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "平台公开资讯id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    private LocalDateTime date;

    @ApiModelProperty(value = "资讯人员id")
    private Integer userId;

    private String title;

    private String info;

    @ApiModelProperty(value = "资讯状态（0-未审核，1-审核通过可发布，2-撤回）")
    private Integer status;

    @ApiModelProperty(value = "审核意见")
    private String advice;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

    @TableField(exist = false)
    private String truename;


}
