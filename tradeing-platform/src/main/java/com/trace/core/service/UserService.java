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

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/30 23:40
     * @param params
     * @return {@link PageUtils}
     **/
    PageUtils queryPage(Map<String, Object> params);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/30 23:40
     * @param user
     * @return 
     **/
    void register(User user);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/30 23:40
     * @param loginVo
     * @return {@link UserInfoVo}
     **/
    UserInfoVo login(LoginVo loginVo);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/30 23:40
     * @param id
     * @return {@link UserVo}
     **/
    UserVo getUserById(Integer id);

    /**
     * description  
     * @author monkey
     * @datetime  2023/3/30 23:40
     * @param user
     * @return {@link User}
     **/
    User getByUserInfo(User user);
}
