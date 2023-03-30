package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.Transactionbills;
import com.trace.core.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface TransactionbillsService extends IService<Transactionbills> {

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/27 23:35
     * @param transactionbills
     * @return {@link Integer}
     **/
    Integer uploadTransactionBills(Transactionbills transactionbills);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/27 23:35
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils showTransactionbillsList(Map<String, Object> params);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/27 23:35
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils queryPage(Map<String, Object> params);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/28 17:01
     * @param id
     * @return {@link com.trace.core.entity.Transactionbills}
     **/
    Transactionbills getTransactionbillsById(Integer id);
}
