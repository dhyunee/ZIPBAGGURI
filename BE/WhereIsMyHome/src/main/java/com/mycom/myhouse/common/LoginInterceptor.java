package com.mycom.myhouse.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mycom.myhouse.dto.UserRequestDto;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response,
			Object handler) throws Exception {

		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}
		
		HttpSession session = request.getSession();
		UserRequestDto userRequestDto = (UserRequestDto) session.getAttribute("user");
		
		if (userRequestDto == null) {			
			return false;
		}
		return true;
	}
}

