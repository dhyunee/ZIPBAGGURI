package com.mycom.myhouse.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Board {
	
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private LocalDateTime boardRegisterDate;
	private int readCount;
	private int userSeq;
	private boolean showAddress;
	private String sidoCode;
	private String sidoName;
	private String gugunCode;
	private String gugunName;
	private String dongCode;
	private String dongName;
	
	public static Board createBoard(int boardId, String boardTitle, String boardContent, int userSeq, boolean showAddress, String sidoCode, String sidoName, String gugunCode, String gugunName, String dongCode, String dongName) {
		Board board = new Board();
		
		board.boardId = boardId;
		board.boardTitle = boardTitle;
		board.boardContent = boardContent;
		board.userSeq = userSeq;
		board.showAddress = showAddress;
		board.sidoCode = sidoCode;
		board.sidoName = sidoName;
		board.gugunCode = gugunCode;
		board.gugunName = gugunName;
		board.dongCode = dongCode;
		board.dongName = dongName;
		
		return board;
	}
	
}
