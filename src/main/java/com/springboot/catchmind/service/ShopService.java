package com.springboot.catchmind.service;

import java.util.Map;


import com.springboot.catchmind.dto.FacilityDto;
import com.springboot.catchmind.dto.ShopDto;
import com.springboot.catchmind.dto.ShopPhotoDto;
import com.springboot.catchmind.vo.FacilityVo;
import com.springboot.catchmind.vo.SessionVo;
import com.springboot.catchmind.vo.ShopPhotoVo;
import com.springboot.catchmind.vo.ShopVo;

public interface ShopService {

		public int getInsert(ShopDto shopDto);
		
		public int getDetailInsert(ShopVo shopVo);
		
		public int getDetailUpdate(ShopVo shopVo);
		
		public int getDetailFacilityUpdate(FacilityVo facilityVo);
		
		public FacilityDto getShopFacilitySelect(String sid);
		
		public int getConfirmUpdate(String sid);
		
		public ShopDto getShopInfoSelect(String sid);
		
		public String getShopReservationSelectGson(Map<String, String> map);
		
		public int getPhotoSelectCheck(String sid);
		
		public ShopPhotoDto getShopPhotoSelect(String sid);
		
		public int getPhotoInsert(String sid, ShopPhotoDto shopPhotoDto);
		
		public int getPhotoUpdate(String sid, ShopPhotoDto shopPhotoDto);
		
		public int getShopIdCheck(ShopVo shopVo);
		
		public SessionVo getShopLogin(ShopVo shopVo);
		
		public int getRegistrationCheck(ShopVo shopVo);
}
