package edu.nf.generalbook.config;

import edu.nf.generalbook.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: tianyuan
 * @Date: 2023/12/26 15:01
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截器（开发中）
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**") // 拦截所有路径
//                .excludePathPatterns("/login.html", "/logout.html"); // 不拦截登录和注销路径
    }
}
