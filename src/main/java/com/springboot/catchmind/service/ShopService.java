package com.springboot.catchmind.service;

import java.util.Map;


import com.springboot.catchmind.dto.SessionDto;
import com.springboot.catchmind.vo.FacilityVo;
import com.springboot.catchmind.vo.SessionVo;
import com.springboot.catchmind.vo.ShopPhotoVo;
import com.springboot.catchmind.vo.ShopVo;

public interface ShopService {

		public int getInsert(ShopVo shopVo);
		
		public int getDetailInsert(ShopVo shopVo);
		
		public int getDetailUpdate(ShopVo shopVo);
		
		public int getDetailFacilityUpdate(FacilityVo facilityVo);
		
		public FacilityVo getShopFacilitySelect(String sid);
		
		public int getConfirmUpdate(String sid);
		
		public ShopVo getShopInfoSelect(String sid);
		
		public String getShopReservationSelectGson(Map<String, String> map);
		
		public int getPhotoSelectCheck(String sid);
		
		public ShopPhotoVo getShopPhotoSelect(String sid);
		
		public int getPhotoInsert(String sid, ShopPhotoVo shopPhotoVo);
		
		public int getPhotoUpdate(String sid, ShopPhotoVo shopPhotoVo);
		
		public int getShopIdCheck(ShopVo shopVo);
		
		public SessionDto getShopLogin(ShopVo shopVo);
		
		public int getRegistrationCheck(ShopVo shopVo);
}
