package com.springboot.catchmind.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.catchmind.jpa.entity.QNoticeEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QueryDslConfig {
    @PersistenceContext
    private EntityManager entityManager;

    // JPAQueryFactory bean register
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public QNoticeEntity qNoticeEntity() {
        return QNoticeEntity.noticeEntity;
    }
}
