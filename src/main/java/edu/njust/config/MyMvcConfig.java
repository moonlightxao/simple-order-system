package edu.njust.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**","/user/sign_up","/user/login","/","/sign-in.html","/order.html","/order");*/
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("sign-in");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/sign-in.html").setViewName("sign-in");
        registry.addViewController("/main.html").setViewName("backstage/dashboard");
        registry.addViewController("/sign-up.html").setViewName("sign-up");
        registry.addViewController("/order.html").setViewName("order");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/temp-rainy/**").addResourceLocations("file:D:/pic/");
    }
}
