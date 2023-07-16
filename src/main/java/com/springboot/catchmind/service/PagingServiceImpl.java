package com.springboot.catchmind.service;

import com.springboot.catchmind.dao.MemberDao;
import com.springboot.catchmind.dto.PageDto;
import com.springboot.catchmind.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
//			dbCount = reviewService.getTotalRowCount();
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
	public PageDto getVisitedResult(PageDto pageDto) {

		int startCount = 0;
		int endCount = 0;
		int pageSize = 12;
		int reqPage = 1;
		int pageCount = 1;
		int dbCount = 0;
		
		if(pageDto.getServiceName().equals("visited")) {
			dbCount = myDiningService.getTotalRowCount(pageDto.getMid());
		}
		
		//�� ������ �� ���
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}
		
		//��û ������ ���
		if(pageDto.getPage() != null){
			reqPage = Integer.parseInt(pageDto.getPage());
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = 12;
		}

		pageDto.setStartCount(startCount);
		pageDto.setEndCount(endCount);
		pageDto.setDbCount(dbCount);
		pageDto.setPageSize(pageSize);
		pageDto.setPageCount(pageCount);
		pageDto.setRegPage(reqPage);
		
		return pageDto;
	}
}
