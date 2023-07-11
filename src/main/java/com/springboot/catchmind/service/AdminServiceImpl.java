package com.springboot.catchmind.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.AdminDao;
import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.dao.NoticeDao;
import com.springboot.catchmind.dao.ReviewDao;
import com.springboot.catchmind.dao.ShopDao;
import com.springboot.catchmind.vo.MemberVo;
import com.springboot.catchmind.vo.NoticeVo;
import com.springboot.catchmind.vo.ReviewVo;
import com.springboot.catchmind.vo.ShopVo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private PagingServiceImpl pagingService;
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ReviewDao reviewDao;	
	
	@Override
	public String getNoticeSelectGson(String page) {
		System.out.println("getNoticeSelectGson page ----> " +  page);
		Map<String, Integer> param = (HashMap<String, Integer>)pagingService.getPageResult(page, "notice");
		ArrayList<NoticeVo> list = noticeDao.select(param.get("startCount"), param.get("endCount"));
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();		
		
		for(NoticeVo noticeVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", noticeVo.getRno());
			jobj.addProperty("ntitle", noticeVo.getNtitle());
			jobj.addProperty("nhits", noticeVo.getNhits());
			jobj.addProperty("ncreatedate", noticeVo.getNcreatedate());
			jobj.addProperty("nid", noticeVo.getNid());
			
			jarray.add(jobj);
		}
		
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("dbCount"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("page", param.get("page"));	
		
		return new Gson().toJson(jlist);		
	}

	@Override
	public MemberVo getCertainMemberSelect(String mid) { return memberDao.select(mid); }

	@Override
	public String getMemberSelectGson(String page) {
		Map<String, Integer> param = (HashMap<String, Integer>)pagingService.getPageResult(page, "member");
		ArrayList<MemberVo> list = memberDao.select(param.get("startCount"), param.get("endCount"));
		
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();			
		
		for(MemberVo memberVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", memberVo.getRno());
			jobj.addProperty("mid", memberVo.getMid());
			jobj.addProperty("mname", memberVo.getMname()); 
			jobj.addProperty("memberid", memberVo.getMemberId());
			jobj.addProperty("memail", memberVo.getMemailAdmin());
			jobj.addProperty("mphone", memberVo.getMphoneAdmin());
			
			jarray.add(jobj);
		}
		
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("dbCount"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("page", param.get("page"));	
		
		return new Gson().toJson(jlist);		
	}
	
	@Override
	public NoticeVo getNoticeSelect(String nid) {
		return noticeDao.select(nid);
	}
	
	@Override
	public int getNoticeUpdate(NoticeVo noticeVo) {
		return noticeDao.update(noticeVo);
	}
	
	@Override
	public int getNoticeDelete(String nid) {
		return noticeDao.delete(nid);
	}
	
	@Override
	public String getShopSelectGson(boolean sconfirm, boolean aconfirmfinal) {
		ArrayList<ShopVo> list = shopDao.select(sconfirm, aconfirmfinal);
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();			
		
		for(ShopVo shopVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("sid", shopVo.getSid());
			jobj.addProperty("roleid", shopVo.getRoleid());
			jobj.addProperty("screatedate", shopVo.getScreatedate());
			jobj.addProperty("aconfirmyn", shopVo.getAconfirmyn());
			jobj.addProperty("sconfirmyn", shopVo.getSconfirmyn());
			jobj.addProperty("spass", shopVo.getSpass());
			jobj.addProperty("sname", shopVo.getSname());
			jobj.addProperty("sphone", shopVo.getSphone());
			jobj.addProperty("sloc", shopVo.getSloc());
			jobj.addProperty("slocshort", shopVo.getSlocshort());
			jobj.addProperty("sintro", shopVo.getSintro());
			jobj.addProperty("smodifydate", shopVo.getSmodifydate());
			jobj.addProperty("sopeninghour", shopVo.getSopeninghour());
			jobj.addProperty("sclosinghour", shopVo.getSclosinghour());
			jobj.addProperty("sclosingdate", shopVo.getSclosingdate());
			jobj.addProperty("sdeposit", shopVo.getSdeposit());
			jobj.addProperty("smealfee", shopVo.getSmealfee());
			jobj.addProperty("lunch", shopVo.getLunch());
			jobj.addProperty("dinner", shopVo.getDinner());
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		
		return new Gson().toJson(jlist);
	}
	
	@Override
	public int getConfirmUpdate(String sid) {
		return adminDao.update(sid);
	}
	
	@Override
	public int getCancelUpdate(String sid) {
		return adminDao.cancel(sid);
	}
	
	@Override
	public String getReviewSelectGson(String page) {
		Map<String, Integer> param = (HashMap<String, Integer>)pagingService.getPageResult(page, "review");
		ArrayList<ReviewVo> list = reviewDao.select(param.get("startCount"), param.get("endCount"));
		JsonObject jlist = new JsonObject();
		JsonArray jarray = new JsonArray();			
		
		for(ReviewVo ReviewVo : list) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("rno", ReviewVo.getRno());
			jobj.addProperty("mname", ReviewVo.getMname());
			jobj.addProperty("sid", ReviewVo.getSid());
			jobj.addProperty("reviewcontent", ReviewVo.getReviewcontent());
			jobj.addProperty("reviewstar", ReviewVo.getReviewstar());
			jobj.addProperty("reviewcreatedate", ReviewVo.getReviewcreatedate());
			jobj.addProperty("rid", ReviewVo.getRid());
			
			jarray.add(jobj);
		}
		jlist.add("jlist", jarray);
		jlist.addProperty("totals", param.get("dbCount"));
		jlist.addProperty("maxSize", param.get("maxSize"));
		jlist.addProperty("pageSize", param.get("pageSize"));
		jlist.addProperty("page", param.get("page"));	
		
		return new Gson().toJson(jlist);		
	}
	
	@Override
	public String getReviewDetailSelectGson(String rid) {
		ReviewVo reviewVo = reviewDao.selectRid(rid);
		JsonObject jobj = new JsonObject();
		jobj.addProperty("reviewid", reviewVo.getReviewid());
		jobj.addProperty("reviewcontent", reviewVo.getReviewcontent());
		jobj.addProperty("reviewcreatedate", reviewVo.getReviewcreatedate());
		jobj.addProperty("reviewmodifydate", reviewVo.getReviewmodifydate());
		jobj.addProperty("sid", reviewVo.getSid());
		jobj.addProperty("mid", reviewVo.getMid());
		jobj.addProperty("rid", reviewVo.getRid());
		jobj.addProperty("reviewphoto", reviewVo.getReviewphoto());
		jobj.addProperty("mname", reviewVo.getMname());
		jobj.addProperty("rno", reviewVo.getRno());
		jobj.addProperty("reviewstar", reviewVo.getReviewstar());
		//return jobj;
		return new Gson().toJson(jobj);
	}
	
	@Override
	public int getReviewMainUpdate(String rid) {
		return reviewDao.updateToMain(rid);
	}
	
	@Override
	public ArrayList<ReviewVo> getReviewMainList() {
		return reviewDao.reviewMainList();
	}
	
	@Override
	public int getReviewMainDelete(String rid) {
		return reviewDao.deleteFromMain(rid);
	}
	
}
