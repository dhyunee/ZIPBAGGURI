package com.mycom.myhouse.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mycom.myhouse.domain.User;

import lombok.Data;

@Data
public class UserResponseDto {
	
	private int userSeq;
	private String userName;
	private String userEmail;
	private LocalDateTime userRegisterDate;
	private int userClsf;
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
	private String dongCode;
	private String dongName;

	public static UserResponseDto from(User user) {
		UserResponseDto userResponseDto = new UserResponseDto();
		
		userResponseDto.userSeq = user.getUserSeq();
		userResponseDto.userName = user.getUserName();
		userResponseDto.userEmail = user.getUserEmail();
		userResponseDto.userRegisterDate = user.getUserRegisterDate();
		userResponseDto.userClsf = user.getUserClsf();
		userResponseDto.sidoCode = user.getSidoCode();
		userResponseDto.sidoName = user.getSidoName();
		userResponseDto.gugunCode = user.getGugunCode();
		userResponseDto.gugunName = user.getGugunName();
		userResponseDto.dongCode = user.getDongCode();
		userResponseDto.dongName = user.getDongName();
		
		return userResponseDto;
	}
	
	public static List<UserResponseDto> fromList(List<User> userList) {
		List<UserResponseDto> userResponseDtoList = new ArrayList<>();
		
		for(User user : userList) {
			UserResponseDto userDto = UserResponseDto.from(user);
			
			userResponseDtoList.add(userDto);
		}
		
		return userResponseDtoList;
	}
	
}
