package com.mycom.myhouse.dto;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class BoardSearchRequestDto {
	
	private int type;
	private String sidoCode;
	private String gugunCode;
	private String dongCode;
	private String title;
	private int limit;
	
	public static BoardSearchRequestDto getParams(HttpServletRequest req) {
		BoardSearchRequestDto boardSearchRequestDto = new BoardSearchRequestDto();
		
		boardSearchRequestDto.type = Integer.parseInt(req.getParameter("type"));
		boardSearchRequestDto.sidoCode = req.getParameter("sido");
		boardSearchRequestDto.gugunCode = req.getParameter("gugun");
		boardSearchRequestDto.dongCode = req.getParameter("dong");
		boardSearchRequestDto.title = req.getParameter("title");
		boardSearchRequestDto.limit = Integer.parseInt(req.getParameter("limit"));
		
		return boardSearchRequestDto;
	}
}
