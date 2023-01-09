package com.trace.core.interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.trace.core.entity.Firmworker;
import com.trace.core.entity.User;
import com.trace.core.exception.Assert;
import com.trace.core.exception.BusinessException;
import com.trace.core.service.FirmworkerService;
import com.trace.core.service.UserService;
import com.trace.core.utils.CurrentUserUtil;
import com.trace.core.utils.JwtUtils;
import com.trace.core.utils.ResponseEnum;
import com.trace.core.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    private UserService userService;
    @Autowired
    private FirmworkerService firmworkerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        String tokenName = "token";
        // 尝试从header中取token
        String token = request.getHeader(tokenName);
        //尝试从参数中取token
        if (StrUtil.isEmpty(token)) {
            token = request.getParameter(tokenName);
        }
        //尝试从cooke
        if (StrUtil.isEmpty(token)) {
            Cookie[] cookies = request.getCookies();
            Assert.notNull(cookies,ResponseEnum.LOGIN_AUTH_ERROR);
            for (Cookie cookie : cookies) {
                if (Objects.equals(cookie.getName(), tokenName)) {
                    token = cookie.getValue();
                }
            }
        }
        //如果前端没有携带token返回json数据
        if (StrUtil.isBlank(token)) {
            PrintWriter pw = response.getWriter();
            pw.write(JSON.toJSONString("用户未登录"));
            return false;
        }
        //解析token
        boolean result = JwtUtils.checkToken(token);
        if (!result) {
            throw new BusinessException(ResponseEnum.LOGIN_AUTH_ERROR);
        }
        //获取用户ID
        Integer userId = JwtUtils.getUserId(token);

        //查询用户
        User user = userService.getById(userId);
        Firmworker firmworker = firmworkerService.getById(userId);
        //判断用户是否存在
        if (user == null&&firmworker==null) {
            throw new BusinessException(ResponseEnum.USER_NOT_EXIST_ERROR);
        }

//        //将登录用户放到ThreadLocal变量变量中，方便业务获取当前登录用户
//        CurrentUser currentUser = new CurrentUser();
//        //currentUser.setType(user.getType());
//        currentUser.setUsername(user.getUsername());
//
//        //当前用户放到ThreadLocal变量变量中
//        CurrentUserUtil.set(currentUser);
        return true;
    }
}
 