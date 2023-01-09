package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trace.core.entity.FirmworkerAccount;

/**
 * <p>
 * 用户账户 Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface FirmworkerAccountMapper extends BaseMapper<FirmworkerAccount> {
    int updateAmountById(FirmworkerAccount firmworkerAccount);
    int updateFreezeAndAmountById(FirmworkerAccount firmworkerAccount);
    FirmworkerAccount selectAccountById(FirmworkerAccount firmworkerAccount);
    FirmworkerAccount selectAccountByFirmworkerId(Integer id);

    Integer unfreezeFundsById(FirmworkerAccount firmworkerAccount);
}
