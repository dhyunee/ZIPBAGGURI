package com.mycom.myhouse.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {
	
	private int userSeq;
	private String userName;
	private String userPassword;
	private String userEmail;
	private LocalDateTime userRegisterDate;
	private int userClsf;
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
	private String dongCode;
	private String dongName;
	
	public static User createUser(String userName, String userPassword, String userEmail, String sidoCode, String sidoName, String gugunCode, String gugunName, String dongCode,
			String dongName) {
		User user = new User();
		user.userName = userName;
		user.userPassword = userPassword;
		user.userEmail = userEmail;
		user.userClsf = 0;
		user.sidoCode = sidoCode;
		user.sidoName = sidoName;
		user.gugunCode = gugunCode;
		user.gugunName = gugunName;
		user.dongCode = dongCode;
		user.dongName = dongName;
		
		return user;
	}
	
}
