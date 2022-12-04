package com.mycom.myhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myhouse.domain.User;
import com.mycom.myhouse.dto.ResultDto;
import com.mycom.myhouse.dto.UserRequestDto;
import com.mycom.myhouse.dto.UserResponseDto;
import com.mycom.myhouse.service.UserService;

@RestController
public class HomeController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	// interceptor 기능을 넣으려면 session 이 정보를 가지고 있어야 하는가?
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(UserRequestDto loginRequestDto) {
		
		User loginUser = userService.login(loginRequestDto);
		
		if (loginUser != null) {
			UserResponseDto userResponseDto = UserResponseDto.from(loginUser);
			return new ResponseEntity<>(ResultDto.of("success", userResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
}
