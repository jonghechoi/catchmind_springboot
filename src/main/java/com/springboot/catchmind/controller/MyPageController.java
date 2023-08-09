package com.springboot.catchmind.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.catchmind.dto.FavoritesDto;
import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.vo.MemberVo;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MyPageController {
	@Autowired
	private ReviewServiceImpl reviewService;
	@Autowired
	private FavoritesServiceImpl favoritesService;
	@Autowired
	private MemberServiceImpl memberService;


	//	@PostMapping("/update_review/{reviewId}")
//	public String updateReview(@PathVariable Long reviewId, @ModelAttribute ReviewDto updatedReviewDto) {
//		reviewService.updateReview(reviewId, updatedReviewDto);
//		return "redirect:/view_review/{reviewId}";
//	}

//	@PostMapping("/update_review")
//	public String updateReview(@ModelAttribute ReviewDto updatedReviewDto) {
//		reviewService.updateReview(updatedReviewDto.getReviewId(), updatedReviewDto);
//		return "redirect:/view_review/" + updatedReviewDto.getReviewId();
//	}

	//	@PostMapping("/update_review/{reviewId}")
//	public String updateReview(@PathVariable Long reviewId, @ModelAttribute ReviewDto updatedReviewDto) {
//		reviewService.updateReview(reviewId, updatedReviewDto);
//		return "redirect:/view_review/" + reviewId;
//	}


	/**
	 * 리뷰 업데이트
	 */
	@GetMapping("/write_review")
	public String showEditReviewForm(@RequestParam String reviewId, Model model) {
		Long reviewIdLong = Long.parseLong(reviewId.substring(2));
		ReviewDto reviewDto = reviewService.getReviewById(reviewIdLong);
		model.addAttribute("reviewVo", reviewDto);
		return "pages/mypage/mypage_review";
	}

	@PostMapping("/update_review/{reviewId}")
	public String updateReview(@PathVariable Long reviewId, @ModelAttribute ReviewDto updatedReviewDto, Model model) {
		reviewService.updateReview(reviewId, updatedReviewDto);
		ReviewDto updatedReview = reviewService.getReviewById(reviewId);
		model.addAttribute("updatedReview", updatedReview);

		return "redirect:/view_review/" + reviewId; // view_review 페이지로 리디렉션
	}

	/**
	 * bookmark_delete_proc
	 */
	@GetMapping("bookmark_delete_proc/{fid}/{mid}/")
	public String bookmarkDeleteProc(@PathVariable String fid,@PathVariable String mid) {
		String viewName = "";
		int result = favoritesService.deleteFavorites(fid);
		if (result == 1) {
			viewName = "redirect:/mypage_favorites/" + mid;
		}
		return viewName;
	}


	/**
	 * mypage
	 */
	@GetMapping("mypage")
	public String mypage(HttpSession session, Model model) {
		SessionDto sessionVo = (SessionDto) session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();

		List<MemberDto> memberList = memberService.selectBy(mid);

		model.addAttribute("memberList", memberList);
		//model.addObject("mid", mid);
		//model.setViewName("mypage");

		return "/mypage";
	}

	/**
	 * mypage_favorites
	 */
	@GetMapping("mypage_favorites/{mid}")
	public String mypage_Favorites(@PathVariable String mid, Model model) {
		//ModelAndView model = new ModelAndView();
		List<FavoritesDto> favoritesList = favoritesService.select(mid);
		model.addAttribute("favoritesList", favoritesList);
		model.addAttribute("mid", mid);
		//model.addObject("mid", mid);
		//model.setViewName("/pages/mypage/mypage_favorites");
		return "/pages/mypage/mypage_favorites";
	}

	/**
	 * mypage_review
	 */
	@GetMapping("mypage_review/{mid}")
	public String mypage_Review(HttpSession session, Model model) {
		SessionDto sessionVo = (SessionDto) session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		List<ReviewDto> reviewList = reviewService.SelectBy(mid);
		model.addAttribute("reviewList", reviewList);
		//model.addAttribute("mid", mid);
		//model.addAttribute("sid", sid);
		return "/pages/mypage/mypage_review";
	}

}

	
	