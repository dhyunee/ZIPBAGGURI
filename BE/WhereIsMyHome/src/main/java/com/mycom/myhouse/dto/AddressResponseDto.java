package com.mycom.myhouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.mycom.myhouse.domain.Address;

import lombok.Data;

@Data
public class AddressResponseDto {
	
	private String code;
	private String name;
	
	public static AddressResponseDto from(Address address) {
		AddressResponseDto addressResponseDto = new AddressResponseDto();
		
		addressResponseDto.code = address.getCode();
		addressResponseDto.name = address.getName();
		
		return addressResponseDto;
	}
	
	public static List<AddressResponseDto> fromList(List<Address> addressList) {
		List<AddressResponseDto> addressResponseDtoList = new ArrayList<>();
		
		for(Address address : addressList) {
			AddressResponseDto addressResponseDto = AddressResponseDto.from(address);
			
			addressResponseDtoList.add(addressResponseDto);
		}
		
		return addressResponseDtoList;
	}

}
