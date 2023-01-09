package com.trace.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Audit;
import com.trace.core.entity.Buymesg;
import com.trace.core.entity.Sellmesg;
import com.trace.core.entity.Verifyinfo;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.AuditMapper;
import com.trace.core.mapper.SellmesgMapper;
import com.trace.core.mapper.VerifyinfoMapper;
import com.trace.core.service.SellmesgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.Query;
import com.trace.core.utils.ResponseEnum;
import com.trace.core.vo.AuditVO;
import com.trace.core.vo.SellmesgListVO;
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
public class SellmesgServiceImpl extends ServiceImpl<SellmesgMapper, Sellmesg> implements SellmesgService {
    @Resource
    private SellmesgMapper sellmesgMapper;

    @Resource
    private AuditMapper auditMapper;
    @Resource
    private VerifyinfoMapper verifyinfoMapper;

    @Override
    public   Integer registerSave(Sellmesg sellmesg){
        sellmesg.setStatus(0);
        sellmesg.setDeleted(false);
        return baseMapper.insert(sellmesg);
    }

    @Override
    public Integer updateSubmit(Sellmesg sellmesg) {
        sellmesg.setStatus(1);
        sellmesg.setDeleted(false);
        return baseMapper.updateById(sellmesg);
    }

    @Override
    public Integer buyDelist(Sellmesg sellmesg) {
        sellmesg.setStatus(4);
        sellmesg.setDeleted(false);
        return sellmesgMapper.buyDelistById(sellmesg);
    }

//gh版本备份// ]企业查询自己所有销售单  可以选择状态 类似三个分页
    @Override
    public PageUtils queryPage2(Map<String, Object> params) {
        //获取状态
        Integer status = (Integer) params.get("status");
        IPage<Sellmesg> pages = baseMapper.getSellmesgPages(new Query<Sellmesg>().getPage(params), status);
        return new PageUtils(pages);
    }
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取状态
        Integer status = (Integer) params.get("status");
        //联表查询信息分页
        IPage<Sellmesg> pages = baseMapper.getAuditVoPages(new Query<Sellmesg>().getPage(params), status);
        return new PageUtils(pages);
    }
    @Override
    public PageUtils publicSellList(Map<String, Object> params) {
        IPage<SellmesgListVO> pages = sellmesgMapper.publicSellList(new Query<SellmesgListVO>().getPage(params));
        return new PageUtils(pages);
    }

    @Override
    public Sellmesg getBuymesgById(Integer id) {
        Sellmesg sellmesg=sellmesgMapper.selectById(id);
        Assert.notNull(sellmesg, ResponseEnum.QUERY_INFORMATION_IS_NULL_ERROR);
        return sellmesg;
    }

    @Override
    public Sellmesg getDetailById(Integer id) {
        //封装buyMesg信息，把类型转换为字符串再输出到前端
        Sellmesg sellmesg = baseMapper.selectById(id);
        Audit audit = auditMapper.selectOne(new QueryWrapper<Audit>().eq("firm_id", sellmesg.getFirmId()).eq("sell_id", sellmesg.getId()));
        if(audit!=null){
            sellmesg.setAdvice(audit.getAdvice());
        }
        return sellmesg;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void approval(AuditVO auditVO) {
        //修改sell表的状态
        Sellmesg sellmesg = baseMapper.selectById(auditVO.getId());
        sellmesg.setStatus(auditVO.getStatus());
        baseMapper.updateById(sellmesg);
        //增加audit表的状态和审核意见
        Audit audit = new Audit();
        audit.setFirmId(sellmesg.getFirmId());
        audit.setSellId(sellmesg.getId());
        audit.setStatus(auditVO.getStatus());
        audit.setAdvice(auditVO.getAdvice());
        auditMapper.insert(audit);

        //审核后通知企业
        Verifyinfo verifyinfo = new Verifyinfo();
        verifyinfo.setFirmId(sellmesg.getFirmId());
        verifyinfo.setInfo("卖方报价信息审核结果："+auditVO.getAdvice());
        verifyinfoMapper.insert(verifyinfo);

    }

}