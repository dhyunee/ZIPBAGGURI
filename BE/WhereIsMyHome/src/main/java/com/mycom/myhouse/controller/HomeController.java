package com.mycom.myhouse.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myhouse.domain.User;
import com.mycom.myhouse.dto.ResultDto;
import com.mycom.myhouse.dto.UserRequestDto;
import com.mycom.myhouse.dto.UserResponseDto;
import com.mycom.myhouse.service.UserService;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class HomeController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	// interceptor 기능을 넣으려면 session 이 정보를 가지고 있어야 하는가?
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserRequestDto loginRequestDto, HttpSession session) {
		
		User loginUser = userService.login(loginRequestDto);
		session.setAttribute("user", loginUser);
		
		if (loginUser != null) {
			UserResponseDto userResponseDto = UserResponseDto.from(loginUser);
			return new ResponseEntity<>(ResultDto.of("success", userResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<>(ResultDto.ofSuccess(), HttpStatus.OK);
	}
	
}
