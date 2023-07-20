package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.exception.BusinessException;
import com.springboot.catchmind.exception.CommonErrorCode;
import com.springboot.catchmind.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchRestController {

	@Autowired
	SearchService searchService;

	@GetMapping("search_list_proc/{searchQuery}")
	public List<SearchDto> search_list_proc(@PathVariable String searchQuery) {
		return searchService.select(searchQuery);
	}

	@PostMapping("search_list_book_now_proc")
	public ResponseEntity<?> search_list_book_now_proc(@RequestParam String date,
				                                       @RequestParam String location,
				                                       @RequestParam String cuisine) {
		if(location.equals("Location") || cuisine.equals("Cuisine")) {
			throw new BusinessException(CommonErrorCode.INVALID_INPUT_VALUE);
		}else {
			Map<String, String> map = new HashMap<String, String>();
			map.put("date", date);
			map.put("location", location);
			map.put("cuisine", cuisine);
			List<SearchDto> list = searchService.getBookNowSelect(map);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}
}
