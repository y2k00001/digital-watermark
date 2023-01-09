package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Transactionbills;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trace.core.vo.TransactionbillsListVO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface TransactionbillsMapper extends BaseMapper<Transactionbills> {

    Integer confirmContract(TransactionbillsListVO transactionbillsListVO);
    Integer confirmReceiptCloseContract(TransactionbillsListVO transactionbillsListVO);

    IPage<TransactionbillsListVO> showTransactionbillsList(IPage<TransactionbillsListVO> page, Integer firmId);

    Integer checkStatus(TransactionbillsListVO transactionbillsListVO);

    IPage<TransactionbillsListVO> getTransactionbillsPages(IPage<TransactionbillsListVO> page, Integer status, Integer firmId);
}
