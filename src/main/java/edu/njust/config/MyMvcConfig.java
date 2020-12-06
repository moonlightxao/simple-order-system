package edu.njust.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    }

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("http://192.168.50.49/").allowedOrigins("*").allowCredentials(true).allowedMethods("*").maxAge(3600);

    }
}
