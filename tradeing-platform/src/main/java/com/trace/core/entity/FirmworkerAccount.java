package com.trace.core.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户账户
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="FirmworkerAccount对象", description="用户账户")
public class FirmworkerAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资金账号信息--编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "企业财务员工id")
    private Integer fwId;

    //@value = "figure变动金额")
    // 数据库里面没有对应列,但是需要使用在Mapper:sql语句 , 加
    //@TableField(exist = false)使用表外数据
    @TableField(exist = false)
    private BigDecimal figure;

    //@必须上传汇款凭证否则充值回滚(value = "企业汇款凭证")
    @TableField(exist = false)
    private List<TransFlow> transFlowList;

    @ApiModelProperty(value = "帐户可用余额")
    private BigDecimal amount;

    @ApiModelProperty(value = "冻结金额")
    private BigDecimal freezeAmount;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
