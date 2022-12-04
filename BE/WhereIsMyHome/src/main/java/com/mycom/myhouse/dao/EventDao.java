package com.mycom.myhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myhouse.domain.Event;

@Mapper
public interface EventDao {

	Event findById(int eventId);
	Event findByName(String eventName);
	List<Event> findAll();
	
	int insertEvent(Event event);
	int deleteEvent(int eventId);
	
}
