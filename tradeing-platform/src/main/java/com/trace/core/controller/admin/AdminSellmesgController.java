package com.trace.core.controller.admin;


import com.trace.core.entity.Buymesg;
import com.trace.core.entity.Sellmesg;
import com.trace.core.service.BuymesgService;
import com.trace.core.service.SellmesgService;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.R;
import com.trace.core.vo.AuditVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@RestController
@Api(tags = "卖方报价信息审核表")
@RequestMapping("/admin/sellmesg")
public class AdminSellmesgController {
    @Resource
    private SellmesgService sellmesgService;

    @ApiOperation("卖方报价信息列表")
    @PostMapping("/list")
    public R listAll(@ApiParam("分页参数") @RequestBody Map<String, Object> params) {
        PageUtils page = sellmesgService.queryPage(params);
        return R.ok().put("page", page);
    }

    @ApiOperation("卖方报价信息详情")
    @GetMapping("/detail/{id}")
    public R getDetailById(@ApiParam("买方需求采购信息表id") @PathVariable Integer id) {
        Sellmesg sellmesg = sellmesgService.getDetailById(id);
        return R.ok().put("page", sellmesg);
    }

    @ApiOperation("卖方报价信息审核")
    @PostMapping("/approval")
    public R approval(@ApiParam("审核返回体") @RequestBody AuditVO auditVO) {
        sellmesgService.approval(auditVO);
        return R.ok();
    }
}

