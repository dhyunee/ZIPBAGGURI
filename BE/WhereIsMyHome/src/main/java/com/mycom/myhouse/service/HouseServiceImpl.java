package com.mycom.myhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myhouse.dao.HouseDao;
import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;
import com.mycom.myhouse.dto.HouseRequestDto;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	HouseDao houseDao;

	@Override
	public List<Address> getSido() {
		
		return houseDao.findSido();
	}

	@Override
	public List<Address> getGugun(HouseRequestDto houseRequestDto) {
		Address sido = houseRequestDto.toSido();
		
		return houseDao.findGugun(sido);
	}

	@Override
	public List<Address> getDong(HouseRequestDto houseRequestDto) {
		Address gugun = houseRequestDto.toGugun();
		
		return houseDao.findDong(gugun);
	}

	@Override
	public List<House> getHouseList(HouseRequestDto houseRequestDto) {
		Address dong = houseRequestDto.toDong();
		Address address = houseDao.findAddress(dong);
		
		return houseDao.findHouse(address);
	}

	@Override
	public List<HouseDeal> getHouseDealList(HouseRequestDto houseRequestDto) {
		int houseNo = houseRequestDto.getHouseNo();
		
		return houseDao.findHouseDeal(houseNo);
	}

}
