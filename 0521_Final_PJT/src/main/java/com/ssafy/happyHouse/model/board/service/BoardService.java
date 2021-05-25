package com.ssafy.happyHouse.model.board.service;

import java.util.List;

import com.ssafy.happyHouse.model.board.BoardDto;

public interface BoardService {
	public List<BoardDto> retrieveBoard();
	public List<BoardDto> searchBoard(String title);
	public BoardDto detailBoard(int no);
	public boolean writeBoard(BoardDto BoardDto);
	public boolean updateBoard(BoardDto BoardDto);
	public boolean deleteBoard(int no);
}
