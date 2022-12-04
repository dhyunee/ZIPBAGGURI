package com.mycom.myhouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.mycom.myhouse.domain.HouseDeal;

import lombok.Data;

@Data
public class HouseDealResponseDto {

	// private int no;
	// private int house_no;
	// private String aptName;
	// private String dong;
	// private String code;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private Double area;
	private int floor;
	private String dealAmount;
	
	public static HouseDealResponseDto from(HouseDeal houseDeal) {
		HouseDealResponseDto houseDealResponseDto = new HouseDealResponseDto();
		
		houseDealResponseDto.dealYear = houseDeal.getDealYear();
		houseDealResponseDto.dealMonth = houseDeal.getDealMonth();
		houseDealResponseDto.dealDay = houseDeal.getDealDay();
		houseDealResponseDto.area = houseDeal.getArea();
		houseDealResponseDto.floor = houseDeal.getFloor();
		houseDealResponseDto.dealAmount = houseDeal.getDealAmount().trim();
		
		return houseDealResponseDto;
	}
	
	public static List<HouseDealResponseDto> fromList(List<HouseDeal> houseDealList) {
		List<HouseDealResponseDto> houseDealResponseDtoList = new ArrayList<>();
		
		for(HouseDeal houseDeal : houseDealList) {
			HouseDealResponseDto houseDealResponseDto = HouseDealResponseDto.from(houseDeal);
			
			houseDealResponseDtoList.add(houseDealResponseDto);
		}
		
		return houseDealResponseDtoList;
	}
}
