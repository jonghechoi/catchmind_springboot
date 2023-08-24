package com.springboot.catchmind.service;

import java.util.List;
import java.util.Map;


import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.dto.BookingDto;
import com.springboot.catchmind.dto.FacilityDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.dto.ShopPhotoDto;

public interface ShopService {

		public int getInsert(ShopDto shopDto);
		
		public int getDetailInsert(ShopDto shopDto);
		
		public int getDetailUpdate(ShopDto shopDto);
		
		public int getDetailFacilityUpdate(FacilityDto facilityDto);
		
		public FacilityDto getShopFacilitySelect(String sid);
		
//		public int getConfirmUpdate(String sid);
		
		public ShopDto getShopInfoSelect(String sid);
		
		public List<BookingDto> getShopReservationSelectJson(String sid, String startDate, String endDate);
		
		public int getPhotoSelectCheck(String sid);
		
		public ShopPhotoDto getShopPhotoSelect(String sid);
		
		public int getPhotoInsert(String sid, ShopPhotoDto shopPhotoDto);
		
		public int getPhotoUpdate(String sid, ShopPhotoDto shopPhotoDto);
		
		public int getShopIdCheck(ShopDto shopDto);
		
		public SessionDto getShopLogin(ShopDto shopDto);
		
		public int getRegistrationCheck(ShopDto shopDto);

		public void dateCheck(String startDate, String endDate) throws Exception;
}
