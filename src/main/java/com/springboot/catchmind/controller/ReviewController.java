package com.springboot.catchmind.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.service.ReviewService;
import com.springboot.catchmind.vo.ReviewVo;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	/**
	 * write_review_proc.do
	 */
	@RequestMapping(value = "write_review_proc.do", method = RequestMethod.POST)
	public String write_review_proc(ReviewVo reviewVo, HttpServletRequest request, 
											RedirectAttributes redirectAttributes)
											throws Exception{
		String viewName = "";
		
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
		
		if(reviewVo.getReviewfile1().getOriginalFilename() != null
				&& !reviewVo.getReviewfile1().getOriginalFilename().equals("")) {
			
			UUID uuid = UUID.randomUUID();
			String reviewphoto = reviewVo.getReviewfile1().getOriginalFilename();
			String reviewsphoto = uuid +"_"+ reviewphoto;
			
			reviewVo.setReviewphoto(reviewphoto);
			reviewVo.setReviewsphoto(reviewsphoto);
		}else {
			System.out.println("���Ͼ���");
		}
		
		int result = reviewService.getWriteReview(reviewVo);
		int reviewYN = reviewService.getUpdateReviewYN(reviewVo.getRid());

		if (result == 1) {
			if(reviewYN == 1) {
				File saveFile = new File(root_path + attach_path + reviewVo.getReviewsphoto());
				reviewVo.getReviewfile1().transferTo(saveFile);
				
				redirectAttributes.addFlashAttribute("reviewWrite", "ok");
				return "redirect:/mydining_visited.do";
			}
		}else {
			
		}

		return viewName;
	}
	
	/**
	 *  write_review.do
	 */
	@RequestMapping(value = "/write_review.do", method = RequestMethod.GET)
	public ModelAndView write_review(String rid) {
		ModelAndView model = new ModelAndView();
		
		ReviewVo reviewVo = reviewService.getReviewSelect(rid);
		
		model.addObject("reviewVo", reviewVo);
		model.setViewName("pages/mydining/write_review");
		
		return model;
	}
}
