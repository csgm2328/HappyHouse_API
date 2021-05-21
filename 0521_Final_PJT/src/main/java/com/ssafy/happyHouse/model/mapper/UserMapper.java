package com.ssafy.happyHouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyHouse.model.MemberDto;

@Mapper
public interface UserMapper {

	public MemberDto login(Map<String, String> map) throws SQLException;
	public MemberDto findPwd(Map<String, String> map) throws Exception;
	public MemberDto findUser(String id) throws Exception;
	
//	REST
	public List<MemberDto> userList();
	public MemberDto userInfo(String userid);
	public int userRegister(MemberDto memberDto);
	public int userModify(MemberDto memberDto);
	public int userDelete(String userid);
}
