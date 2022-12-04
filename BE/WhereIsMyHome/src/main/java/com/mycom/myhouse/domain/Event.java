package com.mycom.myhouse.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Event {
	
	private int eventId;
	private String eventName;
	private String eventFrom;
	private String eventTo;
	
	public static Event createEvent(String eventName, String eventFrom, String eventTo) {
		Event event = new Event();
		event.eventName = eventName;
		event.eventFrom = eventFrom;
		event.eventTo = eventTo;
		
		return event;
	}

}
