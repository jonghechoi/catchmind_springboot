package com.springboot.catchmind.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.springboot.catchmind.dto.ReviewDto;
import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.service.FavoritesServiceImpl;
import com.springboot.catchmind.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.catchmind.dto.FavoritesDto;
import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.vo.MemberVo;


@Controller
public class MyPageController {
	@Autowired
	private ReviewServiceImpl reviewService;
	@Autowired
	private FavoritesServiceImpl favoritesService;
	@Autowired
	private MemberDao memberDao;
	/**
	 * mypage
	 */

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) {
		ModelAndView model = new ModelAndView();
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		MemberVo memberList = memberDao.nameSelect(mid);

		model.addObject("memberList", memberList);
		model.addObject("mid", mid);
        model.setViewName("mypage");

        return model;
	}
	
	/**
	 * bookmark_delete_proc
	 */
	@RequestMapping(value = "/bookmark_delete_proc", method = RequestMethod.GET)
	public String bookmark_delete_proc(String fid, String mid) {
		
		String viewName = "";
		int result = favoritesService.deleteFavorites(fid);
		if(result == 1) {
			viewName = "redirect:/mypage_favorites?mid="+mid;
		}
        return viewName;  
	}

	/**
	 * mypage_review
	 */
//	@RequestMapping(value = "/mypage_review", method = RequestMethod.GET)
//	public ModelAndView mypage_review(String mid, String sid) {
//		ModelAndView model = new ModelAndView();
//		ArrayList<ReviewVo> reviewList = reviewDao.selectMid(mid);
//        model.addObject("reviewList", reviewList);
//        model.addObject("mid", mid);
//        model.setViewName("pages/mypage/mypage_review");
//
//        return model;
//	}


//	@GetMapping("mypage")
//	public String mypage(){
//		ModelAndView model = new ModelAndView();
//		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");
//		String mid = sessionVo.getMid();
//		MemberVo memberList = memberDao.nameSelect(mid);
//
//		model.addObject("memberList", memberList);
//		model.addObject("mid", mid);
//        model.setViewName("mypage");
//
//        return model;
//	}

	/**
	 *  mypage_favorites
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

	@GetMapping("mypage_review/{mid},{sid}")
	public String mypage_Review(@PathVariable String mid, @PathVariable String sid, Model model) {
		//ModelAndView model = new ModelAndView();
		List<ReviewDto> reviewList = reviewService.Select(mid);

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("mid", mid);
		//model.setViewName("/pages/mypage/mypage_review");

		return "/pages/mypage/mypage_review";
	}

//	@GetMapping("/mypage_review")
//	public ModelAndView mypageReview(@RequestParam("mid") String mid, @RequestParam("sid") String sid) {
//		ModelAndView model = new ModelAndView();
//		ArrayList<ReviewDto> reviewList = reviewService.getReviewSelect(mid);
//
//		model.addObject("reviewList", reviewList);
//		model.addObject("mid", mid);
//		model.setViewName("pages/mypage/mypage_review");
//
//		return model;
//	}

}

	
	