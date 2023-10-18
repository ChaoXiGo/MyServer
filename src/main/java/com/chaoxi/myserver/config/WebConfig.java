package com.chaoxi.myserver.config;


import com.chaoxi.myserver.config.handler.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
   /*  @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/app/**")
                // 放行
                .excludePathPatterns("/app/login", "/app/register","/app/test");;
        super.addInterceptors(registry);
    } */

    // 支持跨域请求
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/app/**")
                .allowedOrigins("*")
                // .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
        super.addCorsMappings(registry);
    }
}
