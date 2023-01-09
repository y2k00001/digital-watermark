package com.trace.core.mapper;

import com.trace.core.entity.Firmworker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface FirmworkerMapper extends BaseMapper<Firmworker> {
    int updateFirmIdById(Firmworker firmworker);

    Integer selectTreasurerFwIdByFirmId(Integer id);
}
