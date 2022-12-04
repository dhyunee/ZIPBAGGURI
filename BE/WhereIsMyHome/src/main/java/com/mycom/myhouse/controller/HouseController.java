package com.mycom.myhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;
import com.mycom.myhouse.dto.AddressResponseDto;
import com.mycom.myhouse.dto.HouseDealResponseDto;
import com.mycom.myhouse.dto.HouseResponseDto;
import com.mycom.myhouse.dto.ResultDto;
import com.mycom.myhouse.service.HouseService;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
)
public class HouseController {

	@Autowired
	HouseService houseService;
	
	@GetMapping("/address")
	public ResponseEntity<?> getSidoList() {
		List<Address> sidoList = houseService.getSido();
		
		if (sidoList != null) {
			List<AddressResponseDto> sidoDtoList = AddressResponseDto.fromList(sidoList);
			return new ResponseEntity<>(ResultDto.of("success", sidoDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/address/{code}")
	public ResponseEntity<?> getAddressList(@PathVariable String code) {
		if (code.length() == 2 || code.length() == 5) {
			List<Address> addressList = houseService.getAddress(code);
			
			if (addressList != null) {
				List<AddressResponseDto> addressDtoList = AddressResponseDto.fromList(addressList);
				return new ResponseEntity<>(ResultDto.of("success", addressDtoList), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/houses")
	public ResponseEntity<?> getHouseList(@RequestParam String code) {
		if (code != null && (code.length() == 5 || code.length() == 10)) {
			List<House> houseList = houseService.getHouseList(code);
			
			List<HouseResponseDto> houseResponseDtoList = HouseResponseDto.fromList(houseList);
			return new ResponseEntity<>(ResultDto.of("success", houseResponseDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/houses/{houseNo}/deal")
	public ResponseEntity<?> getHouseDealList(@PathVariable int houseNo) {
		List<HouseDeal> houseDealList = houseService.getHouseDealList(houseNo);
		
		if (houseDealList != null) {
			List<HouseDealResponseDto> houseDealResponseDtoList = HouseDealResponseDto.fromList(houseDealList);
			return new ResponseEntity<>(ResultDto.of("success", houseDealResponseDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/houses/{houseNo}/info")
	public ResponseEntity<?> getHouseInfo(@PathVariable int houseNo) {
		House house = houseService.getHouseInfo(houseNo);
		
		if (house != null) {
			HouseResponseDto houseResponseDto = HouseResponseDto.from(house);
			return new ResponseEntity<>(ResultDto.of("success", houseResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	
}
