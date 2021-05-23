package com.ssafy.happyHouse.model.user.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyHouse.model.user.MemberDto;



public interface UserService {

	public MemberDto login(Map<String, String> map) throws Exception;
	public MemberDto findPwd(Map<String, String> map) throws Exception;
	public MemberDto findUser(String id) throws Exception;
	
//	REST 
	public List<MemberDto> userList();
	public MemberDto userInfo(String userid);
	public boolean userRegister(MemberDto memberDto);
	public int userModify(MemberDto memberDto);
	public int userDelete(String userid);
}
