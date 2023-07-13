package com.springboot.catchmind.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.springboot.catchmind.service.FileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.service.ReviewService;
import com.springboot.catchmind.vo.ReviewVo;

@Controller
@Slf4j
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@Autowired
	private FileServiceImpl fileService;
	/**
	 * write_review_proc
	 */
	@PostMapping("write_review")
	public String write_review_proc(ReviewVo reviewVo, RedirectAttributes redirectAttributes) throws Exception{

		reviewVo = (ReviewVo)fileService.fileCheck(reviewVo);

		int result = reviewService.getWriteReview(reviewVo);
		int reviewYN = reviewService.getUpdateReviewYN(reviewVo.getRid());

		if (result == 1) {
			if(reviewYN == 1) {
				fileService.fileSave(reviewVo);
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
	@GetMapping("write_review")
	public String write_review(String rid, Model model) {
		ReviewVo reviewVo = reviewService.getReviewSelect(rid);
		model.addAttribute("reviewVo", reviewVo);

		return "/pages/mydining/write_review";
	}
}
