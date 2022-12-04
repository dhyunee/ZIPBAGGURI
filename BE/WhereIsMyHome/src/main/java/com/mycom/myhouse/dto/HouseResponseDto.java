package com.mycom.myhouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.mycom.myhouse.domain.House;

import lombok.Data;

@Data
public class HouseResponseDto {

	private int no;
	private String aptName;
	private String dong;
	private String jibun; 
	// private String code;
	private int buildYear;
	private Double lat;
	private Double lng;
	private Double avgArea;
	private int avgDealAmount;
	
	public static HouseResponseDto from(House house) {
		HouseResponseDto houseResponseDto = new HouseResponseDto();
		
		houseResponseDto.no = house.getNo();
		houseResponseDto.aptName = house.getAptName();
		houseResponseDto.dong = house.getDong();
		houseResponseDto.jibun = house.getJibun();
		houseResponseDto.buildYear = house.getBuildYear();
		houseResponseDto.lat = house.getLat();
		houseResponseDto.lng = house.getLng();
		houseResponseDto.avgArea = house.getAvgArea();
		houseResponseDto.avgDealAmount = house.getAvgDealAmount();
		
		return houseResponseDto;
	}
	
	public static List<HouseResponseDto> fromList(List<House> houseList) {
		List<HouseResponseDto> houseResponseDtoList = new ArrayList<>();
		
		for(House house : houseList) {
			HouseResponseDto houseResponseDto = HouseResponseDto.from(house);
			
			houseResponseDtoList.add(houseResponseDto);
		}
		
		return houseResponseDtoList;
	}
}
