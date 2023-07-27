package com.springboot.catchmind.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class JpaConfig {
    @Bean
    public CustomJPAQueryFactory customJPAQueryFactory(EntityManager entityManager) {
        return new CustomJPAQueryFactory(entityManager);
    }
}