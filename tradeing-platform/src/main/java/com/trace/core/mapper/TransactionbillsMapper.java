package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Transactionbills;
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

    /**
     * description
     * @author monkey
     * @datetime  2023/5/11 17:34
     * @param transactionbillsListVO
     * @return {@link Integer}
     **/
    Integer confirmContract(TransactionbillsListVO transactionbillsListVO);

    /**
     * description
     * @author monkey
     * @datetime  2023/5/11 17:34
     * @param transactionbillsListVO
     * @return {@link Integer}
     **/
    Integer confirmReceiptCloseContract(TransactionbillsListVO transactionbillsListVO);

    /**
     * description
     * @author monkey
     * @datetime  2023/5/11 17:34
     * @param page
     * @param firmId
     * @return {@link IPage< TransactionbillsListVO>}
     **/
    IPage<TransactionbillsListVO> showTransactionbillsList(IPage<TransactionbillsListVO> page, Integer firmId);


    Integer checkStatus(TransactionbillsListVO transactionbillsListVO);

    IPage<TransactionbillsListVO> getTransactionbillsPages(IPage<TransactionbillsListVO> page, Integer status, Integer firmId);
}
