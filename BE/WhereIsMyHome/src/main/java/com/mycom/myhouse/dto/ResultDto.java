package com.mycom.myhouse.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ResultDto<T> { 
	private final String resultCode;
	private final T data;
	
	public static <T> ResultDto<T> of(String result, T data) {
		return new ResultDto<>(result, data);
	}
	
	public static <T> ResultDto<T> of(T data) {
		return new ResultDto<>(null, data);
	}
	
	public static <T> ResultDto<T> ofSuccess() {
		return new ResultDto<>("success", null);
	}
	
	public static <T> ResultDto<T> ofFail() {
		return new ResultDto<>("fail", null);
	}
	
}
