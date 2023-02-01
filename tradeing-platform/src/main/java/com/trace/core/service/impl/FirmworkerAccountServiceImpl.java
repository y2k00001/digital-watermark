package com.trace.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.entity.FirmworkerAccount;
import com.trace.core.entity.TransFlow;
import com.trace.core.mapper.FirmworkerAccountMapper;
import com.trace.core.mapper.TransFlowMapper;
import com.trace.core.service.FirmworkerAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Service
public class FirmworkerAccountServiceImpl extends ServiceImpl<FirmworkerAccountMapper, FirmworkerAccount> implements FirmworkerAccountService {
    @Resource
    private FirmworkerAccountMapper firmworkerAccountMapper;
    @Resource
    private TransFlowMapper transFlowMapper;

    //多表写入, 开启事务管理 , 失败时回滚操作
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveFirmworkerAccount(FirmworkerAccount firmworkerAccount) {
        //企业充值
        firmworkerAccountMapper.updateAmountById(firmworkerAccount);

        //保存企业汇款凭证到 TransFlow表,
        List<TransFlow> transFlowList=firmworkerAccount.getTransFlowList();
        transFlowList.forEach(transFlow -> {
            transFlowMapper.insert(transFlow);
        });

    }
}
