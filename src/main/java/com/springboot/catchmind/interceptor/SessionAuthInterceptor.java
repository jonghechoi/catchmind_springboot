package com.springboot.catchmind.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springboot.catchmind.vo.SessionVo;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		//Ŭ���̾�Ʈ(������)�� ��û Ȯ�� - ���� ��ü ��������
		HttpSession session = request.getSession();
		
		//�α��ο� ������ mid Ȯ���ϱ�
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");
		if(sessionVo == null) {
			//�α����� �ȵǾ� �ִ� �����̹Ƿ� �α��������� ����
			response.sendRedirect("/login");
			return false;
		}
		
		return true;
	}
}
