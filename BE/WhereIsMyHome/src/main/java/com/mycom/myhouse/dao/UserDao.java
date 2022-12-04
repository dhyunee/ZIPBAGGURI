package com.mycom.myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myhouse.domain.User;

@Mapper
public interface UserDao {
	
	public User findByEmail(String userEmail);
	public User findBySeq(int userSeq);
	public List<User> findAll();

	public int insertUser(User user);
	public int updateUser(User user);
	public int deleteUser(int userSeq);
	
}
