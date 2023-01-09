package com.trace.core.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Buymesg;
import com.trace.core.entity.Transactionbills;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.BuymesgMapper;
import com.trace.core.mapper.TransactionbillsMapper;
import com.trace.core.service.TransactionbillsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.Query;
import com.trace.core.utils.ResponseEnum;
import com.trace.core.vo.TransactionbillsListVO;
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
public class TransactionbillsServiceImpl extends ServiceImpl<TransactionbillsMapper, Transactionbills> implements TransactionbillsService {
    @Resource
    private TransactionbillsMapper transactionbillsMapper;
    @Resource
    private BuymesgMapper buymesgMapper;

    //多表写入, 开启事务管理 , 失败时回滚操作
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer uploadTransactionBills(Transactionbills transactionbills) {
        //本版本是 摘牌表示全部承接 / 供应  ,不存在部分供应或者部分采购 , 例如摘牌100吨挂销就承包100吨
        //[暂放]查询有无已有合同有就不插入了, 只允许修改合同通过更新:文件图片路径 ,
        ////合同上传后Buymesg status9
        Buymesg buymesg =new Buymesg();
        buymesg.setStatus(9);
        buymesg.setId(transactionbills.getBuymesgId());
        buymesgMapper.sellDelistById2(buymesg);

        //status设置0 ,上传等待对方确认 ,
        transactionbills.setStatus(0);
        return baseMapper.insert(transactionbills);
    }

    @Override
    public PageUtils showTransactionbillsList(Map<String, Object> params) {
        //获取状态
        Integer firmId = (Integer) params.get("firmId");

        IPage<TransactionbillsListVO> pages = transactionbillsMapper.showTransactionbillsList(new Query<TransactionbillsListVO>().getPage(params),firmId);
        return new PageUtils(pages);
    }
    @Override
    public Transactionbills getTransactionbillsById(Integer id) {
        Transactionbills transactionbills=transactionbillsMapper.selectById(id);
        Assert.notNull(transactionbills, ResponseEnum.QUERY_INFORMATION_IS_NULL_ERROR);
        return transactionbills;
    }

    //企业查询自己合同  可以选择状态 类似三个分页
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        //获取状态
        Integer status = (Integer) params.get("status");
        Integer firmId = (Integer) params.get("firmId");
        IPage<TransactionbillsListVO> pages = baseMapper.getTransactionbillsPages(new Query<TransactionbillsListVO>().getPage(params), status,firmId);
        return new PageUtils(pages);
    }
}
