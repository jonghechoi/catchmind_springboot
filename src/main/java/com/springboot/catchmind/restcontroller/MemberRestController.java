package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.exception.MemberErrorCode;
import com.springboot.catchmind.exception.MemberException;
import com.springboot.catchmind.service.MailSendService;
import com.springboot.catchmind.service.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MemberRestController {
    @Autowired
    MemberServiceImpl memberService;

    @Autowired
    MailSendService mailSendService;

    @PostMapping("join_email_check")
    public ResponseEntity<?> join_email_check(@RequestParam String memail) {
        int emailCount = memberService.getEmailCheck(memail);
        
        if(emailCount == 1) {
            throw new MemberException(MemberErrorCode.EMAIL_DUPLICATED);
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(emailCount);
        }
    }


    @GetMapping("id_check/{memberId}")
    public String id_check(@PathVariable String memberId) {
        return String.valueOf(memberService.getIdCheck(memberId));
    }

    @GetMapping("find_pass_emailCheck/{memail}")
    public String find_pass_emailCheck(@PathVariable String memail) {
        log.info("Find_User_MEmail -> {}", memail);
        return mailSendService.findEmail(memail);
    }
}
