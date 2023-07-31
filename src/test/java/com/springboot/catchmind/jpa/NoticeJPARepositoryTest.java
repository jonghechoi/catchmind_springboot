package com.springboot.catchmind.jpa;


import com.springboot.catchmind.jpa.entity.NoticeEntityTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // default is in-memory DB. To use Oracle which is configured in application.properties
public class NoticeJPARepositoryTest {

    @Autowired
    private com.springboot.catchmind.jpa.repository.NoticeRepositoryTest noticeRepositoryTest;

    @BeforeEach
    void insertTestData() {}

    @Test
    @DisplayName("notice 정보가 잘 출력되는지 확인하는 테스트")
    public void findAllTest() {
        NoticeEntityTest noticeEntityTest = new NoticeEntityTest();
        noticeEntityTest.setNid("N_0001");
        noticeEntityTest.setAID("A_0001");
        noticeEntityTest.setNcreateid("CREATEID");
        noticeEntityTest.setNcreatedate("2023/03/01");
        noticeEntityTest.setNmodifyid("MODIFYID");
        noticeEntityTest.setNmodifydate("2023/05/19");
        noticeEntityTest.setNdeleteyn("N");
        noticeEntityTest.setNtitle("THIS IS TITLE - 2023/03/01");
        noticeEntityTest.setNhits(0);
        noticeEntityTest.setNcontents("The entire system will be inspected as of March 2023. Please keep in mind.");
        noticeRepositoryTest.save(noticeEntityTest);

        noticeEntityTest = new NoticeEntityTest();
        noticeEntityTest.setNid("N_0002");
        noticeEntityTest.setAID("A_0001");
        noticeEntityTest.setNcreateid("CREATEID");
        noticeEntityTest.setNcreatedate("2023/04/12");
        noticeEntityTest.setNmodifyid("MODIFYID");
        noticeEntityTest.setNmodifydate("2023/05/19");
        noticeEntityTest.setNdeleteyn("N");
        noticeEntityTest.setNtitle("THIS IS TITLE - 2023/04/12");
        noticeEntityTest.setNhits(0);
        noticeEntityTest.setNcontents("The entire system will be inspected as of April 2023. Please keep in mind.");
        noticeRepositoryTest.save(noticeEntityTest);

        List<NoticeEntityTest> noticeEntityTestList = noticeRepositoryTest.findAll();
        noticeEntityTestList.stream()
                            .forEach(notice -> log.info("ncontents -> " + notice.getNcontents()));
    }
}
