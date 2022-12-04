package com.mycom.myhouse.dto;

import com.mycom.myhouse.domain.Board;

import lombok.Data;

@Data
public class BoardRequestDto {
	
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private int userSeq;
	private boolean showAddress;
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
	private String dongCode;
	private String dongName;
	
	public Board toEntity() {
		return Board.createBoard(this.boardId, this.boardTitle, this.boardContent, this.userSeq, this.showAddress, this.sidoCode, this.sidoName, this.gugunCode, this.gugunName, this.dongCode, this.dongName);
	}
	
}
