package com.mycom.myhouse.dto;

import com.mycom.myhouse.domain.Event;

import lombok.Data;

@Data
public class EventRequestDto {

	private String eventName;
	private String eventFrom;
	private String eventTo;
	
	public Event toEntity() {
		return Event.createEvent(eventName, eventFrom, eventTo);
	}
}
