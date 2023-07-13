package com.springboot.catchmind.config;

import com.springboot.catchmind.interceptor.SessionAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SessionConfig implements WebMvcConfigurer {

    @Bean
    public SessionAuthInterceptor sessionAuthInterceptor() {
        return new SessionAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionAuthInterceptor())
                .addPathPatterns("/mypage**/**")
                .addPathPatterns("/shop**/**")
                .addPathPatterns("/mydining**/**")
                .addPathPatterns("/reservation**/**")
                .addPathPatterns("/admin**/**");
    }
}
