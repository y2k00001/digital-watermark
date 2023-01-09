package com.trace.core.service;

import com.trace.core.entity.Transactionbills;
import com.baomidou.mybatisplus.extension.service.IService;
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

    Integer uploadTransactionBills(Transactionbills transactionbills);

    PageUtils showTransactionbillsList(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params);

    Transactionbills getTransactionbillsById(Integer id);
}
