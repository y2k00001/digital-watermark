package com.trace.core.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Another
 * @date 2022/9/21 16:03
 */

@Data
public class UserVo {


    @ApiModelProperty(value = "平台人员账号  需求书6.11用户创建实际是创建平台人")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "真名")
    private String truename;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "角色(0-管理人员，1-资讯发布人员，）")
    private Integer type;

}
