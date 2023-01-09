package com.trace.core.controller.admin;


import com.trace.core.entity.User;
import com.trace.core.exception.Assert;
import com.trace.core.service.UserService;
import com.trace.core.utils.JwtUtils;
import com.trace.core.utils.PageUtils;
import com.trace.core.utils.R;
import com.trace.core.utils.ResponseEnum;
import com.trace.core.vo.LoginVo;
import com.trace.core.vo.UserInfoVo;
import com.trace.core.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 * 平台侧用户前端控制器
 * </p>
 *
 * @author 四人组
 * @since 2022-09-15
 */

@Slf4j
@Api(tags = "平台侧用户管理")
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Resource
    private UserService userService;


    @ApiOperation("根据搜索框组值查用户列表")
    @PostMapping("/list")
    public R listAll(@ApiParam("搜索框组值包含key+type两个参数") @RequestBody Map<String, Object> params) {
        PageUtils page = userService.queryPage(params);
        return R.ok().put("page", page);
    }

    @ApiOperation("用户创建")
    @PostMapping("/register")
    public R insert(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String truename = user.getTruename();
        String telephone = user.getTelephone();
        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);
        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);
        Assert.notEmpty(truename, ResponseEnum.TRUENAME_NULL_ERROR);
        Assert.notEmpty(telephone, ResponseEnum.MOBILE_NULL_ERROR);
        userService.register(user);
        return R.ok("注册成功");
    }


    @ApiOperation(value = "批量删除用户", notes = "逻辑删除")
    @DeleteMapping("/remove")
    public R removeById(@RequestBody Long[] Ids) {
        boolean result = userService.removeByIds(Arrays.asList(Ids));
        if (result) {
            return R.ok("操作成功");
        } else {
            return R.error(-1, "删除失败");
        }
    }

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/info/{id}")
    public R getById(@ApiParam("用户id") @PathVariable("id") Integer id) {
        UserVo userVo = userService.getUserById(id);
        return R.ok().put("page", userVo);
    }

    @ApiOperation(value = "根据用户名获取用户信息")
    @PostMapping("/info/username")
    public R getById(@ApiParam("用户名") @RequestBody User user) {
        User user1=userService.getByUserInfo(user);
        return R.ok().put("page", user1);
    }

    @ApiOperation("更新用户")
    @PutMapping("/update")
    public R updateById(@RequestBody User user) {
        boolean result = userService.updateById(user);
        if (result) {
            return R.ok();
        } else {
            return R.error(-1, "修改失败");
        }
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R login(@ApiParam(name = "用户登录参数", required = true) @RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        Assert.notEmpty(username, ResponseEnum.USERNAME_NULL_ERROR);
        Assert.notEmpty(password, ResponseEnum.PASSWORD_NULL_ERROR);
        UserInfoVo userInfo = userService.login(loginVo);
        return R.ok().put("data", userInfo);
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

