package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Sellmesg;
import com.trace.core.vo.BondTotalMidVO;
import com.trace.core.vo.SellmesgListVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface SellmesgMapper extends BaseMapper<Sellmesg> {
    /**
     * description  
     * @author monkey
     * @datetime  2023/5/4 14:01
     * @param sellmesgId
     * @return {@link BondTotalMidVO}
     **/
    BondTotalMidVO offerbondTotal(Integer sellmesgId) ;
    
    /**
     * description  
     * @author monkey
     * @datetime  2023/5/4 14:01
     * @param page
     * @param status
     * @return {@link IPage< Sellmesg>}
     **/
    IPage<Sellmesg> getSellmesgPages(IPage<Sellmesg> page, @Param("status") Integer status);

    /**
     * description  
     * @author monkey
     * @datetime  2023/5/4 14:01
     * @param page
     * @return {@link IPage< SellmesgListVO>}
     **/
    IPage<SellmesgListVO> publicSellList(IPage<SellmesgListVO> page);

    /**
     * description  
     * @author monkey
     * @datetime  2023/5/4 14:01
     * @param sellmesg
     * @return {@link Integer}
     **/
    Integer buyDelistById(Sellmesg sellmesg);

    /**
     * description  
     * @author monkey
     * @datetime  2023/5/4 14:01
     * @param page
     * @param status
     * @return {@link IPage< Sellmesg>}
     **/
    IPage<Sellmesg> getAuditVoPages(IPage<Sellmesg> page,@Param("status") Integer status);
}
