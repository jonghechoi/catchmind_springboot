package com.springboot.catchmind.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.springboot.catchmind.dto.MemberDto;
import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.service.FavoritesServiceImpl;
import com.springboot.catchmind.service.MemberServiceImpl;
import com.springboot.catchmind.service.MyDiningServiceImpl;
import com.springboot.catchmind.service.ReviewServiceImpl;
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

	/**
	 * 리뷰 업데이트
	 */
//	@GetMapping("/edit/{reviewId}")
//	public String showEditReviewForm(@PathVariable Long reviewId, Model model) {
//		// 리뷰 정보를 데이터베이스에서 가져와서 model에 추가
//		ReviewDto reviewDto = reviewService.getReviewById(reviewId);
//		model.addAttribute("reviewDto", reviewDto);
//		return "/mypage_review"; // 리뷰 수정 폼을 보여주는 JSP 페이지로 이동
//	}
	@PostMapping("/review/update/{reviewId}")
	public String 리뷰업데이트(
			@PathVariable String reviewId,
			@RequestParam String reviewContent,
			@RequestParam int reviewStar
	) {
		int 결과 = reviewService.updateReview(reviewId, reviewContent, reviewStar);
		if (결과 == 1) {
			// 리뷰가 성공적으로 업데이트된 경우, 리뷰 목록 또는 리뷰 상세 페이지로 리다이렉트합니다.
			// 애플리케이션 디자인에 따라 리다이렉트할 페이지를 결정할 수 있습니다.
			return "redirect:/mypage_review/{mid}";
		} else {
			// 업데이트가 실패한 경우, 에러를 처리합니다. (예: 에러 페이지로 리다이렉트하거나 에러 메시지를 표시합니다.)
			return "redirect:/mypage";
		}
	}

}

	
	