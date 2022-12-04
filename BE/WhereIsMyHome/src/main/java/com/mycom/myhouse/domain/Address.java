package com.mycom.myhouse.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Address {
	
	private String sidoCode;
	private String gugunCode;
	private String dongCode;
	private String code;
	private String name;
	
	public static Address createSido(String sidoCode) {
		Address address = new Address();
		address.sidoCode = sidoCode;
		
		return address;
	}
	
	public static Address createGugun(String gugunCode) {
		Address address = new Address();
		address.gugunCode = gugunCode;
		
		return address;
	}
	
	public static Address createDong(String dongCode) {
		Address address = new Address();
		address.dongCode = dongCode;
		
		return address;
	}

}
