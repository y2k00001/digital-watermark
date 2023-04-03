package com.trace.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Broadcast;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface BroadcastMapper extends BaseMapper<Broadcast> {

    //IPage<Broadcast> getBroadcastPages(IPage<Broadcast> page, @Param("status") Integer status);

    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:19
     * @param page
     * @param status
     * @return {@link IPage< Broadcast>}
     **/
    IPage<Broadcast> getBroadcastPagesByAdmin(IPage<Broadcast> page,@Param("status") Integer status);

    /**
     * description  
     * @author monkey
     * @datetime  2023/4/3 14:19
     * @param page
     * @param status
     * @param userId
     * @return {@link IPage< Broadcast>}
     **/
    IPage<Broadcast> getBroadcastPages(IPage<Broadcast> page, @Param("status") Integer status,@Param("userId") Integer userId);
}
