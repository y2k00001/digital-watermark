package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.Firmworker;
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

    /**
     * description
     * @author monkey
     * @datetime  2023/3/14 12:00
     * @param params
     * @return {@link com.trace.core.utils.PageUtils}
     **/
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 登录
     * @author monkey
     * @datetime  2023/3/23 09:37
     * @param loginVo
     * @return {@link FirmworkerInfoVo}
     **/
    FirmworkerInfoVo login(LoginVo loginVo);


    /**
     * 注册
     * @author monkey
     * @datetime  2023/3/23 09:37
     * @param firmworker
     * @return {@link Integer}
     **/
    Integer register(Firmworker firmworker);
}
