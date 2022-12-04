package com.mycom.myhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myhouse.domain.Board;
import com.mycom.myhouse.dto.BoardRequestDto;
import com.mycom.myhouse.dto.BoardResponseDto;
import com.mycom.myhouse.dto.BoardSearchRequestDto;
import com.mycom.myhouse.dto.ResultDto;
import com.mycom.myhouse.service.BoardService;

@RestController
@CrossOrigin(
	    // localhost:5500 과 127.0.0.1 구분
	    origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
	    allowCredentials = "true", 
	    allowedHeaders = "*", 
	    methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	private final int SUCCESS = 1;
	
	@PostMapping("/boards")
	public ResponseEntity<?> insertBoard(@RequestBody BoardRequestDto boardRequestDto) {
		int result = boardService.insertBoard(boardRequestDto);
		
		if (result == SUCCESS) {
			return new ResponseEntity<>(ResultDto.ofSuccess(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/boards/{boardId}")
	private ResponseEntity<?> updateBoard(@RequestBody BoardRequestDto boardRequestDto) {
		Board updatedBoard = boardService.updateBoard(boardRequestDto);
		
		if (updatedBoard != null) {
			BoardResponseDto boardResponseDto = BoardResponseDto.from(updatedBoard);
			return new ResponseEntity<>(ResultDto.of("success", boardResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/boards/{boardId}")
	private ResponseEntity<?> deleteBoard(@PathVariable int boardId) {
		int result = boardService.deleteBoard(boardId);
		
		if (result == SUCCESS) {
			return new ResponseEntity<>(ResultDto.ofSuccess(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/boards/{boardId}")
	private ResponseEntity<?> getBoard(@PathVariable int boardId) {
		Board board = boardService.getBoard(boardId);
		
		if (board != null) {
			BoardResponseDto boardResponseDto = BoardResponseDto.from(board);
			return new ResponseEntity<>(ResultDto.of("success", boardResponseDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/boards")
	private ResponseEntity<?> getBoardList(HttpServletRequest req) {
		BoardSearchRequestDto boardSearchRequestDto = BoardSearchRequestDto.getParams(req);
		
		List<Board> boardList = boardService.getBoardList(boardSearchRequestDto);
		
		if (boardList != null) {
			List<BoardResponseDto> boardResponseDtoList = BoardResponseDto.fromList(boardList);
			return new ResponseEntity<>(ResultDto.of("success", boardResponseDtoList), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(ResultDto.ofFail(), HttpStatus.NOT_FOUND);
		}
	}

}
