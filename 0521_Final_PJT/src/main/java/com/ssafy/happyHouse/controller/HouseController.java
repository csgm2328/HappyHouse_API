package com.ssafy.happyHouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyHouse.model.DongDto;
import com.ssafy.happyHouse.model.HouseDto;
import com.ssafy.happyHouse.model.service.HouseService;

@Controller
@CrossOrigin("*")
public class HouseController {
	
	@Autowired
	HouseService houseService;
	
	@RequestMapping(value = "/houseInfo/{dong}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HouseDto>> houseInfo(@PathVariable String dong) {
		List<HouseDto> list = houseService.getList(dong);
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dong", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DongDto>> getDong() {
		List<DongDto> list = houseService.getDong();
		return new ResponseEntity<List<DongDto>>(list, HttpStatus.OK);
	}
	
}
