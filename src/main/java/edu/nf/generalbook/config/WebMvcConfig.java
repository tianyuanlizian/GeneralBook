package edu.nf.generalbook.config;

import edu.nf.generalbook.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 装配拦截器
 * @Author: tianyuan
 * @Date: 2023/12/26 15:01
 **/
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") // 拦截所有路径
                .excludePathPatterns("/login.html", "/register.html","/js/**","/layui/**","/elementcss/**","/login"); // 不拦截的路径
    }
    /**
     * 跨域配置
     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .exposedHeaders("*");
//        //跨域时是否允许传递cookie，默认是不允许的
//        //.allowCredentials(true);
//    }
}
