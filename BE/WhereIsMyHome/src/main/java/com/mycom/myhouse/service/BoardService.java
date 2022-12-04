package com.mycom.myhouse.service;

import java.util.List;

import com.mycom.myhouse.domain.Board;
import com.mycom.myhouse.dto.BoardRequestDto;
import com.mycom.myhouse.dto.BoardSearchRequestDto;

public interface BoardService {

	Board getBoard(int boardId);
	List<Board> getBoardList(BoardSearchRequestDto boardSearchRequestDto);
	
	int insertBoard(BoardRequestDto boardDto);
	Board updateBoard(BoardRequestDto boardDto);
	int deleteBoard(int boardId);
	
}
