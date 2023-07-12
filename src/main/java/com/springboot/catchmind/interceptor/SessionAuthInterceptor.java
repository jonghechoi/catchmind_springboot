package com.springboot.catchmind.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.springboot.catchmind.vo.SessionVo;
@Slf4j
public class SessionAuthInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		
		HttpSession session = request.getSession();
		
		SessionVo sessionVo = (SessionVo)session.getAttribute("sessionVo");

		if(sessionVo == null) {
			response.sendRedirect("/login");
			return false;
		}
		
		return true;
	}
}
