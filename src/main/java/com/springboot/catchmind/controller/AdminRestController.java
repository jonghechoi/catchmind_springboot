package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.NoticeDto;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.service.AdminServiceImpl;
import com.springboot.catchmind.service.NoticeServiceImpl;
import com.springboot.catchmind.service.PagingServiceImpl;
import com.springboot.catchmind.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminRestController {
    @Autowired
    private PagingServiceImpl pagingService;
    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private NoticeServiceImpl noticeService;

    /**
     *	Admin paging - Member, Review
     */
    @GetMapping("admin_member_list_paging/{page}")
    public Map<String, Object> admin_member_list_paging(@PathVariable String page) {
        PageDto pageDto = pagingService.getPageResult(new PageDto(page, "member"));
        Map<String, Object> response = new HashMap<>();
        response.put("list", adminService.getMemberSelectJson(pageDto));
        response.put("page", pageDto);
        return response;
    }
    @GetMapping("admin_review_list/{page}")
    public Map<String, Object> admin_review_list(@PathVariable String page) {
        PageDto pageDto = pagingService.getPageResult(new PageDto(page, "review"));
        Map<String, Object> response = new HashMap<>();
        response.put("list", adminService.getReviewSelectJson(pageDto));
        response.put("page", pageDto);
        return response;
    }

    /**
     *  Admin member data
     */
    @GetMapping("admin_member_modify_data/{mid}")
    public String admin_member_modify_data(@PathVariable String mid, Model model) {
        return mid;
    }

    /**
     *	Admin notice
     */
    @PostMapping("admin_notice_update_proc")
    public String admin_notice_update_proc(NoticeDto noticeDto) {
        return String.valueOf(adminService.getNoticeUpdate(noticeDto));
    }

    @PostMapping("admin_notice_upload")
    public String notice_upload(NoticeDto noticeDto) {
        return String.valueOf(adminService.getNoticeUpload(noticeDto));
    }

    @GetMapping("admin_notice_delete_proc/{nid}")
    public String admin_notice_delete_proc(@PathVariable String nid) {
        return String.valueOf(adminService.getNoticeDelete(nid));
    }

    /**
     *  Admin review
     */
    @GetMapping("admin_review_detail_data/{rid}")
    public String admin_review_detail_data(@PathVariable String rid) {
        return String.valueOf(adminService.getReviewMainUpdate(rid));
    }

    @GetMapping("admin_review_detail_delete_data/{rid}")
    public String admin_review_detail_delete_data(@PathVariable String rid) {
        return String.valueOf(adminService.getReviewMainDelete(rid));
    }
}
