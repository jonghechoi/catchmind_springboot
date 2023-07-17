package com.springboot.catchmind.service;

import java.util.List;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.repository.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.ReviewDao;


@Service("reviewSchedulerService")
public class Scheduler {
	
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private ReviewMapper reviewMapper;

	public List<ReviewDto> reviewMainChange() {	return reviewMapper.reviewMainList(); }
}
