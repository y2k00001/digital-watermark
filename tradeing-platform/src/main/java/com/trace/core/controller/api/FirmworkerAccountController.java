package com.trace.core.controller.api;


import com.trace.core.entity.FirmworkerAccount;
import com.trace.core.mapper.FirmworkerAccountMapper;
import com.trace.core.service.FirmworkerAccountService;
import com.trace.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * <p>
 * 用户账户 前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Slf4j
@Api(tags="企业资金账户A")
@RestController
@RequestMapping("/api/firmworkerAccount")
public class FirmworkerAccountController {
    @Resource
    private FirmworkerAccountMapper firmworkerAccountMapper;

    @Resource
    private FirmworkerAccountService firmworkerAccountService;

    @ApiOperation(value = "根据fwId获取财务账户资金信息")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("企业用户id") @PathVariable("id")  Integer id){

        FirmworkerAccount firmworkerAccountShow=firmworkerAccountMapper.selectAccountByFirmworkerId(id);
        return R.ok().put("page",firmworkerAccountShow);
    }

    @ApiOperation("企业账户充值&必须上传汇款凭证需figure和fwId加")
    @PostMapping("/updateAmount")
    public R updateAmountById(@RequestBody FirmworkerAccount firmworkerAccount) {
        //使用自定义Mapper  只要拿着fwid对amount修改 ,,需要定义 VO, 基于FirmworkerAccount增加figure是变动金额
        firmworkerAccountService.saveFirmworkerAccount(firmworkerAccount);
        return R.ok("操作成功");
    }

    @ApiOperation("企业账户缴纳保证金需figure和fwId")
    @PostMapping("/updateFreezeAndAmount")
    public R updateFreezeAndAmountById(@RequestBody FirmworkerAccount firmworkerAccount) {
        //判断账户现余额是否足额以扣除保证金 Bigdecimal之间比较.compareTo()方法
        FirmworkerAccount firmworkerAccountNow=firmworkerAccountMapper.selectAccountById(firmworkerAccount);
        if(firmworkerAccountNow.getAmount().compareTo(firmworkerAccount.getFigure())==-1)
        {
            return R.error(-1, "余额不足,请充值,缴纳保证金失败");
        }

        //使用自定义Mapper  只要拿着fwid对amount 和 freezeAmount修改
        if (firmworkerAccountMapper.updateFreezeAndAmountById(firmworkerAccount) > 0) {
            return R.ok();
        } else {
            return R.error(-1, "缴纳保证金失败");
        }
    }

}

