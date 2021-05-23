package com.ssafy.happyHouse.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyHouse.model.user.MemberDto;
import com.ssafy.happyHouse.model.user.service.UserService;



@Controller
@CrossOrigin("*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MemberDto> login(@RequestBody MemberDto member) throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", member.getId());
		map.put("pass", member.getPass());
		MemberDto memberDto = userService.login(map);
		System.out.println(memberDto);
		if(memberDto != null) {
			return new ResponseEntity<MemberDto>(memberDto,HttpStatus.OK);
		}
		return new ResponseEntity<MemberDto>(memberDto, HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/user/findPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MemberDto> findPwd(@RequestBody MemberDto member) throws Exception {
		Map<String, String> map = new HashMap();
		map.put("id", member.getId());
		map.put("phone", member.getPhone());
		MemberDto memberDto = userService.findPwd(map);
		System.out.println(memberDto);
		if(memberDto != null) {
			return new ResponseEntity<MemberDto>(memberDto,HttpStatus.OK);
		}
		return new ResponseEntity<MemberDto>(memberDto, HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/user/join", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> join(@RequestBody MemberDto data){
		if(userService.userRegister(data)) {
			return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAIL",HttpStatus.NO_CONTENT);
	}
	
}
