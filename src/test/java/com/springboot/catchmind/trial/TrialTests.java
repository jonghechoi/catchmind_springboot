package com.springboot.catchmind.trial;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.catchmind.trial.entity.Trial;
import com.springboot.catchmind.trial.entity.TrialRepository;


@SpringBootTest
public class TrialTests {

    @Autowired
    TrialRepository trialRepository;

    @Test
    void save() {

        // 1. 게시글 파라미터 생성
        Trial params = Trial.builder()
                .title("2번 게시글 제목")
                .content("2번 게시글 내용")
                .writer("도뎡이")
                .hits(0)
                .deleteYn('N')
                .build();

        // 2. 게시글 저장
        trialRepository.save(params);

        // 3. 1번 게시글 정보 조회
        Trial entity = trialRepository.findById((long) 1).get();
        assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
        assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
        assertThat(entity.getWriter()).isEqualTo("도뎡이");
    }

    @Test
    void findAll() {

        // 1. 전체 게시글 수 조회
        long trialsCount = trialRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<Trial> trials = trialRepository.findAll();
    }

    @Test
    void delete() {

        // 1. 게시글 조회
        Trial entity = trialRepository.findById((long) 1).get();

        // 2. 게시글 삭제
        trialRepository.delete(entity);
    }

}