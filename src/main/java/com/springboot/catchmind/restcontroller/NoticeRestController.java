package com.springboot.catchmind.restcontroller;

import com.querydsl.core.Tuple;
import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.jpa.entity.NoticeEntity;
import com.springboot.catchmind.jpa.repositoryimpl.PageRequest;
import com.springboot.catchmind.service.NoticeServiceImpl;
import com.springboot.catchmind.service.NoticeServiceJPAImpl;
import com.springboot.catchmind.service.PagingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.springboot.catchmind.jpa.entity.QNoticeEntity.noticeEntity;

@RestController
public class NoticeRestController {
    @Autowired
    private PagingServiceImpl pagingService;
    @Autowired
    private NoticeServiceImpl noticeService;
    @Autowired
    private NoticeServiceJPAImpl noticeServiceJPA;

    /**
     *	Notice paging
     */
    @GetMapping("notice_list_paging/{serviceName}/{page}")
    public Map<String, Object> notice_list_paging(PageDto pageDto) {
        //Pageable pageable = pageRequest.of();

        PageDto page = pagingService.getPageResult(pageDto);
        List<NoticeDto> list = noticeServiceJPA.getNoticeSelectJson(page);
        list.stream().forEach(noticeRow ->
                                System.out.println("rno --> " + noticeRow + "        ntitle --> " + noticeRow.getNtitle()));

        Map<String, Object> response = new HashMap<>();
        response.put("list", list);
        response.put("page", page);
        return response;
    }
}
