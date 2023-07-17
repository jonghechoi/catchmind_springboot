package com.springboot.catchmind.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.catchmind.dao.FavoritesDao;
import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.vo.FavoritesVo;
import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.ReviewVo;
import com.springboot.catchmind.vo.SessionVo;


@Controller
public class MyPageController {
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private FavoritesDao favoritesDao;
	@Autowired
	private MemberDao memberDao;
	/**
	 * mypage
	 */

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) {
		ModelAndView model = new ModelAndView();
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		String mid = sessionVo.getMid();
		MemberVo memberList = memberDao.nameSelect(mid);

		model.addObject("memberList", memberList);
		model.addObject("mid", mid);
        model.setViewName("mypage");

        return model;
	}
	
	/**
	 *  mypage_favorites
	 */
	@RequestMapping(value = "/mypage_favorites", method = RequestMethod.GET)
	public ModelAndView mypage_favorites(String mid) {
		ModelAndView model = new ModelAndView();
		ArrayList<FavoritesVo> favoritesList = favoritesDao.select(mid);


        model.addObject("favoritesList", favoritesList);
        model.addObject("mid", mid);
        model.setViewName("mypage_favorites");

        return model;
	}
	
	/**
	 * bookmark_delete_proc
	 */
	@RequestMapping(value = "/bookmark_delete_proc", method = RequestMethod.GET)
	public String bookmark_delete_proc(String fid, String mid) {
		
		String viewName = "";
		int result = favoritesDao.deleteFavorites(fid);
		if(result == 1) {
			viewName = "redirect:/mypage_favorites?mid="+mid;
		}
        return viewName;  
	}

	/** 
	 * mypage_review
	 */
	@RequestMapping(value = "/mypage_review", method = RequestMethod.GET)
	public ModelAndView mypage_review(String mid, String sid) {
		ModelAndView model = new ModelAndView();
		ArrayList<ReviewVo> reviewList = reviewDao.selectMid(mid);
        model.addObject("reviewList", reviewList);
        model.addObject("mid", mid);
        model.setViewName("/mypage_review");
        
        return model;
	}


//	@GetMapping("mypage")
//	public String mypage(){
//		return "/mypage/mypage";
//	}
//
//	@GetMapping("mypage_favorites")
//	public String mypage_favorites(){
//		return "mypage_favorites/mypage_favorites";
//	}
//
//	@GetMapping("mypage_review")
//	public String mypage_review(){
//		return "mypage_review/mypage_review";
//	}
}

	
	