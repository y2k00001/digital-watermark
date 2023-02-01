package com.trace.core.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.entity.Broadcast;
import com.trace.core.mapper.BroadcastMapper;
import com.trace.core.service.BroadcastService;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Service
public class BroadcastServiceImpl extends ServiceImpl<BroadcastMapper, Broadcast> implements BroadcastService {
    @Override
    public PageUtils queryPageById(Map<String, Object> params,Integer userId) {
        //获取状态
        Integer status = (Integer) params.get("status");
        IPage<Broadcast> pages = baseMapper.getBroadcastPages(new Query<Broadcast>().getPage(params),status,userId);
        return new PageUtils(pages);
    }

    //@Override
    //public PageUtils queryPage(Map<String, Object> params) {
    //    //获取状态
    //    Integer status = (Integer) params.get("status");
    //    IPage<Broadcast> pages = baseMapper.getBroadcastPages(new Query<Broadcast>().getPage(params),status);
    //    return new PageUtils(pages);
    //}

    @Override
    public PageUtils queryPageByAdmin(Map<String, Object> params) {
        //获取状态
        Integer status = (Integer) params.get("status");
        IPage<Broadcast> pages = baseMapper.getBroadcastPagesByAdmin(new Query<Broadcast>().getPage(params),status);
        return new PageUtils(pages);
    }

}
