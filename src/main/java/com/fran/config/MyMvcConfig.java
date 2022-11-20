package com.fran.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login_stu");
//        registry.addViewController("/index_stu.html").setViewName("");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login_stu.html").setViewName("login_stu");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/register.html").setViewName("register");





    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates");
    }



    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


   @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/index.html","/tran.html","/login_stu.html","/sendAttachment","/changeAnswer","/find/alter.html","/stu/findPwd","/stu/regist","/regAddStu","/find/check.html","/checkAnswer","/register.html","/","/user/login","/stu/login","/css/*","/js/**","/img/**");
    }
}
