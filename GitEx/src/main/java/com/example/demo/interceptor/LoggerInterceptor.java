package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggerInterceptor implements HandlerInterceptor{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//Controller에 접근하기전에 실행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("===============================================");
		System.out.println("==================== BEGIN ====================");
		System.out.println("===============================================");
		System.out.println("Request URI ===> " + request.getRequestURI());
		return true;
//		if(request.getHeader("Authorization").equals("live")) {
//			System.out.println("=================진입 성공==================");
//			return true;
//		}else {
//			System.out.println("=================진입 실패==================");
//			return false;
//		}
	}
	
}
