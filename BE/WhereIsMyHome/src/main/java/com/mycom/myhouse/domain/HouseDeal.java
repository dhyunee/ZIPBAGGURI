package com.mycom.myhouse.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class HouseDeal {

	private int no;
	private int houseNo;
	private String aptName;
	private String dong;
	private String code;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private Double area;
	private int floor;
	private String dealAmount;
	
}
