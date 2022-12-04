package com.mycom.myhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myhouse.dao.EventDao;
import com.mycom.myhouse.domain.Event;
import com.mycom.myhouse.dto.EventRequestDto;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	EventDao eventDao;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public Event getEvent(int eventId) {
		return eventDao.findById(eventId);
	}
	
	@Override
	public List<Event> getEventList() {
		return eventDao.findAll();
	}
	
	@Override
	public Event insertEvent(EventRequestDto eventRequestDto) {
		Event event = eventRequestDto.toEntity();
		System.out.println("service" + event.toString());
		
		if (eventDao.insertEvent(event) == SUCCESS) {
			return eventDao.findByName(event.getEventName());
		}
		
		return null;
	}

	@Override
	public int deleteEvent(int eventId) {
		
		if (eventDao.deleteEvent(eventId) == SUCCESS) {
			return SUCCESS;
		}
		
		return FAIL;
	}


}
