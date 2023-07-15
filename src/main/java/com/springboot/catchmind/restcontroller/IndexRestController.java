package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.service.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexRestController {

    @Autowired
    private Scheduler reviewSchedulerService;

    /**
     *	Index review
     */
    @GetMapping("index_review")
    public List<ReviewDto> index_review() { return reviewSchedulerService.reviewMainChange(); }
}
