package com.springboot.catchmind.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.vo.MemberVo;

@Service("pagingService")
public class PagingServiceImpl implements PagingService {
	
	@Autowired 
	private NoticeServiceImpl noticeService;
	@Autowired
	private MemberServiceImpl memberService;
	@Autowired
	private ReviewServiceImpl reviewService;
	@Autowired
	private MyDiningServiceImpl myDiningService;
	@Autowired
	private MemberDao memberdao;
	
	
	// getMemberSelect(), getMemberSelect(String mid)�� �Ʒ� memberDao ��ü ���� �κ�
	// member ���񽺷� �ű�� ���⼱ ���� �ʿ�!!!
	// private MemberDao memberDao = new MemberDao();
	
	@Override
	public MemberVo getCertainMemberSelect(String mid) {

		return memberdao.select(mid);
	}
	
	@Override
	public Map<String, Integer> getPageResult(String page, String serviceName) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 5;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;
		
		if(serviceName.equals("notice")) {
			dbCount = noticeService.getTotalRowCount();
		}else if(serviceName.equals("member")) {
			dbCount = memberService.getTotalRowCount();
		}else if(serviceName.equals("review")) {
			dbCount = reviewService.getTotalRowCount();
		}
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}

		//��û ������ ���
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 5;
		}
		
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		param.put("dbCount", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		
		return param;
	}
	
	@Override
	public Map<String, String> getVisitedResult(String page, String serviceName, String mid) {
		Map<String, String> param = new HashMap<String, String>();
		
		//����¡ ó�� - startCount, endCount ���ϱ�
		int startCount = 0;
		int endCount = 0;
		int pageSize = 12;	//���������� �Խù� ��
		int reqPage = 1;	//��û������	
		int pageCount = 1;	//��ü ������ ��
		int dbCount = 0;
		
		if(serviceName.equals("visited")) {
			dbCount = myDiningService.getTotalRowCount(mid);
		}
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//��û ������ ���
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 12;
		}
		
		param.put("startCount", String.valueOf(startCount));
		param.put("endCount", String.valueOf(endCount));
		param.put("dbCount", String.valueOf(dbCount));
		param.put("pageSize", String.valueOf(pageSize));
		param.put("maxSize", String.valueOf(pageCount));
		param.put("page", String.valueOf(reqPage));
		
		return param;
	}
}
