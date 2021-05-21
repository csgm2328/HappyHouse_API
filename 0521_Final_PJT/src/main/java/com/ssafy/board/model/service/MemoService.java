package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.MemoDto;

public interface MemoService {

	void writeMemo(MemoDto memoDto) throws Exception;
	List<MemoDto> listMemo(int articleno) throws Exception;
	void modifyMemo(MemoDto memoDto) throws Exception;
	void deleteMemo(int memono) throws Exception;
	
}
