package com.springboot.catchmind.jpa.repository;

import com.springboot.catchmind.jpa.entity.NoticeEntityTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepositoryTest extends JpaRepository<NoticeEntityTest, String> {
}