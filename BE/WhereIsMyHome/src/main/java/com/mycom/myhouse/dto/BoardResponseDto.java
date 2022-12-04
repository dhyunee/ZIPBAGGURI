package com.mycom.myhouse.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mycom.myhouse.domain.Board;

import lombok.Data;

@Data
public class BoardResponseDto {
	
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

	public static BoardResponseDto from(Board board) {
		BoardResponseDto boardResponseDto = new BoardResponseDto();
		
		boardResponseDto.boardId = board.getBoardId();
		boardResponseDto.boardTitle = board.getBoardTitle();
		boardResponseDto.boardContent = board.getBoardContent();
		boardResponseDto.boardRegisterDate = board.getBoardRegisterDate();
		boardResponseDto.readCount = board.getReadCount();
		boardResponseDto.userSeq = board.getUserSeq();
		boardResponseDto.showAddress = board.isShowAddress();
		boardResponseDto.sidoCode = board.getSidoCode();
		boardResponseDto.sidoName = board.getSidoName();
		boardResponseDto.gugunCode = board.getGugunCode();
		boardResponseDto.gugunName = board.getGugunName();
		boardResponseDto.dongCode = board.getDongCode();
		boardResponseDto.dongName = board.getDongName();
		
		return boardResponseDto;
	}
	
	public static List<BoardResponseDto> fromList(List<Board> boardList) {
		List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
		
		for(Board board : boardList) {
			BoardResponseDto boardDto = BoardResponseDto.from(board);
			
			boardResponseDtoList.add(boardDto);
		}
		
		return boardResponseDtoList;
	}
	
}
