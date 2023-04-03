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

    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:19
     * @param buymesgId
     * @return {@link BondTotalMidVO}
     **/
    BondTotalMidVO offerbondTotal(Integer buymesgId) ;

    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:19
     * @param buymesg
     * @return {@link Integer}
     **/
    Integer sellDelistById(Buymesg buymesg);
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:19
     * @param buymesg
     * @return {@link Integer}
     **/
    Integer sellDelistById2(Buymesg buymesg);
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:19
     * @param page
     * @param status
     * @param firmId
     * @return {@link IPage< Buymesg>}
     **/
    IPage<Buymesg> getBuymesgPages(IPage<Buymesg> page, Integer status, Integer firmId);

//    IPage<BuymesgListVO> publicBuyList(IPage<BuymesgListVO> page);
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:19
     * @param page
     * @return {@link IPage< Buymesg>}
     **/
    IPage<Buymesg> publicBuyList(IPage<Buymesg> page);

    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:20
     * @param page
     * @param status
     * @param firmId
     * @return {@link IPage< Buymesg>}
     **/
    IPage<Buymesg> getBuymesgPages4(IPage<Buymesg> page, Integer status, Integer firmId);
}
