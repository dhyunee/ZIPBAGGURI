package com.mycom.myhouse.dto;

import com.mycom.myhouse.domain.User;

import lombok.Data;

@Data
public class UserRequestDto {
	
	private String userName;
	private String userPassword;
	private String userEmail;
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
	private String dongCode;
	private String dongName;
	
	public User toEntity() {
		return User.createUser(this.userName, this.userPassword, this.userEmail, this.sidoCode, this.sidoName, this.gugunCode, this.gugunName, this.dongCode, this.dongName);
	}
	
}
