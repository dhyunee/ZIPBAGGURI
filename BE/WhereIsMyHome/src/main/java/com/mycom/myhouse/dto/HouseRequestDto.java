package com.mycom.myhouse.dto;

import com.mycom.myhouse.domain.Address;

import lombok.Data;

@Data
public class HouseRequestDto {
	
	private int houseNo;
//	private String sido;
//	private String gugun;
//	private String dong;
	private String code;
	
	public Address toSido() {
		return Address.createSido(this.code);
	}
	
	public Address toGugun() {
		return Address.createGugun(this.code);
	}
	
	public Address toDong() {
		return Address.createDong(this.code);
	}
	
}
