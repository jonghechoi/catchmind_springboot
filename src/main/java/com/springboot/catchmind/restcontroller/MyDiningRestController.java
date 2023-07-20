package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.dto.ScheduledDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.service.MailSendService;
import com.springboot.catchmind.service.MemberServiceImpl;
import com.springboot.catchmind.service.MyDiningServiceImpl;
import com.springboot.catchmind.service.PagingServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class MyDiningRestController {
    @Autowired
    MyDiningServiceImpl myDiningService;

    @Autowired
    PagingServiceImpl pagingService;

    @Autowired
    MailSendService mailSendService;

    @Autowired
    MemberServiceImpl memberService;

    @GetMapping("id_check/{memberId}")
    public String id_check(@PathVariable String memberId) {
        return String.valueOf(memberService.getIdCheck(memberId));
    }

    @GetMapping("find_pass_emailCheck/{memail}")
    public String find_pass_emailCheck(@PathVariable String memail) {
        log.info("Find_User_MEmail -> {}", memail);
        return mailSendService.findEmail(memail);
    }

    @GetMapping("mydining_cancel_noshow/{page}")
    public Map mydining_cancel_noshow(@PathVariable String page, HttpSession session) {
        Map map = new HashMap();
        SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
        String mid = sessionVo.getMid();

        PageDto pageDto = pagingService.getVisitedResult(new PageDto(page, "cancel_noshow", mid));

        map.put("list", myDiningService.getCancelNoshow(pageDto));
        map.put("page", pageDto);

        return map;
    }

    @GetMapping("mydining_visited_paging/{page}")
    public Map mydining_visited_paging(@PathVariable String page, HttpSession session) {
        Map map = new HashMap();
        SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
        String mid = sessionVo.getMid();

        PageDto pageDto = pagingService.getVisitedResult(new PageDto(page, "visited", mid));

        map.put("list", myDiningService.getVisitedSelect(pageDto));
        map.put("page", pageDto);

        return map;
    }
}
