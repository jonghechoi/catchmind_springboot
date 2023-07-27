package com.springboot.catchmind.config;

import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.sql.SQLTemplates;

import javax.persistence.EntityManager;

public class CustomJPAQueryFactory extends JPAQueryFactory {

    public CustomJPAQueryFactory(EntityManager entityManager) {
        super(entityManager);
    }
}
