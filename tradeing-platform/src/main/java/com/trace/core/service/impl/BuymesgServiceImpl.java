package com.trace.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Audit;
import com.trace.core.entity.Buymesg;
import com.trace.core.entity.Verifyinfo;
import com.trace.core.enums.buymsg.*;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.AuditMapper;
import com.trace.core.mapper.BuymesgMapper;
import com.trace.core.mapper.VerifyinfoMapper;
import com.trace.core.service.BuymesgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.Query;
import com.trace.core.utils.ResponseEnum;
import com.trace.core.vo.AuditVO;
import com.trace.core.vo.BuymesgListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Service
public class BuymesgServiceImpl extends ServiceImpl<BuymesgMapper, Buymesg> implements BuymesgService {
    @Resource
    private BuymesgMapper buymesgMapper;
    @Resource
    private AuditMapper auditMapper;

    @Resource
    private VerifyinfoMapper verifyinfoMapper;
    @Override
    public Integer registerSave(Buymesg buymesg) {
        buymesg.setStatus(0);
        buymesg.setDeleted(false);
        return baseMapper.insert(buymesg);

    }

    @Override
    public Integer updateSubmit(Buymesg buymesg) {
        buymesg.setStatus(1);
        buymesg.setDeleted(false);
        return baseMapper.updateById(buymesg);
    }

    @Override
    public Integer sellDelist(Buymesg buymesg) {
        buymesg.setStatus(4);
        return buymesgMapper.sellDelistById(buymesg);
    }

    @Override
    public Buymesg getBuymesgById(Integer id) {
        Buymesg buymesg=buymesgMapper.selectById(id);
        Assert.notNull(buymesg, ResponseEnum.QUERY_INFORMATION_IS_NULL_ERROR);
        return buymesg;
    }

//gh版本备份    //[无需求不测暂放]企业查询自己所有销售单  可以选择状态 类似三个分页
    @Override
    public PageUtils queryPage2(Map<String, Object> params) {
        //获取状态
        Integer status = (Integer) params.get("status");
        Integer firmId = (Integer) params.get("firmId");
        IPage<Buymesg> pages = baseMapper.getBuymesgPages(new Query<Buymesg>().getPage(params), status,firmId);
        return new PageUtils(pages);
    }
    //gh版本备份    //[无需求不测暂放]企业查询自己所有销售单  可以选择状态 类似三个分页
    @Override
    public PageUtils queryPage4(Map<String, Object> params) {
        //获取状态
        Integer status = (Integer) params.get("status");
        Integer firmId = (Integer) params.get("firmId");
        IPage<Buymesg> pages = baseMapper.getBuymesgPages4(new Query<Buymesg>().getPage(params), status,firmId);
        return new PageUtils(pages);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Integer status = (Integer)params.get("status");
        QueryWrapper<Buymesg> wrapper = new QueryWrapper<>();

        wrapper.ge(status != null&&status>=3, "status", status);
        wrapper.eq(status != null&&status<3, "status", status);
        IPage<Buymesg> page = this.page(new Query<Buymesg>().getPage(params), wrapper);
        return new PageUtils(page);
    }


    @Override
    public PageUtils publicBuyList(Map<String, Object> params) {
//        IPage<BuymesgListVO> pages = buymesgMapper.publicBuyList(new Query<BuymesgListVO>().getPage(params));
        IPage<Buymesg> pages = buymesgMapper.publicBuyList(new Query<Buymesg>().getPage(params));
        return new PageUtils(pages);
    }

    @Override
    public Buymesg getDetailById(Integer id) {
        //封装buyMesg信息，把类型转换为字符串再输出到前端
        Buymesg buymesg = baseMapper.selectById(id);
        Audit audit = auditMapper.selectOne(new QueryWrapper<Audit>().eq("firm_id", buymesg.getFirmId()).eq("buy_id", buymesg.getId()));
        if(audit!=null){
            buymesg.setAdvice(audit.getAdvice());
        }
        buymesg.setCoalType3(CoalTypeEnum.getMsg(buymesg.getCoaltype1()));
        buymesg.setCoalType4(CommercialTypeEnum.getMsg(buymesg.getCoaltype2()));
        buymesg.setShipType1(TransportTypeEnum.getMsg(buymesg.getShiptype()));
        buymesg.setTransactionMode1(SettlementTypeEnum.getMsg(buymesg.getTransactionmode()));
        buymesg.setAcceptanceMode1(AcceptanceTypeEnum.getMsg(buymesg.getAcceptancemode()));
        buymesg.setPaymentMode1(PaymentTypeEnum.getMsg(buymesg.getPaymentmode()));
        return buymesg;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void approval(AuditVO auditVO) {
        //修改buy表的状态
        Buymesg buymesg = baseMapper.selectById(auditVO.getId());
        buymesg.setStatus(auditVO.getStatus());
        baseMapper.updateById(buymesg);
        //增加audit表的状态和审核意见
        Audit audit = new Audit();
        audit.setFirmId(buymesg.getFirmId());
        audit.setBuyId(buymesg.getId());
        audit.setStatus(auditVO.getStatus());
        audit.setAdvice(auditVO.getAdvice());
        auditMapper.insert(audit);

        //审核后通知企业
        Verifyinfo verifyinfo = new Verifyinfo();
        verifyinfo.setFirmId(buymesg.getFirmId());
        verifyinfo.setInfo("买方需求采购信息审核结果："+auditVO.getAdvice());
        verifyinfoMapper.insert(verifyinfo);

    }




}
