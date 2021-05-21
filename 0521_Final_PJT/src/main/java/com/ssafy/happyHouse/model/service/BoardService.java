package com.ssafy.happyHouse.model.service;

import java.util.List;

import com.ssafy.happyHouse.model.BoardDto;


public interface BoardService {
	public List<BoardDto> retrieveBoard();
	public BoardDto detailBoard(int no);
	public boolean writeBoard(BoardDto BoardDto);
	public boolean updateBoard(BoardDto BoardDto);
	public boolean deleteBoard(int no);
}
