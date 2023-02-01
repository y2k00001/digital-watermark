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
@ApiModel(value="Firm对象", description="")
public class Firm implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业id  需求书6.13")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "企业全名")
    private String firmname;

    @ApiModelProperty(value = "企业类型(0-供应商，1-贸易商，2-采购商)")
    private Integer firmtype;

    @ApiModelProperty(value = "法人代表姓名")
    private String represent;

    @ApiModelProperty(value = "法人代表身份证")
    private String representIdcard;

    @ApiModelProperty(value = "注册地")
    private String area;

    @ApiModelProperty(value = "企业邮箱")
    private String email;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "传真")
    private String fax;

    @ApiModelProperty(value = "邮政编码")
    private String postal;

    @ApiModelProperty(value = "注册资金")
    private BigDecimal registerFund;

    @ApiModelProperty(value = "营业执照")
    private String licenseNo;

    @ApiModelProperty(value = "组织代码")
    private String orgNo;

    @ApiModelProperty(value = "经营许可证号")
    private String certificateNo;

    @ApiModelProperty(value = "税务登记证号")
    private String taxNo;

    @ApiModelProperty(value = "开户行")
    private String bankname;

    @ApiModelProperty(value = "开户行账号")
    private String bankNo;

    @ApiModelProperty(value = "煤源信息")
    private String coalmesg;

    @ApiModelProperty(value = "运输方式和保障能力")
    private String transportmesg;

    @ApiModelProperty(value = "企业介绍")
    private String firminfo;

    @ApiModelProperty(value = "财务真名")
    private String treasurername;

    @ApiModelProperty(value = "财务电话唯一识别财务")
    private String treasurertelephone;

    @ApiModelProperty(value = "财务邮箱")
    private String treasureremail;

    @ApiModelProperty(value = "审核状态(0-未审核，1-通过，2-未通过)")
    private Integer status;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
