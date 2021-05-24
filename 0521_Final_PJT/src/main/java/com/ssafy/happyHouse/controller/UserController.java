package com.ssafy.happyHouse.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyHouse.model.user.MemberDto;
import com.ssafy.happyHouse.model.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("UserController V1")
@Controller
@CrossOrigin("*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MemberDto> login(@RequestBody Map<String, String> map){
		try {
			MemberDto memberDto = userService.login(map);
			if(memberDto != null) {
				System.out.println("로그인:" + map.get("id"));
				System.out.println(memberDto);
				return new ResponseEntity<MemberDto>(memberDto,HttpStatus.OK);
			}
			else {
				System.out.println("[로그인 실패] : 아이디, 비밀번호 확인 하세요");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/user/findPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MemberDto> findPwd(@RequestBody Map<String, String> map) throws Exception {
		MemberDto memberDto = userService.findPwd(map);
		if(memberDto != null) {
			System.out.println(memberDto.getId());
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
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<MemberDto> findUser(@PathVariable String id) throws Exception{
		System.out.println("마이페이지: " + id);
		return new ResponseEntity<>(userService.findUser(id),HttpStatus.OK);
	}
	@ApiOperation(value = "id에 해당하는 회원의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> modifyUser(@RequestBody MemberDto memberDto) {
		logger.debug("modifyUser - 호출"); //호출안되는데?
		logger.debug("" + memberDto);
		if(userService.userModify(memberDto) != 0) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAIL", HttpStatus.NO_CONTENT);
	}
	@ApiOperation(value = "id에 해당하는 회원의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		logger.debug("deleteUser - 호출");
		if(userService.userDelete(id) != 0) {
			return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<>("FAIL", HttpStatus.NO_CONTENT);
	}
}
