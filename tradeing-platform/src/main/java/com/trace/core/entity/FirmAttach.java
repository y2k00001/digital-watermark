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
 * @Author Another
 * @date 2022/9/23 9:05
 */

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="FirmAttach对象", description="企业附件资料表")
@Accessors(chain = true)
public class FirmAttach implements Serializable {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "企业id")
    private Integer firmId;

    @ApiModelProperty(value = "图片类型（营业执照licenseCard,税务登记taxCard,组织代码orgCard，开户账号证bankCard，煤炭许可证coalCard，身份证idCard）")
    private String imageType;

    @ApiModelProperty(value = "资源路径")
    private String imageUrl;

    @ApiModelProperty(value = "图片名称")
    private String imageName;

    @ApiModelProperty(value = "生成时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;

}
