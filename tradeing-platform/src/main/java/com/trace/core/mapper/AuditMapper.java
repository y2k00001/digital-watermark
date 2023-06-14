package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Audit;
import com.trace.core.vo.AuditRegisterVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface AuditMapper extends BaseMapper<Audit> {

    /**
     * description  
     * @author monkey
     * @datetime  2023/6/14 09:43
     * @param page
     * @param status
     * @return {@link IPage< AuditRegisterVo>}
     **/
    IPage<AuditRegisterVo> getAuditVoPages(IPage<AuditRegisterVo> page, @Param("status") Integer status);

}
