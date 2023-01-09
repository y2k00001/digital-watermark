package com.trace.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trace.core.entity.Firmworker;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.FirmworkerMapper;
import com.trace.core.service.FirmworkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.trace.core.utils.*;
import com.trace.core.vo.FirmworkerInfoVo;
import com.trace.core.vo.LoginVo;
import com.trace.core.vo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
@Slf4j
public class FirmworkerServiceImpl extends ServiceImpl<FirmworkerMapper, Firmworker> implements FirmworkerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params){
        //获取key 来自前端搜索框
        String key=(String)params.get("key");
        //获取角色
        Integer type =(Integer) params.get("type");
        QueryWrapper<Firmworker> wrapper=new QueryWrapper<>();
        wrapper.eq(type != null, "type", type);
        if (StringUtils.hasText(key)) {
            wrapper.and((obj) -> {
                obj.like("truename", key);
            });
        }
        IPage<Firmworker> page=this.page(new Query<Firmworker>().getPage(params),wrapper);
        return new PageUtils(page);
    }

    @Override
    public FirmworkerInfoVo login(LoginVo loginVo) {
        //判断企业用户存在
        String telephone = loginVo.getTelephone();
        String password = loginVo.getPassword();
        log.info("用户名:{}"+"密码:{}",telephone,password);
        QueryWrapper<Firmworker> wrapper =new QueryWrapper<>();
        wrapper.eq("telephone",telephone).eq("password", MD5.encrypt(password));
        Firmworker firmworkerInfo=baseMapper.selectOne(wrapper);

        Assert.notNull(firmworkerInfo,ResponseEnum.USER_NOT_EXIST_ERROR);

        //校验密码
        Assert.equals(firmworkerInfo.getPassword(),MD5.encrypt(password),ResponseEnum.PASSWORD_NOT_RIGHT_ERROR);

        //生成token
        String token = JwtUtils.createToken(firmworkerInfo.getId(), firmworkerInfo.getTruename());
        FirmworkerInfoVo firmworkerInfoVo = new FirmworkerInfoVo();
        firmworkerInfoVo.setToken(token);
        firmworkerInfoVo.setId(firmworkerInfo.getId());//员工id
        firmworkerInfoVo.setFirmId(firmworkerInfo.getFirmId());
        firmworkerInfoVo.setTruename(firmworkerInfo.getTruename());
        firmworkerInfoVo.setTelephone(firmworkerInfo.getTelephone());
        firmworkerInfoVo.setEmail(firmworkerInfo.getEmail());
        firmworkerInfoVo.setFirmtype(firmworkerInfo.getFirmtype());
        firmworkerInfoVo.setType(firmworkerInfo.getType());

        return firmworkerInfoVo;

    }

    @Override
    public Integer register(Firmworker firmworker){
        //判断手机号是否存在
        String telephone = firmworker.getTelephone();
        Integer count = baseMapper.selectCount(new QueryWrapper<Firmworker>().eq("telephone", telephone));
        Assert.isTrue(count == 0, ResponseEnum.USERNAME_EXIST_ERROR);//手机号已经注册
        firmworker.setPassword(MD5.encrypt(firmworker.getPassword()));
        return baseMapper.insert(firmworker);

    }


}
