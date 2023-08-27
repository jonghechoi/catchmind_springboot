package com.springboot.catchmind.config;

import com.springboot.catchmind.jpa.factory.CustomJPAQueryFactory;
import com.springboot.catchmind.jpa.entity.QNoticeEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class JpaConfig {
    @Bean
    public CustomJPAQueryFactory customJPAQueryFactory(EntityManager entityManager) {
        return new CustomJPAQueryFactory(entityManager);
    }

    @Bean
    public QNoticeEntity qNoticeEntity() {
        return QNoticeEntity.noticeEntity;
    }
}