package com.trace.core.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trace.core.entity.User;
import com.trace.core.exception.Assert;
import com.trace.core.exception.BusinessException;
import com.trace.core.mapper.UserMapper;
import com.trace.core.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.utils.*;
import com.trace.core.vo.LoginVo;
import com.trace.core.vo.UserInfoVo;
import com.trace.core.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //获取key
        String key = (String) params.get("key");
        //获取角色

        String type1 = params.get("type").toString();
        if(StringUtils.hasLength(type1)){
            Integer type = Integer.valueOf(type1) ;
            wrapper.eq(type != null, "type", type);
        }

        if (StringUtils.hasText(key)) {
            wrapper.and((obj) -> {
                obj.like("username", key).or().like("truename", key);
            });
        }
        IPage<User> page = this.page(new Query<User>().getPage(params), wrapper);
        return new PageUtils(page);

    }

    @Override
    public void register(User user) {
        //判断用户名是否存在
        String username = user.getUsername();
        //验证手机号是否正确
        Assert.isTrue(RegexValidateUtils.checkCellphone(user.getTelephone()),ResponseEnum.MOBILE_FORMAT_ERROR);
        Integer count = baseMapper.selectCount(new QueryWrapper<User>().eq("username", username));
        Assert.isTrue(count == 0, ResponseEnum.USERNAME_EXIST_ERROR);
        user.setPassword(MD5.encrypt(user.getPassword()));
        baseMapper.insert(user);
    }

    @Override
    public UserInfoVo login(LoginVo loginVo) {
        //判断用户是否存在
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        String type = loginVo.getType();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username).eq("password", MD5.encrypt(password)).eq("type",type);
        User userInfo = baseMapper.selectOne(wrapper);
        Assert.notNull(userInfo, ResponseEnum.USER_NOT_EXIST_ERROR);

        //校验密码
        Assert.equals(userInfo.getPassword(), MD5.encrypt(password), ResponseEnum.PASSWORD_NOT_RIGHT_ERROR);

        //生成token
        String token = JwtUtils.createToken(userInfo.getId(), userInfo.getUsername());
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setToken(token);
        userInfoVo.setUsername(userInfo.getUsername());
        userInfoVo.setTelephone(userInfo.getTelephone());
        userInfoVo.setTruename(userInfo.getTruename());
        userInfoVo.setType(userInfo.getType());

        return userInfoVo;
    }

    @Override
    public UserVo getUserById(Integer id) {
        User user = baseMapper.selectById(id);
        Assert.notNull(user, ResponseEnum.USER_NOT_EXIST_ERROR);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }

    @Override
    public User getByUserInfo(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        User user1 = baseMapper.selectOne(wrapper);
        return user1;
    }


}
