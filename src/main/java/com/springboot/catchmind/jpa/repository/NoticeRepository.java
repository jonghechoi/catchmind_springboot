package com.springboot.catchmind.jpa.repository;

import com.springboot.catchmind.jpa.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<NoticeEntity, String> {
}
