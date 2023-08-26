package com.springboot.catchmind.interceptor;

import com.springboot.catchmind.dto.SessionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Slf4j
public class SessionAuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		SessionDto sessionVo = (SessionDto)session.getAttribute("sessionVo");

		if(sessionVo == null) {
			response.sendRedirect("/login");
			return false;
		}

		log.debug("===============================================");
		log.debug("==================== BEGIN ====================");
		log.debug("Request URI ===> " + request.getRequestURI());

		return HandlerInterceptor.super.preHandle(request, response, handler);
		//return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.debug("==================== END ======================");
		log.debug("===============================================");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
