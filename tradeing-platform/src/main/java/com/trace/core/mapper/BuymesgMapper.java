package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Buymesg;
import com.trace.core.vo.BondTotalMidVO;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface BuymesgMapper extends BaseMapper<Buymesg> {

    BondTotalMidVO offerbondTotal(Integer buymesgId) ;

    Integer sellDelistById(Buymesg buymesg);
    Integer sellDelistById2(Buymesg buymesg);
    IPage<Buymesg> getBuymesgPages(IPage<Buymesg> page, Integer status, Integer firmId);

//    IPage<BuymesgListVO> publicBuyList(IPage<BuymesgListVO> page);
IPage<Buymesg> publicBuyList(IPage<Buymesg> page);

    IPage<Buymesg> getBuymesgPages4(IPage<Buymesg> page, Integer status, Integer firmId);
}
