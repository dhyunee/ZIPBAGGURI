package com.mycom.myhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myhouse.domain.User;
import com.mycom.myhouse.dto.ResultDto;
import com.mycom.myhouse.dto.UserRequestDto;
import com.mycom.myhouse.dto.UserResponseDto;
import com.mycom.myhouse.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	private final int SUCCESS = 1;
	
	@PostMapping("/users")
	public ResponseEntity<?> insertUser(UserRequestDto userRequestDto) {
		User savedUser = userService.insertUser(userRequestDto);
		
		if (savedUser != null) {
			UserResponseDto userResponseDto = UserResponseDto.from(savedUser);
			return new ResponseEntity<>(ResultDto.of("success", userResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/users/{userSeq}")
	private ResponseEntity<?> updateUser(UserRequestDto userRequestDto) {
		User updatedUser = userService.updateUser(userRequestDto);
		
		if (updatedUser != null) {
			UserResponseDto userResponseDto = UserResponseDto.from(updatedUser);
			return new ResponseEntity<>(ResultDto.of("success", userResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/users/{userSeq}")
	private ResponseEntity<?> deleteUser(@PathVariable int userSeq) {
		int result = userService.deleteUser(userSeq);
		
		if (result == SUCCESS) {
			return new ResponseEntity<>(ResultDto.ofSuccess(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{userSeq}")
	private ResponseEntity<?> getUser(@PathVariable int userSeq) {
		User user = userService.getUser(userSeq);
		
		if (user != null) {
			UserResponseDto userResponseDto = UserResponseDto.from(user);
			return new ResponseEntity<>(ResultDto.of("success", userResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/users")
	private ResponseEntity<?> getUserList() {
		List<User> userList = userService.getUserList();
		
		if (userList.size() != 0) {
			List<UserResponseDto> userResponseDtoList = UserResponseDto.fromList(userList);
			return new ResponseEntity<>(ResultDto.of("success", userResponseDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}

}
