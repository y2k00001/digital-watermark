package com.trace.core.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wgh
 *
 */

@Data
@ApiModel(description = "用户信息对象")
public class FirmworkerInfoVo {

    @ApiModelProperty(value = "企业员工id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "企业id")
    private Integer firmId;

    @ApiModelProperty(value = "真名")
    private String truename;

    @ApiModelProperty(value = "电话(电话唯一识别财务)")
    private String telephone;

    @ApiModelProperty(value = "邮箱")
    private   String email;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "企业类型(0-供应商，1-贸易商，2-采购商)")
    private Integer firmtype;


    @ApiModelProperty(value = "角色(0-法人，1-财务）")
    private Integer type;

    @ApiModelProperty(value = "JWT访问令牌")
    private String token;



}
