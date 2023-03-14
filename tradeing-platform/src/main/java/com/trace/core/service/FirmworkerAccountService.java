package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.FirmworkerAccount;

/**
 * <p>
 * 用户账户 服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */

public interface FirmworkerAccountService extends IService<FirmworkerAccount> {
    /**
     * description  
     * @author monkey
     * @datetime  2023/3/14 11:54
     * @param firmworkerAccount
     * @return 
     **/
    void saveFirmworkerAccount(FirmworkerAccount firmworkerAccount);
}
