package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.board.model.MemoDto;

public interface MemoMapper {

	void writeMemo(MemoDto memoDto) throws SQLException;
	List<MemoDto> listMemo(int articleno) throws SQLException;
	void modifyMemo(MemoDto memoDto) throws SQLException;
	void deleteMemo(int memono) throws SQLException;
	
}
