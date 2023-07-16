package com.springboot.catchmind.controller;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.service.FileServiceImpl;
import com.springboot.catchmind.service.ReviewServiceImpl;
import com.springboot.catchmind.vo.ReviewVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class ReviewController {
	@Autowired
	private ReviewServiceImpl reviewService;

	@Autowired
	private FileServiceImpl fileService;
	/**
	 * write_review_proc
	 */
	@PostMapping("write_review")
	public String write_review_proc(ReviewDto reviewDto, RedirectAttributes redirectAttributes) throws Exception{

		reviewDto = (ReviewDto)fileService.fileCheck(reviewDto);

		int result = reviewService.getWriteReview(reviewDto);
		int reviewYN = reviewService.getUpdateReviewYN(reviewDto.getRid());

		if (result == 1) {
			if(reviewYN == 1) {
				fileService.fileSave(reviewDto);
				redirectAttributes.addFlashAttribute("reviewWrite", "ok");
				return "redirect:/mydining_visited";
			}
		}else {
			
		}

		return "redirect:/mydining_visited";
	}
	
	/**
	 *  write_review.do
	 */
	@GetMapping("write_review/{rid}")
	public String write_review(@PathVariable String rid, Model model) {
		ReviewDto reviewDto = reviewService.getReviewSelect(rid);
		model.addAttribute("reviewVo", reviewDto);

		return "/pages/mydining/write_review";
	}
}
