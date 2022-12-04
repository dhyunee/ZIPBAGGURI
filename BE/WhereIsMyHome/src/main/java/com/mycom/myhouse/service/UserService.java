package com.mycom.myhouse.service;

import java.util.List;

import com.mycom.myhouse.domain.User;
import com.mycom.myhouse.dto.UserRequestDto;

public interface UserService {

	User getUser(int userSeq);
	List<User> getUserList();
	
	User insertUser(UserRequestDto userDto);
	User updateUser(UserRequestDto userDto);
	int deleteUser(int userSeq);
	User login(UserRequestDto userDto);
	
}
