package com.springboot.catchmind.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SearchController {
private final SearchService searchService;

@Autowired
public SearchController(SearchService searchService) {
		this.searchService = searchService;
		}

@GetMapping("/api/search_list_proc")
public ResponseEntity<JsonArray> getSearchResults(@RequestParam("searchQuery") String searchQuery) {
		ArrayList<SearchDto> list = searchService.getSelect(searchQuery);

		JsonArray jarray = new JsonArray();

		for (SearchDto searchDto : list) {
		JsonObject jobj = new JsonObject();
		jobj.addProperty("sid", searchDto.getSid());
		jobj.addProperty("sname", searchDto.getSname());
		jobj.addProperty("sintro", searchDto.getSintro());
		jobj.addProperty("reviewstar", searchDto.getReviewstar());
		jobj.addProperty("slocshort", searchDto.getSlocshort());
		jobj.addProperty("lunch", String.valueOf(searchDto.getLunch()));
		jobj.addProperty("dinner", searchDto.getDinner());
		jobj.addProperty("smphoto", searchDto.getSmphoto());
		jobj.addProperty("rtime", searchDto.getRtime());
		jobj.addProperty("sloc", searchDto.getSloc());
		jobj.addProperty("sfoodstyle", searchDto.getSfoodstyle());
		jobj.addProperty("sopeninghour", searchDto.getSopeninghour());

		jarray.add(jobj);
		}

		return new ResponseEntity<>(jarray, HttpStatus.OK);
		}


	@RequestMapping(value="/search_list_book_now_proc.do", method=RequestMethod.GET)
	@ResponseBody
	public String search_list_book_now_proc(String date, String location, String cuisine) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		map.put("location", location);
		map.put("cuisine", cuisine);
		ArrayList<SearchVo> list = searchService.getBookNowSelect(map);
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
		for(SearchVo searchVo : list) {
			JsonObject jobj = new JsonObject();   
			jobj.addProperty("sid", searchVo.getSid()); 
			jobj.addProperty("sname", searchVo.getSname()); 
			jobj.addProperty("sintro", searchVo.getSintro());
			jobj.addProperty("reviewstar", searchVo.getReviewstar());
			jobj.addProperty("slocshort", searchVo.getSlocshort());
			jobj.addProperty("lunch", String.valueOf(searchVo.getLunch()));
			jobj.addProperty("dinner", searchVo.getDinner());
			jobj.addProperty("smphoto", searchVo.getSmphoto());
			jobj.addProperty("rtime", searchVo.getRtime());
			jobj.addProperty("sloc", searchVo.getSloc());
			jobj.addProperty("sfoodstyle", searchVo.getSfoodstyle());
			jobj.addProperty("sopeninghour", searchVo.getSopeninghour());
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		return new Gson().toJson(jlist);
	}
	
	/**
	 *  �˻�
	 */
	@RequestMapping(value="search.do", method=RequestMethod.GET)
	public String search() {
		return "/search";
	}

}
