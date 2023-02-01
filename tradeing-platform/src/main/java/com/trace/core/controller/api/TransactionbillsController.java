    package com.trace.core.controller.api;


    import com.trace.core.entity.FirmworkerAccount;
    import com.trace.core.entity.Transactionbills;
    import com.trace.core.exception.Assert;
    import com.trace.core.mapper.*;
    import com.trace.core.service.TransactionbillsService;
    import com.trace.core.utils.PageUtils;
    import com.trace.core.utils.R;
    import com.trace.core.utils.ResponseEnum;
    import com.trace.core.vo.BondTotalMidVO;
    import com.trace.core.vo.TransactionbillsListVO;
    import io.swagger.annotations.Api;
    import io.swagger.annotations.ApiOperation;
    import io.swagger.annotations.ApiParam;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.transaction.annotation.Transactional;
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
    @Slf4j
    @Api(tags="企业合同订单A")
    @RestController
    @RequestMapping("/api/transactionbills")
    public class TransactionbillsController {
        @Resource
        private TransactionbillsService transactionbillsService;
        @Resource
        private TransactionbillsMapper transactionbillsMapper;
        @Resource
        private FirmworkerMapper firmworkerMapper;
        @Resource
        private FirmworkerAccountMapper  firmworkerAccountMapper;

        @Resource
        private BuymesgMapper buymesgMapper;
        @Resource
        private SellmesgMapper sellmesgMapper;

        @ApiOperation("上传合同-等待对方确认")
        @PostMapping("/uploadTransactionBills")
        public R insert(@RequestBody Transactionbills transactionbills){
            Integer buyid = transactionbills.getBuyid();
            Integer sellid = transactionbills.getSellid();
            String agreementpath = transactionbills.getAgreementpath();

            Assert.notEmpty(buyid, ResponseEnum.INFORMATION_NULL_ERROR);
            Assert.notEmpty(sellid, ResponseEnum.INFORMATION_NULL_ERROR);
            Assert.notEmpty(agreementpath, ResponseEnum.INFORMATION_NULL_ERROR);

            Integer result =transactionbillsService.uploadTransactionBills(transactionbills);
            if(result>0){
                return R.ok("操作成功");
            }else{
                return R.error(-1,"操作失败");
            }
        }

    //参数必须是int类型,,否则class java.lang.String  cannot be cast to class java.lang.Integer
    //{
    //    "page":1,
    //        "limit":10,
    //          "firmId":120190017
    //    }
    //测试参数用Int  "page":1,"limit": "firmId"
        @ApiOperation("查询有关本企业的所有合同订单列表: 测试参数用JSON \"firmId\":120190017")
        @PostMapping("/showTransactionbillsList")
        public R showTransactionbillsList(@ApiParam("分页参数") @RequestBody Map<String,Object> params){
            PageUtils page = transactionbillsService.showTransactionbillsList(params);
            return R.ok().put("page", page);
        }
    //参数必须是int类型,,否则class java.lang.String  cannot be cast to class java.lang.Integer
    //{
    //    "page":1,
    //        "limit":10,
    //        "status":4
    //}
        @ApiOperation(" 企业查询自己所有合同  可以选择状态 类似三个分页")
        @PostMapping("/list")
        public R listAll(@ApiParam("分页参数") @RequestBody Map<String,Object> params){
            PageUtils page = transactionbillsService.queryPage(params);
            return R.ok().put("page", page);
        }
    //
    @ApiOperation(value = "根据id获取合同订单信息")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("TransactionbillsId") @PathVariable("id") Integer id) {
            Transactionbills transactionbills=transactionbillsService.getTransactionbillsById(id);
            return R.ok().put("page", transactionbills);
    }

    //多表写入, 开启事务管理 , 失败时回滚操作
        @Transactional(rollbackFor = Exception.class)
        @ApiOperation("确认合同&合同生效&生成订单&解冻保证金")
        @PostMapping("/ConfirmContract")
        public R update(@ApiParam("参数tbid,sellid,buyid,sellmesgId,buymesgId") @RequestBody TransactionbillsListVO transactionbillsListVO){
        //查合同status==1)  已经确认不要再解冻 ,否则到负值
            Integer status=transactionbillsMapper.checkStatus(transactionbillsListVO);
            if(status==1){
                return R.ok("合同已确认, 无需重复");
            }
        //确认合同&合同生效&生成订单(status->1) //参数仅仅transactionbills 的 id
            Integer result=transactionbillsMapper.confirmContract(transactionbillsListVO);

        //解冻保证金

            //查两个公司的财务fw_id
            Integer id=transactionbillsListVO.getSellid();
            Integer fw_id1=firmworkerMapper.selectTreasurerFwIdByFirmId(id);
            id=transactionbillsListVO.getBuyid();
            Integer fw_id2=firmworkerMapper.selectTreasurerFwIdByFirmId(id);

            //由保证金总额解冻保证金
            FirmworkerAccount firmworkerAccount=new FirmworkerAccount();

            //查保证金总额
            if(transactionbillsListVO.getBuymesgId().equals(0)||transactionbillsListVO.getBuymesgId()==null){
                BondTotalMidVO bondTotalMidVO= sellmesgMapper.offerbondTotal(transactionbillsListVO.getSellmesgId());
                firmworkerAccount.setFigure(bondTotalMidVO.getNum().multiply(bondTotalMidVO.getOfferbond()));
            }
            else{
                BondTotalMidVO bondTotalMidVO= buymesgMapper.offerbondTotal(transactionbillsListVO.getBuymesgId());
                firmworkerAccount.setFigure(bondTotalMidVO.getNum().multiply(bondTotalMidVO.getOfferbond()));
           }

            firmworkerAccount.setFwId(fw_id1);
            //使用自定义Mapper  只要拿着fwid对amount 和 freezeAmount修改
            if (!(firmworkerAccountMapper.unfreezeFundsById(firmworkerAccount) > 0)) {
                return R.error(-1, "解冻保证金失败");
            }

            firmworkerAccount.setFwId(fw_id2);
            //使用自定义Mapper  只要拿着fwid对amount 和 freezeAmount修改
            if (!(firmworkerAccountMapper.unfreezeFundsById(firmworkerAccount) > 0)) {
                return R.error(-1, "解冻保证金失败");
            }

            return R.ok("合同确认成功");

        }

    //多表写入, 开启事务管理 , 失败时回滚操作
    @Transactional(rollbackFor = Exception.class)
        @ApiOperation("确认收货&闭终合同订单)  参数仅仅transactionbills 的 id")
        @PostMapping("/confirmReceiptCloseContract")
        public R updateClose(@RequestBody TransactionbillsListVO transactionbillsListVO) {
            //确认收货&闭终合同订单(status->2) //参数仅仅transactionbills 的 id
            Integer result = transactionbillsMapper.confirmReceiptCloseContract(transactionbillsListVO);
            if(result>0){
                return R.ok("确认收货&闭终合同订单  成功");
            }else{
                return R.error(-1,"操作失败");
            }
        }

    }

