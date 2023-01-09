package com.trace.core.controller.api;


import com.trace.core.entity.Buymesg;
import com.trace.core.entity.FirmworkerAccount;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.FirmworkerAccountMapper;
import com.trace.core.service.BuymesgService;
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
@Api(tags="买方挂单管理A")
@RestController
@RequestMapping("/api/buymesg")
public class BuymesgController {
    @Resource
    private BuymesgService buymesgService;
    @Resource
    private FirmworkerAccountMapper firmworkerAccountMapper;

    @ApiOperation("买方挂单保存不提交")
    @PostMapping("/registerSave")
    public R insert(@RequestBody Buymesg buymesg){
        Integer buyid=buymesg.getFirmId();
        Assert.notEmpty(buyid, ResponseEnum.FIRMID_NULL_ERROR);
        if(buymesgService.registerSave(buymesg)>0){
            return   R.ok("买方挂单采购单 保存不提交 成功");
        }else {return R.error(-1,"保存 失败");
        }
    }

    @ApiOperation("买方挂单修改交审核(根据buymesg_id)")
    @PostMapping("/updateSubmit")
    public R updateSubmit(@RequestBody  Buymesg buymesg) {
        Integer buyid = buymesg.getFirmId();
        Integer id = buymesg.getId();
        BigDecimal num = buymesg.getNum();
        BigDecimal kcal = buymesg.getKcal();
        BigDecimal price = buymesg.getPrice();
        BigDecimal freight = buymesg.getFreight();

        Assert.notEmpty(id, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(buyid, ResponseEnum.FIRMID_NULL_ERROR);
        Assert.notEmpty(num, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(kcal, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(price, ResponseEnum.INFORMATION_NULL_ERROR);
        Assert.notEmpty(freight, ResponseEnum.INFORMATION_NULL_ERROR);
        if (buymesgService.updateSubmit(buymesg) > 0) {
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
    @ApiOperation("买方挂牌显示全市场采购单列表: 测试参数用JSON \"page\":\"1\",\"limit\" ")
    @PostMapping("/publicBuyList")
    public R publicBuyList(@ApiParam("分页参数") @RequestBody Map<String,Object> params){
        PageUtils page = buymesgService.publicBuyList(params);
        return R.ok().put("page", page);
    }


//参数必须是int类型,,否则class java.lang.String  cannot be cast to class java.lang.Integer
//{
//    "page":1,
//        "limit":10,
//        "status":4
//}
    @ApiOperation("[无需求不测暂放]企业查询自己所有采购单  可以选择状态 类似三个分页")
    @PostMapping("/list")
    public R listAll(@ApiParam("分页参数") @RequestBody Map<String,Object> params){
        PageUtils page = buymesgService.queryPage2(params);
        return R.ok().put("page", page);
    }
    @ApiOperation("买企业查询自己所有采购单  可以选择状态 类似三个分页")
    @PostMapping("/list4")
    public R listAll4(@ApiParam("分页参数") @RequestBody Map<String,Object> params){
        PageUtils page = buymesgService.queryPage4(params);
        return R.ok().put("page", page);
    }


    @ApiOperation(value = "根据id获取采购单信息Buymesg")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("BuymesgId") @PathVariable("id") Integer id) {
        Buymesg buymesg=buymesgService.getBuymesgById(id);
        return R.ok().put("page", buymesg);
    }

//多表写入, 开启事务管理 , 失败时回滚操作
//    {
//        "id": 3,
//            "sellid": 120190017,
//            "figure": 90,
//            "fwId": 10
//    }
    @Transactional(rollbackFor = Exception.class)
    @ApiOperation("卖方摘牌(由buymesg_id)需sellid参数, 由fwId按figure")
    @PostMapping("/sellDelist")
    public R sellDelist(@RequestBody Buymesg buymesg) {
        //一个完整的摘牌动作: 缴纳保证金且摘牌
        //判断账户现余额是否足额以扣除保证金 Bigdecimal之间比较.compareTo()方法
        FirmworkerAccount firmworkerAccount=new FirmworkerAccount();
        firmworkerAccount.setFigure(buymesg.getFigure());
        firmworkerAccount.setFwId(buymesg.getFwId());
        FirmworkerAccount firmworkerAccountNow=firmworkerAccountMapper.selectAccountById(firmworkerAccount);
        if(firmworkerAccountNow.getAmount().compareTo(firmworkerAccount.getFigure())==-1)
        {
            return R.error(-1, "余额不足,请充值,缴纳保证金失败");
        }

        //缴纳保证金:  使用自定义Mapper  只要拿着fwId按figure对amount 和 freezeAmount修改
        if (firmworkerAccountMapper.updateFreezeAndAmountById(firmworkerAccount) > 0) {

            //摘牌:  写sellId为卖方的企业号 , 且写本buymesg状态为4 下架待签合同
            Integer sellid = buymesg.getSellid();
            Assert.notEmpty(sellid, ResponseEnum.FIRMID_NULL_ERROR);
            if (buymesgService.sellDelist(buymesg) > 0) {
                return R.ok("缴纳保证金且摘牌 成功");
            } else {
                return R.error(-1, "摘牌失败,已退回保证金");
            }

        } else {
            return R.error(-1, "缴纳保证金失败");
        }
    }
}

