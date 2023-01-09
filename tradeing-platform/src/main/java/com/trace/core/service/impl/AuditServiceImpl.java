package com.trace.core.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.*;
import com.trace.core.enums.FwRoleEnum;
import com.trace.core.mapper.*;
import com.trace.core.service.AuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.service.FirmAttachService;
import com.trace.core.utils.MD5;
import com.trace.core.utils.MailConstant;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.Query;
import com.trace.core.vo.AuditRegisterVo;
import com.trace.core.vo.AuditVO;
import com.trace.core.vo.FirmAttachVO;
import com.trace.core.vo.FirmInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Slf4j
@Service
public class AuditServiceImpl extends ServiceImpl<AuditMapper, Audit> implements AuditService {

    @Resource
    private FirmMapper firmMapper;

    @Resource
    private FirmworkerMapper firmworkerMapper;

    @Resource
    private FirmAttachService firmAttachService;

    @Resource
    private FirmworkerAccountMapper firmworkerAccountMapper;

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private VerifyinfoMapper verifyinfoMapper;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取状态
        Integer status = (Integer) params.get("status");
        //联表查询信息分页
        IPage<AuditRegisterVo> pages = baseMapper.getAuditVoPages(new Query<AuditRegisterVo>().getPage(params), status);
        return new PageUtils(pages);
    }

    @Override
    public FirmInfoVo getDetailById(Integer id) {
        Firm firm = firmMapper.selectById(id);
        FirmInfoVo firmInfoVo = new FirmInfoVo();
        Audit audit = baseMapper.selectOne(new QueryWrapper<Audit>().eq("firm_id", id).eq("buy_id", 0).eq("sell_id", 0));
        //封装审核详情信息
        BeanUtils.copyProperties(firm, firmInfoVo);
        if (audit != null) {
            String advice = audit.getAdvice();
            firmInfoVo.setAdvice(advice);
        }
        //图片
        List<FirmAttachVO> firmAttachVOList = firmAttachService.selectFirmAttachVOList(id);
        firmInfoVo.setFirmAttachList(firmAttachVOList);

        return firmInfoVo;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void approval(AuditVO auditVO) {

        //修改企业表状态
        Firm firm = firmMapper.selectById(auditVO.getId());
        firm.setStatus(auditVO.getStatus());
        firmMapper.updateById(firm);

        //修改审核
        Audit audit = new Audit();
        audit.setFirmId(firm.getId());
        audit.setStatus(auditVO.getStatus());
        audit.setAdvice(auditVO.getAdvice());
        baseMapper.insert(audit);


        //生成财务表
        Firmworker firmworker = new Firmworker();
        firmworker.setFirmId(firm.getId());
        firmworker.setTruename(firm.getTreasurername());
        firmworker.setTelephone(firm.getTreasurertelephone());
        firmworker.setEmail(firm.getTreasureremail());
        //随机生成9位数密码(数字+字母)
        //发送通知财务密码
        String password = RandomUtil.randomString(9);
        sendMail(firm.getTreasureremail(), password);
        firmworker.setPassword(MD5.encrypt(password));

        firmworker.setType(FwRoleEnum.FINANCE.getStatus());
        firmworker.setFirmtype(firm.getFirmtype());
        firmworkerMapper.insert(firmworker);

        //生成财务账户表
        Firmworker firmworker1 = firmworkerMapper.selectOne(new QueryWrapper<Firmworker>().eq("telephone", firm.getTreasurertelephone()));
        FirmworkerAccount firmworkerAccount = new FirmworkerAccount();
        firmworkerAccount.setFwId(firmworker1.getId());
        firmworkerAccount.setAmount(new BigDecimal("0"));
        firmworkerAccount.setFreezeAmount(new BigDecimal("0"));
        firmworkerAccountMapper.insert(firmworkerAccount);

        //审核后通知企业
        Verifyinfo verifyinfo = new Verifyinfo();
        verifyinfo.setFirmId(firm.getId());
        verifyinfo.setInfo("企业审核结果：" + auditVO.getAdvice());
        verifyinfoMapper.insert(verifyinfo);

    }

    @Override
    public void sendMail(String to, String password) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(MailConstant.MAIL_FROM);
        mailMessage.setTo(to);
        mailMessage.setSubject(MailConstant.SUBJECT);
        mailMessage.setText(MailConstant.CONTEXT + password);
        javaMailSender.send(mailMessage);
    }


}
