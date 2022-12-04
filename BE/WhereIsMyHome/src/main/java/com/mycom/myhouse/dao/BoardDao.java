package com.mycom.myhouse.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myhouse.domain.Board;

@Mapper
public interface BoardDao {
	
	public Board findById(int boardId);
	public List<Board> findAll();
	public List<Board> findBySearchParams(Map<String, Object> map);
	public int readBoard(int boardId);

	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int boardId);

}
