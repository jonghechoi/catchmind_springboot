package com.springboot.catchmind.jpa.repositoryimpl;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.factory.CustomJPAQueryFactory;
import com.springboot.catchmind.dto.NoticeDto;

import com.springboot.catchmind.jpa.entity.QNoticeEntity;
import com.springboot.catchmind.jpa.repository.NoticeJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Repository
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class NoticeJPARepositoryImpl implements NoticeJPARepository {
    private final CustomJPAQueryFactory jpaQueryFactory;
    private final QNoticeEntity qNoticeEntity;

    public int getTotalRowCount() {
        return (int)jpaQueryFactory.selectFrom(qNoticeEntity).stream().count();
    }

    @Override
    public List<NoticeDto> getNoticeListByPage(PageDto pageDto) {
        return jpaQueryFactory
                .select(
                 Projections.fields(NoticeDto.class,
                         Expressions.template(Integer.class, "function('ROWNUM')").as("rno"),
                                     qNoticeEntity.ntitle,
                                     qNoticeEntity.ncreatedate,
                                     qNoticeEntity.nid)
                )
                .from(qNoticeEntity)
                .orderBy(qNoticeEntity.ncreatedate.desc())
                .offset(Integer.valueOf(pageDto.getStartCount())-1)
                .limit(pageDto.getPageSize())
                .fetch();
    }
}
