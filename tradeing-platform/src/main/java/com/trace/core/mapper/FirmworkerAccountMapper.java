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
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/15 00:36
     * @param firmworkerAccount
     * @return {@link int}
     **/
    int updateAmountById(FirmworkerAccount firmworkerAccount);
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/15 00:36
     * @param firmworkerAccount
     * @return {@link int}
     **/
    int updateFreezeAndAmountById(FirmworkerAccount firmworkerAccount);
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/15 00:36
     * @param firmworkerAccount
     * @return {@link FirmworkerAccount}
     **/
    FirmworkerAccount selectAccountById(FirmworkerAccount firmworkerAccount);
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/15 00:36
     * @param id
     * @return {@link FirmworkerAccount}
     **/
    FirmworkerAccount selectAccountByFirmworkerId(Integer id);
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/15 00:36
     * @param firmworkerAccount
     * @return {@link Integer}
     **/

    Integer unfreezeFundsById(FirmworkerAccount firmworkerAccount);
}
