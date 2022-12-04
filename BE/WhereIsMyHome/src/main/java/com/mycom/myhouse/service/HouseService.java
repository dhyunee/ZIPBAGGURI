package com.mycom.myhouse.service;

import java.util.List;

import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;

public interface HouseService {
	
	List<Address> getSido();
	List<Address> getAddress(String code);
	
	List<House> getHouseList(String code);
	House getHouseInfo(int houseNo);
	List<HouseDeal> getHouseDealList(int houseNo);
}
