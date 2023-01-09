package com.trace.core.service;

import com.trace.core.entity.Firmworker;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.utils.PageUtils;
import com.trace.core.vo.FirmworkerInfoVo;
import com.trace.core.vo.LoginVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface FirmworkerService extends IService<Firmworker> {

    PageUtils queryPage(Map<String, Object> params);

    FirmworkerInfoVo login(LoginVo loginVo);

    Integer register(Firmworker firmworker);
}
