package com.springboot.catchmind.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.ShopDao;
import com.springboot.catchmind.vo.SearchVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service("mapService")
public class MapServiceImpl {
	
	@Autowired
	private ShopDao shopDao;
	private final double EARTH_RADIUS = 6371.0; // ������ ������ (����: km)
	
	public String mapMainToSearch(double lat, double lng) {
		ArrayList<SearchVo> allShopList =  shopDao.mapSelect();
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();
		
 		for(SearchVo searchVo : allShopList) {
			// �˻� ����: lat, �浵, lng / shop ����:slocy, �浵:slocx / ȯ����� km
			double distance = calculateDistance(lat, lng, Double.parseDouble(searchVo.getSlocy()), Double.parseDouble(searchVo.getSlocx()));
			if(distance <= 10) {
				JsonObject jobj = new JsonObject();   
				jobj.addProperty("sid", searchVo.getSid()); 
				jobj.addProperty("sname", searchVo.getSname()); 
				jobj.addProperty("sintro", searchVo.getSintro());
				jobj.addProperty("reviewstar", searchVo.getReviewstar());
				jobj.addProperty("slocshort", searchVo.getSlocshort());
				jobj.addProperty("lunch", searchVo.getLunch());
				jobj.addProperty("dinner", searchVo.getDinner());
				jobj.addProperty("smphoto", searchVo.getSmphoto());
				jobj.addProperty("rtime", searchVo.getRtime());
				jobj.addProperty("sloc", searchVo.getSloc());
				jobj.addProperty("sfoodstyle", searchVo.getSfoodstyle());
				jobj.addProperty("sopeninghour", searchVo.getSopeninghour());
				
				jarray.add(jobj);
			}
		}
 		
 		jlist.add("jlist", jarray);
		return new Gson().toJson(jlist);
	}
	
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS * c;
        return distance;
    }
}
