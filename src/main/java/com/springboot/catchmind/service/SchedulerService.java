package com.springboot.catchmind.service;

import com.springboot.catchmind.repository.MyDiningMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {
	@Autowired
	MyDiningMapper myDiningMapper;
	
	/**
	 * ���� ����  RSTATUS ������Ʈ
	 */
	@Scheduled(cron = "0 0 0 * * *")
	public void autoUpdate() {
		myDiningMapper.updateStatus();
	}
}
