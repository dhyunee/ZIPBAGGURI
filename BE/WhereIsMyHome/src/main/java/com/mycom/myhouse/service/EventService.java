package com.mycom.myhouse.service;

import java.util.List;

import com.mycom.myhouse.domain.Event;
import com.mycom.myhouse.dto.EventRequestDto;

public interface EventService {

	Event getEvent(int eventId);
	List<Event> getEventList();
	
	Event insertEvent(EventRequestDto eventDto);
	int deleteEvent(int eventId);
	
}
