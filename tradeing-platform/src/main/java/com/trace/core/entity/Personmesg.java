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
@ApiModel(value="Personmesg对象", description="")
@Accessors(chain = true)
public class Personmesg implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "私信表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "收信的企人或台人id ， 向个人审核资讯交易通知 报单通知等等")
    private Integer pepId;

    @ApiModelProperty(value = "发送者名字")
    private String sender;

    private LocalDateTime date;

    @ApiModelProperty(value = "内容")
    private String info;

    @ApiModelProperty(value = "资讯状态(0-未读，1-已读)")
    private Boolean status;


}
