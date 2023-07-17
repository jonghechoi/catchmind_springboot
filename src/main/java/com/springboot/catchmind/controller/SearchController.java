package com.springboot.catchmind.controller;

import com.springboot.catchmind.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;


//	@RequestMapping(value="/search_list_book_now_proc.do", method=RequestMethod.GET)
//	@ResponseBody
//	public String search_list_book_now_proc(String date, String location, String cuisine) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("date", date);
//		map.put("location", location);
//		map.put("cuisine", cuisine);
//		ArrayList<SearchVo> list = searchService.getBookNowSelect(map);
//
//		JsonObject jlist = new JsonObject();
//		JsonArray jarray = new JsonArray();
//
//		for(SearchVo searchVo : list) {
//			JsonObject jobj = new JsonObject();
//			jobj.addProperty("sid", searchVo.getSid());
//			jobj.addProperty("sname", searchVo.getSname());
//			jobj.addProperty("sintro", searchVo.getSintro());
//			jobj.addProperty("reviewstar", searchVo.getReviewstar());
//			jobj.addProperty("slocshort", searchVo.getSlocshort());
//			jobj.addProperty("lunch", String.valueOf(searchVo.getLunch()));
//			jobj.addProperty("dinner", searchVo.getDinner());
//			jobj.addProperty("smphoto", searchVo.getSmphoto());
//			jobj.addProperty("rtime", searchVo.getRtime());
//			jobj.addProperty("sloc", searchVo.getSloc());
//			jobj.addProperty("sfoodstyle", searchVo.getSfoodstyle());
//			jobj.addProperty("sopeninghour", searchVo.getSopeninghour());
//
//			jarray.add(jobj);
//		}
//		jlist.add("jlist", jarray);
//		return new Gson().toJson(jlist);
//	}
	
	/**
	 *  �˻�
	 */
	@GetMapping("search")
	public String search() {
		return "/search";
	}

}
