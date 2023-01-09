package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trace.core.entity.Audit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    IPage<AuditRegisterVo> getAuditVoPages(IPage<AuditRegisterVo> page, @Param("status") Integer status);

}
