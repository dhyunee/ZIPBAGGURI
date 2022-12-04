package com.mycom.myhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myhouse.dao.UserDao;
import com.mycom.myhouse.domain.User;
import com.mycom.myhouse.dto.UserRequestDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;
	
	@Override
	public User getUser(int userSeq) {
		return userDao.findBySeq(userSeq);
	}
	
	@Override
	public List<User> getUserList() {
		return userDao.findAll();
	}
	
	@Override
	public User insertUser(UserRequestDto userRequestDto) {
		User user = userRequestDto.toEntity();
		
		if (userDao.insertUser(user) == SUCCESS) {
			return userDao.findByEmail(user.getUserEmail());
		}
		
		return null;
	}

	@Override
	public User updateUser(UserRequestDto userRequestDto) {
		User user = userRequestDto.toEntity();
		
		if (userDao.updateUser(user) == SUCCESS) {
			return userDao.findByEmail(user.getUserEmail());
		}
		
		return null;
	}

	@Override
	public int deleteUser(int userSeq) {
		if (userDao.deleteUser(userSeq) == SUCCESS) {
			return SUCCESS;
		}
		
		return FAIL;
	}

	@Override
	public User login(UserRequestDto userRequestDto) {
		User user = userRequestDto.toEntity();
		
		User foundUser = userDao.findByEmail(user.getUserEmail());
		
		if (foundUser != null && foundUser.getUserPassword().equals(user.getUserPassword())) {
			return foundUser;
		}
		
		return null;
	}

	


	
	
}
