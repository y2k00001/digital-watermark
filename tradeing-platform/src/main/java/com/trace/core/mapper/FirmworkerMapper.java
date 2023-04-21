package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trace.core.entity.Firmworker;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface FirmworkerMapper extends BaseMapper<Firmworker> {
    /**
     * description  
     * @author monkey
     * @datetime  2023/4/17 23:22
     * @param firmworker
     * @return {@link int}
     **/
    int updateFirmIdById(Firmworker firmworker);

    /**
     * description  
     * @author monkey
     * @datetime  2023/4/20 09:18
     * @param id
     * @return {@link java.lang.Integer}
     **/
    Integer selectTreasurerFwIdByFirmId(Integer id);
}
