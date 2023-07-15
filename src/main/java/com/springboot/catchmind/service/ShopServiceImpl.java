package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.Map;

import com.springboot.catchmind.dto.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.ShopDao;
import com.springboot.catchmind.dao.ShopPhotoDao;
import com.springboot.catchmind.vo.BookingVo;
import com.springboot.catchmind.vo.FacilityVo;
import com.springboot.catchmind.vo.SessionVo;
import com.springboot.catchmind.vo.ShopPhotoVo;
import com.springboot.catchmind.vo.ShopVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service("shopService")
public class ShopServiceImpl implements ShopService {
	
//	private ShopDao shopDao = new ShopDao();
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private ShopPhotoDao shopPhotoDao;
	
	@Override
	public int getInsert(ShopVo shopVo) {
		return shopDao.insert(shopVo);
	}
	
	@Override
	public int getDetailInsert(ShopVo shopVo) {
		return shopDao.detailInsert(shopVo);
	}
	
	@Override
	public int getDetailUpdate(ShopVo shopVo) {
		return shopDao.detailUpdate(shopVo);
	}
	
	@Override
	public int getDetailFacilityUpdate(FacilityVo facilityVo) {
		return shopDao.facilityUpdate(facilityVo);
	}
	
	@Override
	public FacilityVo getShopFacilitySelect(String sid) {
		return shopDao.facilitySelect(sid);
	}
	
	@Override
	public int getConfirmUpdate(String sid) {
		return shopDao.update(sid);
	}
	
	@Override
	public ShopVo getShopInfoSelect(String sid) {
		return shopDao.select(sid);
	}
	
	@Override
	public String getShopReservationSelectGson(Map<String, String> map) {
		ArrayList<BookingVo> list = shopDao.reservationSelect(map);
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();		
		
		for(BookingVo bookingVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rid", bookingVo.getRID());
			jobj.addProperty("rmodifydate", bookingVo.getRMODIFYDATE());
			jobj.addProperty("rmodifytime", bookingVo.getRMODIFYTIME());
			jobj.addProperty("rtabletype", bookingVo.getRTABLETYPE());
			jobj.addProperty("guestnumber", bookingVo.getGUESTNUMBER());
			jobj.addProperty("rrequest", bookingVo.getRREQUEST());
			jobj.addProperty("rphone", bookingVo.getRPHONE());
			jobj.addProperty("mid", bookingVo.getMID());
			jobj.addProperty("mname", bookingVo.getMNAME());
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		
		return new Gson().toJson(jlist);
	}
	
	@Override
	public int getPhotoSelectCheck(String sid) {
		return shopPhotoDao.selectCheck(sid);
	}
	
	@Override
	public ShopPhotoVo getShopPhotoSelect(String sid) {
		return shopPhotoDao.select(sid);
	}
	
	@Override
	public int getPhotoInsert(String sid, ShopPhotoVo shopPhotoVo) {
		return shopPhotoDao.insert(sid, shopPhotoVo);
	}
	
	@Override
	public int getPhotoUpdate(String sid, ShopPhotoVo shopPhotoVo) {
		return shopPhotoDao.update(sid, shopPhotoVo);
	}
	
	@Override
	public int getShopIdCheck(ShopVo shopVo) {
		return shopDao.shopIdCheck(shopVo);
	}
	
	@Override
	public SessionDto getShopLogin(ShopVo shopVo) {
		return shopDao.shopLogin(shopVo);
	}
	
	@Override
	public int getRegistrationCheck(ShopVo shopVo) {
		return shopDao.shopRegistrationCheck(shopVo);
	}
}
