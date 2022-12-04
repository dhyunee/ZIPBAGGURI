package com.mycom.myhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myhouse.domain.Address;
import com.mycom.myhouse.domain.House;
import com.mycom.myhouse.domain.HouseDeal;
import com.mycom.myhouse.dto.AddressResponseDto;
import com.mycom.myhouse.dto.HouseDealResponseDto;
import com.mycom.myhouse.dto.HouseRequestDto;
import com.mycom.myhouse.dto.HouseResponseDto;
import com.mycom.myhouse.dto.ResultDto;
import com.mycom.myhouse.service.HouseService;

@RestController
public class HouseController {

	@Autowired
	HouseService houseService;
	
	@GetMapping("/sidoList")
	public ResponseEntity<?> getSidoList() {
		List<Address> sidoList = houseService.getSido();
		
		if (sidoList.size() != 0) {
			List<AddressResponseDto> sidoDtoList = AddressResponseDto.fromList(sidoList);
			return new ResponseEntity<>(ResultDto.of("success", sidoDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/gugunList")
	public ResponseEntity<?> getGugunList(HouseRequestDto houseRequestDto) {
		List<Address> gugunList = houseService.getGugun(houseRequestDto);
		
		if (gugunList.size() != 0) {
			List<AddressResponseDto> gugunDtoList = AddressResponseDto.fromList(gugunList);
			return new ResponseEntity<>(ResultDto.of("success", gugunDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/dongList")
	public ResponseEntity<?> getDongList(HouseRequestDto houseRequestDto) {
		List<Address> dongList = houseService.getDong(houseRequestDto);
		
		if (dongList.size() != 0) {
			List<AddressResponseDto> dongDtoList = AddressResponseDto.fromList(dongList);
			return new ResponseEntity<>(ResultDto.of("success", dongDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/houseList")
	public ResponseEntity<?> getHouseList(HouseRequestDto houseRequestDto) {
		List<House> houseList = houseService.getHouseList(houseRequestDto);
		
		if (houseList.size() != 0) {
			List<HouseResponseDto> houseResponseDtoList = HouseResponseDto.fromList(houseList);
			return new ResponseEntity<>(ResultDto.of("success", houseResponseDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/houseDealList")
	public ResponseEntity<?> getHouseDealList(HouseRequestDto houseRequestDto) {
		List<HouseDeal> houseDealList = houseService.getHouseDealList(houseRequestDto);
		
		if (houseDealList.size() != 0) {
			List<HouseDealResponseDto> houseDealResponseDtoList = HouseDealResponseDto.fromList(houseDealList);
			return new ResponseEntity<>(ResultDto.of("success", houseDealResponseDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	
}
