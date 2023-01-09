package com.trace.core.controller.api;


import com.trace.core.entity.Buymesg;
import com.trace.core.entity.FirmworkerAccount;
import com.trace.core.entity.Sellmesg;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.FirmworkerAccountMapper;
import com.trace.core.service.SellmesgService;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.R;
import com.trace.core.utils.ResponseEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Slf4j
@Api(tags="卖方挂单管理A")
@RestController
@RequestMapping("/api/sellmesg")
public class SellmesgController {
    @Resource
    private SellmesgService sellmesgService;
    @Resource
    private FirmworkerAccountMapper firmworkerAccountMapper;
    @ApiOperation("卖方挂单保存不提交")
    @PostMapping("/registerSave")
    public R insert(@RequestBody Sellmesg sellmesg){
        Integer sellid=sellmesg.getFirmId();
        Assert.notEmpty(sellid, ResponseEnum.FIRMID_NULL_ERROR);
        if(sellmesgService.registerSave(sellmesg)>0){
            return  R.ok("操作成功");
        }else {return R.error(-1,"操作失败");
        }

    }

    @ApiOperation("卖方挂单修改交审核(根据sellmesg_id)")
    @PostMapping("/updateSubmit")
    public R updateSubmit(@RequestBody Sellmesg sellmesg) {
        Integer sellid = sellmesg.getFirmId();
        BigDecimal num = sellmesg.getNum();
        BigDecimal kcal = sellmesg.getKcal();
        BigDecimal price = sellmesg.getPrice();
        BigDecimal freight = sellmesg.getFreight();
        String prodarea = sellmesg.getProdarea();
        String sendarea = sellmesg.getSendarea();

        Assert.notEmpty(sellid, ResponseEnum.FIRMID_NULL_ERROR);
        Assert.notEmpty(num, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(kcal, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(price, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(freight, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(prodarea, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(sendarea, ResponseEnum.INFORMATION_NULL_ERROR);
        if (sellmesgService.updateSubmit(sellmesg) > 0) {
            return R.ok("操作成功");
        } else {
            return R.error(-1, "操作失败");
        }
    }


//    {
//        "page":1,
//            "limit":1
//    }
//测试参数用"page":1,"limit"
    @ApiOperation("卖方挂牌显示全市场销售单列表: 测试参数用JSON \"page\":1,\"limit\" ")
    @PostMapping("/publicSellList")
    public R publicSellList(@ApiParam("分页参数") @RequestBody Map<String,Object> params){
        PageUtils page = sellmesgService.publicSellList(params);
        return R.ok().put("page", page);
    }


//参数status必须是int类型,,否则class java.lang.String  cannot be cast to class java.lang.Integer
//        "page":1,
//            "limit":1
//        "status":4
//}
    @ApiOperation("企业查询自己所有销售单  可以选择状态 类似三个分页")
    @PostMapping("/list")
    public R listAll(@ApiParam("分页参数") @RequestBody Map<String,Object> params){
        PageUtils page = sellmesgService.queryPage2(params);
        return R.ok().put("page", page);
    }

    @ApiOperation(value = "根据id获取销售单信息Sellmesg")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("SellmesgId") @PathVariable("id") Integer id) {
        Sellmesg sellmesg=sellmesgService.getBuymesgById(id);
        return R.ok().put("page", sellmesg);
    }



// API /buyDelist")   {
//        "id": 3,
//            "buyid": 120190017,
//            "figure": 90,
//            "fwId": 10
//    }
//多表写入, 开启事务管理 , 失败时回滚操作
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("买方摘牌(根据sellmesg_id)需buyid参数 ")
    @PostMapping("/buyDelist")
    public R buyDelist(@RequestBody Sellmesg sellmesg) {
        //一个完整的摘牌动作: 缴纳保证金且摘牌
        //判断账户现余额是否足额以扣除保证金 Bigdecimal之间比较.compareTo()方法
        FirmworkerAccount firmworkerAccount=new FirmworkerAccount();
        firmworkerAccount.setFigure(sellmesg.getFigure());
        firmworkerAccount.setFwId(sellmesg.getFwId());
        FirmworkerAccount firmworkerAccountNow=firmworkerAccountMapper.selectAccountById(firmworkerAccount);
        if(firmworkerAccountNow.getAmount().compareTo(firmworkerAccount.getFigure())==-1)
        {
            return R.error(-1, "余额不足,请充值,缴纳保证金失败");
        }

        //缴纳保证金:  使用自定义Mapper  只要拿着fwId按figure对amount 和 freezeAmount修改
        if (firmworkerAccountMapper.updateFreezeAndAmountById(firmworkerAccount) > 0) {

            //摘牌:写buyId为买方的企业号 , 且写本sellmesg状态为4 下架待签合同
            Integer buyid = sellmesg.getBuyid();
            Assert.notEmpty(buyid, ResponseEnum.FIRMID_NULL_ERROR);
                if (sellmesgService.buyDelist(sellmesg) > 0) {
                return R.ok("缴纳保证金且摘牌 成功");
            } else {
                return R.error(-1, "摘牌失败,已退回保证金");
            }
        } else {
            return R.error(-1, "缴纳保证金失败");
        }
    }
}

