package com.ssafy.happyHouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;
import com.ssafy.happyHouse.model.house.service.HouseService;


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
	
	@RequestMapping(value = "/houseInfo/detail/{no}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDto> houseDetail(@PathVariable String no) {
		HouseDto house = houseService.getDetail(Integer.parseInt(no));
		return new ResponseEntity<HouseDto>(house, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/houseInfo/apt", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<HouseDto>> houseAptDetail(@RequestBody HouseDto param) {
		Map<String, String> params = new HashMap<>();
		params.put("AptName", param.getAptName());
		params.put("dong", param.getDong());
		List<HouseDto> list = houseService.getAptDetail(params);
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dong", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DongDto>> getDong() {
		List<DongDto> list = houseService.getDong();
		return new ResponseEntity<List<DongDto>>(list, HttpStatus.OK);
	}
	
}
