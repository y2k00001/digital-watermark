package com.trace.core.config;

import com.trace.core.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

   @Autowired
   LoginInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/firmworker/register"
                        , "/api/sellmesg/publicBuyList","/api/buymesg/publicBuyList"
                        ,"/api/firmworker/login","/admin/user/login"
                        , "/api/user/login", "/swagger-resources/**"
                        , "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/doc.html/**");
    }


}