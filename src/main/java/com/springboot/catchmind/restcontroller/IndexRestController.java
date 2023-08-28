package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.service.MapServiceImpl;
import com.springboot.catchmind.service.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexRestController {

    @Autowired
    private Scheduler reviewSchedulerService;
    @Autowired
    private MapServiceImpl mapService;

    /**
     *	Index review
     */
    @GetMapping("index_review")
    public List<ReviewDto> index_review() {

        //List<ReviewDto> list = reviewSchedulerService.reviewMainChange();
        //list.stream().forEach(review -> System.out.println(review.getRid()));

        return reviewSchedulerService.reviewMainChange();
    }

    /**
     *	Index mapMarker
     */
    @PostMapping("index_mapMarker")
    public String index_mapMarker(@RequestParam("lat") double lat, @RequestParam("lng") double lng) {
        System.out.println("lat --> " + lat);
        System.out.println("lng --> " + lng);
        return mapService.mapMainToSearch(lat, lng);
    }
}
