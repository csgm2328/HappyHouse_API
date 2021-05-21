package com.ssafy.board.model.mapper;

import java.sql.SQLException;

import com.ssafy.board.model.MemberDto;

public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto userInfo(String userid) throws SQLException;
	
}
