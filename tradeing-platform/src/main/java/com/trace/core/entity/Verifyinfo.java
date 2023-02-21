package com.trace.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Verifyinfo对象", description="")
@Accessors(chain = true)
public class Verifyinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "向个人审核资讯交易通知 报单通知等等指引不跳转")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "收信人id")
    private Integer firmId;

    @ApiModelProperty(value = "发送者名字")
    private String sender;

    private LocalDateTime date;

    @ApiModelProperty(value = "内容")
    private String info;

    @ApiModelProperty(value = "资讯状态")
    private Boolean status;


}
