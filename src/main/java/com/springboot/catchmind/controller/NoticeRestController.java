package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.service.NoticeServiceImpl;
import com.springboot.catchmind.service.PagingServiceImpl;
import com.springboot.catchmind.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class NoticeRestController {
    @Autowired
    private PagingServiceImpl pagingService;
    @Autowired
    private NoticeServiceImpl noticeService;

    /**
     *	Notice paging
     */
    @GetMapping("notice_list_paging/{page}")
    public Map<String, Object> notice_list_paging(@PathVariable String page) {
        PageDto pageDto = pagingService.getPageResult(new PageDto(page, "notice", ""));
        Map<String, Object> response = new HashMap<>();
        response.put("list", noticeService.getNoticeSelectJson(pageDto));
        response.put("page", pageDto);
        return response;
    }
}
