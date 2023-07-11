package com.springboot.catchmind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springboot.catchmind.dao.MyDiningDao;

@Component
public class SchedulerService {
	@Autowired
	MyDiningDao myDiningDao;
	
	/**
	 * ���� ����  RSTATUS ������Ʈ
	 */
	@Scheduled(cron = "0 0 0 * * *")
	public void autoUpdate() {
		myDiningDao.updateStatus();
	}
}
