package com.mycom.myhouse.service;

import java.util.List;

import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;
import com.mycom.myhouse.dto.HouseRequestDto;

public interface HouseService {
	
	List<Address> getSido();
	List<Address> getGugun(HouseRequestDto houseRequestDto);
	List<Address> getDong(HouseRequestDto houseRequestDto);
	
	List<House> getHouseList(HouseRequestDto houseRequestDto);
	List<HouseDeal> getHouseDealList(HouseRequestDto houseRequestDto);
}
