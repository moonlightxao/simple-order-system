package edu.njust.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandleInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/sign_up","/user/login","/","/static/*","/css/**","/brand/**","/img/**","/js/**","/pic/**","/scss/**","/sign-in.html");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("sign-in");
        registry.addViewController("/sign-in.html").setViewName("sign-in");
        registry.addViewController("/main.html").setViewName("backstage/dashboard");
        registry.addViewController("/sign-up.html").setViewName("sign-up");
    }
}
