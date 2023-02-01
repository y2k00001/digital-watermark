package com.trace.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.trace.core.entity.User;
import com.trace.core.utils.PageUtils;
import com.trace.core.vo.LoginVo;
import com.trace.core.vo.UserInfoVo;
import com.trace.core.vo.UserVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
public interface UserService extends IService<User> {


    PageUtils queryPage(Map<String, Object> params);

    void register(User user);

    UserInfoVo login(LoginVo loginVo);

    UserVo getUserById(Integer id);

    User getByUserInfo(User user);
}
