package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SearchRestController {

	@Autowired
	SearchService searchService;
	private String searchValue;

	@GetMapping("search_list_proc/{searchQuery}")
	public List<SearchDto> search_list_proc(@PathVariable String searchQuery) {
		return searchService.select(searchQuery);
	}

	@GetMapping("search_list_book_now_proc/{date}/{location}/{cuisine}")
	public List<SearchDto> search_list_book_now_proc(@PathVariable String date,
											@PathVariable String location,
											@PathVariable String cuisine) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("date", date);
		map.put("location", location);
		map.put("cuisine", cuisine);
		return searchService.getBookNowSelect(map);
	}
}
