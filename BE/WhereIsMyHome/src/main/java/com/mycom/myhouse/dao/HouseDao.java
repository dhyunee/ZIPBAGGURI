package com.mycom.myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;

@Mapper
public interface HouseDao {
	
	List<Address> findSido();
	List<Address> findGugun(Address address);
	List<Address> findDong(Address address);
	Address findAddress(Address address);
	
	List<House> findHouse(Address address);
	
	List<HouseDeal> findHouseDeal(int houseNo);
	
}
