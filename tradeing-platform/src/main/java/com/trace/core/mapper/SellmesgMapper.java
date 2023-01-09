package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Sellmesg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    BondTotalMidVO offerbondTotal(Integer sellmesgId) ;
    IPage<Sellmesg> getSellmesgPages(IPage<Sellmesg> page, @Param("status") Integer status);

    IPage<SellmesgListVO> publicSellList(IPage<SellmesgListVO> page);

    Integer buyDelistById(Sellmesg sellmesg);

    IPage<Sellmesg> getAuditVoPages(IPage<Sellmesg> page,@Param("status") Integer status);
}
