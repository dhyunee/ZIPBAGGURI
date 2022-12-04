package com.mycom.myhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myhouse.domain.Event;
import com.mycom.myhouse.dto.EventRequestDto;
import com.mycom.myhouse.dto.EventResponseDto;
import com.mycom.myhouse.dto.ResultDto;
import com.mycom.myhouse.service.EventService;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class EventController {
	
	@Autowired
	EventService eventService;
	
	private final int SUCCESS = 1;
	
	@PostMapping("/events")
	public ResponseEntity<?> insertEvent(EventRequestDto eventRequestDto) {
		Event savedEvent = eventService.insertEvent(eventRequestDto);
		
		if (savedEvent != null) {
			EventResponseDto eventResponseDto = EventResponseDto.from(savedEvent);
			return new ResponseEntity<>(ResultDto.of("success", eventResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/events/{eventId}")
	public ResponseEntity<?> deleteEvent(@PathVariable int eventId) {
		int result = eventService.deleteEvent(eventId);
		
		if (result == SUCCESS) {
			return new ResponseEntity<>(ResultDto.ofSuccess(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/events/{eventId}")
	public ResponseEntity<?> getEvent(@PathVariable int eventId) {
		Event event = eventService.getEvent(eventId);
		
		if (event != null) {
			EventResponseDto eventResponseDto = EventResponseDto.from(event);
			return new ResponseEntity<>(ResultDto.of("success", eventResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/events")
	public ResponseEntity<?> getEventList() {
		List<Event> eventList = eventService.getEventList();
		
		if (eventList.size() != 0) {
			List<EventResponseDto> eventResponseDtoList = EventResponseDto.fromList(eventList);
			return new ResponseEntity<>(ResultDto.of("success", eventResponseDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
}
