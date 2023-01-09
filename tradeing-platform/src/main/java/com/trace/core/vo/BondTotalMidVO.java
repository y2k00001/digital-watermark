package com.trace.core.vo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("bondTotalMidVO为了offerbondTotal = num * offerbond")//为了offerbondTotal = num * offerbond 因为直接在Map.xml查返BigDecimal会导致 非静态方法
public class BondTotalMidVO {
    @ApiModelProperty(value = "买方采购数量(万吨)")
    private BigDecimal num;

    @ApiModelProperty(value = "报价保证金(全认为要保金,  字段是金额/￥元")
    private BigDecimal offerbond;
}
