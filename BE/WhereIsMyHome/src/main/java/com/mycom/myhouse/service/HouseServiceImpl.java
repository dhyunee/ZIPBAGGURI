package com.mycom.myhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myhouse.dao.HouseDao;
import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	HouseDao houseDao;

	@Override
	public List<Address> getSido() {
		
		return houseDao.findSido();
	}

	@Override
	public List<Address> getAddress(String code) {
		if (code.length() == 2) {
			return houseDao.findGugun(code);
		} else if (code.length() == 5) {
			return houseDao.findDong(code);
		} 
		return null;
	}
	
	@Override
	public List<House> getHouseList(String code) {
		if (code.length() == 5) {
			Address address = Address.createGugun(code);
			return houseDao.findHouseFromGugun(address);
		} else if (code.length() == 10) {
			Address address = houseDao.findAddress(code);
			return houseDao.findHouseFromDong(address);
		}
		
		return null;
	}

	@Override
	public House getHouseInfo(int houseNo) {
		return houseDao.findHouseInfo(houseNo);
	}
	
	@Override
	public List<HouseDeal> getHouseDealList(int houseNo) {
		return houseDao.findHouseDeal(houseNo);
	}
	


}
