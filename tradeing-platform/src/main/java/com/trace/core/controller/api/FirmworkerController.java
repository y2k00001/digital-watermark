package com.trace.core.controller.api;


import com.trace.core.entity.Firmworker;
import com.trace.core.exception.Assert;
import com.trace.core.mapper.FirmworkerMapper;
import com.trace.core.service.FirmworkerService;
import com.trace.core.utils.*;
import com.trace.core.vo.FirmworkerInfoVo;
import com.trace.core.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  企业用户前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */

@Slf4j
@Api(tags="企业用户管理A")
@RestController
@RequestMapping("/api/firmworker")
public class FirmworkerController {
    @Resource
    private FirmworkerService firmworkerService;
    @Resource
    private FirmworkerMapper firmworkerMapper;

    @ApiOperation("根据搜索框组值查企业用户列表")
    @PostMapping("/list")
    public R listAll(@ApiParam("搜索框组值包含key+type两个参数")  @RequestBody Map<String,Object> params){
        PageUtils page = firmworkerService.queryPage(params);
        return R.ok().put("page",page);
    }

    @ApiOperation("企业用户创建")
    @PostMapping("/register")
    public R insert(@RequestBody Firmworker firmworker){
        String truename = firmworker.getTruename();
        String telephone = firmworker.getTelephone();
        String password = firmworker.getPassword();
        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);
        Assert.notEmpty(truename, ResponseEnum.TRUENAME_NULL_ERROR);
        Assert.notEmpty(telephone, ResponseEnum.MOBILE_NULL_ERROR);

        Integer result =firmworkerService.register(firmworker);
        if(result>0){
            return R.ok("操作成功");
        }else{
            return R.error(-1,"操作失败");
        }
    }

    @ApiOperation(value = "根据fwId获取企业用户信息")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("企业用户id") @PathVariable("id")  Integer id){
        Firmworker firmworker = firmworkerService.getById(id);
        return R.ok().put("page",firmworker);
    }

    @ApiOperation("更新企业用户")
    @PostMapping("/update")
    public R updateById(@RequestBody Firmworker firmworker) {
        firmworker.setPassword(MD5.encrypt(firmworker.getPassword()));
        boolean result = firmworkerService.updateById(firmworker);
        if (result) {
            return R.ok();
        } else {
            return R.error(-1, "修改失败");
        }
    }

    @ApiOperation("更新企业用户的公司号")
    @PostMapping("/updateFirmId")
    public R updateFirmIdById(@RequestBody Firmworker firmworker) {
        //使用自定义Mapper  只要拿着fwid对fmid修改
        if (firmworkerMapper.updateFirmIdById(firmworker) > 0) {
            return R.ok();
        } else {
            return R.error(-1, "修改失败");
        }
    }


    @ApiOperation("企业用户登录")
    @PostMapping("/login")
    public R login(@ApiParam(name = "用户登录参数", required = true) @RequestBody LoginVo loginVo){
        String truename = loginVo.getUsername();
        String password = loginVo.getPassword();
        Assert.notEmpty(truename, ResponseEnum.USERNAME_NULL_ERROR);
        Assert.notEmpty(password,ResponseEnum.PASSWORD_NULL_ERROR);
        FirmworkerInfoVo firmworkerInfoVo = firmworkerService.login(loginVo);
        return R.ok().put("data",firmworkerInfoVo);
    }

    @ApiOperation("校验令牌")
    @GetMapping("/checkToken")
    public R checkToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        boolean result = JwtUtils.checkToken(token);
        if (result) {
            return R.ok();
        } else {
            return R.error(ResponseEnum.LOGIN_AUTH_ERROR);
        }

    }


}

