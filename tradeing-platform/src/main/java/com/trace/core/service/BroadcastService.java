package com.trace.core.service;

import com.trace.core.entity.Broadcast;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.utils.PageUtils;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface BroadcastService extends IService<Broadcast> {

    //PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageByAdmin(Map<String, Object> params);



    PageUtils queryPageById(Map<String, Object> params,Integer userId);
}
