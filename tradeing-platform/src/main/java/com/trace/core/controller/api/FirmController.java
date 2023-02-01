package com.trace.core.controller.api;


import com.trace.core.entity.Firm;
import com.trace.core.service.FirmService;
import com.trace.core.utils.R;
import com.trace.core.vo.FirmInfoSaveVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Slf4j
@Api(tags="企业信息管理A")
@RestController
@RequestMapping("/api/firm")
public class FirmController {
    @Resource
    private FirmService firmService;

    @ApiOperation("企业信息创建!status=0")
    @PostMapping("/register")
    public R insert(@RequestBody FirmInfoSaveVO firmInfoSaveVO, HttpServletRequest request) {

        //是否要验证token?
        firmInfoSaveVO.setStatus(0);//审核状态(0-未审核
        boolean result =firmService.saveFirmInfoSaveVO(firmInfoSaveVO);
        return R.ok("操作成功");
    }


    @ApiOperation(value = "根据fmId获取企业认证信息")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("企业id") @PathVariable("id")  Integer id){
        Firm firm = firmService.getById(id);
        return R.ok().put("page",firm);
    }

    @ApiOperation("更新企业信息!status=0")
    @PostMapping("/update")
    public R updateById(@RequestBody Firm firm){
        firm.setStatus(0);//审核状态(0-未审核
        boolean result =firmService.updateById(firm);
        if(result){
            return R.ok("更新成功");
        }else{
            return R.error(-1,"更新失败");
        }
    }


}

