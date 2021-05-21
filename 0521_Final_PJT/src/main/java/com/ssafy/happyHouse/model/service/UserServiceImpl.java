package com.ssafy.happyHouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyHouse.model.MemberDto;
import com.ssafy.happyHouse.model.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		return userMapper.login(map);
	}

	@Override
	public List<MemberDto> userList() {
		return userMapper.userList();
	}

	@Override
	public MemberDto userInfo(String userid) {
		return userMapper.userInfo(userid);
	}

	@Override
	public boolean userRegister(MemberDto memberDto) {
		return userMapper.userRegister(memberDto) == 1;
	}

	@Override
	public int userModify(MemberDto memberDto) {
		return userMapper.userModify(memberDto);
	}

	@Override
	public int userDelete(String userid) {
		return userMapper.userDelete(userid);
	}

	@Override
	public MemberDto findPwd(Map<String, String> map) throws Exception {
		return userMapper.findPwd(map);
	}

	@Override
	public MemberDto findUser(String id) throws Exception {
		return userMapper.findUser(id);
	}
}
