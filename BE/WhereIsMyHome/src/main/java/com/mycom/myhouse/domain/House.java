package com.mycom.myhouse.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class House {
	
	private int no;
	private String aptName;
	private String dong;
	private String code;
	private int buildYear;
	private Double lat;
	private Double lng;
	private Double avgArea;
	private Double avgDealAmount;

}
