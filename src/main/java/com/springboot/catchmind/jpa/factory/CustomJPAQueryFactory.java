package com.springboot.catchmind.jpa.factory;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class CustomJPAQueryFactory extends JPAQueryFactory {

    public CustomJPAQueryFactory(EntityManager entityManager) {
        super(entityManager);
    }
}
