package com.mycom.myhouse.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myhouse.dao.BoardDao;
import com.mycom.myhouse.domain.Board;
import com.mycom.myhouse.dto.BoardRequestDto;
import com.mycom.myhouse.dto.BoardSearchRequestDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	private final int SUCCESS = 1;
	private final int FAIL = -1;

	@Override
	public Board getBoard(int boardId) {
		Board findBoard = boardDao.findById(boardId);
		
		if (findBoard != null) {
			boardDao.readBoard(boardId);
			return findBoard;
		}

		return null;
	}

	@Override
	public List<Board> getBoardList(BoardSearchRequestDto boardSearchRequestDto) {
		Map<String, Object> map = new HashMap<>();
		if (boardSearchRequestDto.getType() == 1) map.put("type", 1);
		if (!("".equals(boardSearchRequestDto.getSidoCode()))) map.put("sidoCode", boardSearchRequestDto.getSidoCode());
		if (!("".equals(boardSearchRequestDto.getGugunCode()))) map.put("gugunCode", boardSearchRequestDto.getGugunCode());
		if (!("".equals(boardSearchRequestDto.getDongCode()))) map.put("dongCode", boardSearchRequestDto.getDongCode());
		map.put("title", boardSearchRequestDto.getTitle());
		map.put("limit", boardSearchRequestDto.getLimit());
		
		return boardDao.findBySearchParams(map);
	}

	@Override
	public int insertBoard(BoardRequestDto boardRequestDto) {
		Board board = boardRequestDto.toEntity();
		
		if (boardDao.insertBoard(board) == SUCCESS) {
			return SUCCESS;
		}
		
		return FAIL;
	}

	@Override
	public Board updateBoard(BoardRequestDto boardRequestDto) {
		Board board = boardRequestDto.toEntity();
		
		if (boardDao.updateBoard(board) == SUCCESS) {
			return boardDao.findById(board.getBoardId());
		}
		
		return null;
	}

	@Override
	public int deleteBoard(int boardId) {
		if (boardDao.deleteBoard(boardId) == SUCCESS) {
			return SUCCESS;
		}
		
		return FAIL;
	}

}
