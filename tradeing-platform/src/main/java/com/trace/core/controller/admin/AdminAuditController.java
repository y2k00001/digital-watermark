package com.trace.core.controller.admin;


import com.trace.core.vo.AuditVO;
import com.trace.core.service.AuditService;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.R;
import com.trace.core.vo.FirmInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Slf4j
@Api(tags = "企业注册审核管理")
@RestController
@RequestMapping("/admin/audit")
public class AdminAuditController {

    @Resource
    private AuditService auditService;

    @ApiOperation("企业注册审核列表")
    @PostMapping("/list")
    public R listAll(@ApiParam("分页参数") @RequestBody Map<String, Object> params) {
        PageUtils page = auditService.queryPage(params);
        return R.ok().put("page", page);
    }

    @ApiOperation("企业注册详情")
    @GetMapping("/detail/{id}")
    public R getDetailById(@ApiParam("审核表id") @PathVariable Integer id) {
        FirmInfoVo firmInfoVo = auditService.getDetailById(id);
        return R.ok().put("page", firmInfoVo);
    }

    @ApiOperation("企业注册审核")
    @PostMapping("/approval")
    public R approval(@ApiParam("审核返回体") @RequestBody AuditVO auditVO) {
        auditService.approval(auditVO);
        return R.ok();
    }

}

