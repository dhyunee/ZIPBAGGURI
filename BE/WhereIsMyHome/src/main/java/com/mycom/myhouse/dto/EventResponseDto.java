package com.mycom.myhouse.dto;

import java.util.ArrayList;
import java.util.List;

import com.mycom.myhouse.domain.Event;

import lombok.Data;

@Data
public class EventResponseDto {
	
	private int eventId;
	private String eventName;
	private String eventFrom;
	private String eventTo;

	public static EventResponseDto from(Event event) {
		EventResponseDto eventResponseDto = new EventResponseDto();
		
		eventResponseDto.eventId = event.getEventId();
		eventResponseDto.eventName = event.getEventName();
		eventResponseDto.eventFrom = event.getEventFrom();
		eventResponseDto.eventTo = event.getEventTo();
		
		return eventResponseDto;
	}
	
	public static List<EventResponseDto> fromList(List<Event> eventList) {
		List<EventResponseDto> eventResponseDtoList = new ArrayList<>();
		
		for(Event event : eventList) {
			EventResponseDto eventDto = EventResponseDto.from(event);
			
			eventResponseDtoList.add(eventDto);
		}
		
		return eventResponseDtoList;
	}
	
}
