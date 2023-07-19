package com.springboot.catchmind.restcontroller;

import com.springboot.catchmind.dto.SearchDto;
import com.springboot.catchmind.exception.BusinessException;
import com.springboot.catchmind.exception.CommonErrorCode;
import com.springboot.catchmind.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> search_list_book_now_proc(@PathVariable String date,
																	 @PathVariable String location,
																	 @PathVariable String cuisine) {
		if(location.equals("Location") || cuisine.equals("Cuisine")) {
			System.out.println("여기 잘 들어오고~~");
			throw new BusinessException(CommonErrorCode.INVALID_INPUT_VALUE);
		}else {
			List<SearchDto> list = searchService.getBookNowSelect(date, location, cuisine);
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
	}
//	@GetMapping("search_list_book_now_proc/{date}/{location}/{cuisine}")
//	public List<SearchDto> search_list_book_now_proc(@PathVariable String date,
//													 @PathVariable String location,
//													 @PathVariable String cuisine) {
//		return searchService.getBookNowSelect(date, location, cuisine);
//	}
}
