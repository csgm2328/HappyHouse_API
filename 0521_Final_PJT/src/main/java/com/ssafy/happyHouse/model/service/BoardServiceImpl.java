package com.ssafy.happyHouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyHouse.model.BoardDto;
import com.ssafy.happyHouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
    @Autowired
	private BoardMapper boardDao;

    @Override
	public List<BoardDto> retrieveBoard() {
		return boardDao.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(BoardDto BoardDto) {
		return boardDao.insertBoard(BoardDto) == 1;
	}

	@Override
	public BoardDto detailBoard(int no) {
		return boardDao.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(BoardDto BoardDto) {
		return boardDao.updateBoard(BoardDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return boardDao.deleteBoard(no) == 1;
	}
}