package com.mycom.myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;

@Mapper
public interface HouseDao {
	
	List<Address> findSido();
	List<Address> findGugun(String code);
	List<Address> findDong(String code);
	Address findAddress(String code);
	
	List<House> findHouseFromGugun(Address address);
	List<House> findHouseFromDong(Address address);
	
	House findHouseInfo(int houseNo);
	List<HouseDeal> findHouseDeal(int houseNo);
	
}
