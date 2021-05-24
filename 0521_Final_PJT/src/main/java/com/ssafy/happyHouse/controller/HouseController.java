package com.ssafy.happyHouse.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;
import com.ssafy.happyHouse.model.house.service.HouseService;

@Controller
@CrossOrigin("*")
public class HouseController {

	@Autowired
	HouseService houseService;

	@RequestMapping(value = "/houseInfo/{dong}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HouseDto>> houseInfo(@PathVariable String dong) {
		List<HouseDto> list = houseService.getList(dong);
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/houseInfo/detail/{no}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDto> houseDetail(@PathVariable String no) {
		HouseDto house = houseService.getDetail(Integer.parseInt(no));
		return new ResponseEntity<HouseDto>(house, HttpStatus.OK);
	}

	@RequestMapping(value = "/houseInfo/apt", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<HouseDto>> houseAptDetail(@RequestBody HouseDto param) {
		Map<String, String> params = new HashMap<>();
		params.put("AptName", param.getAptName());
		params.put("dong", param.getDong());
		List<HouseDto> list = houseService.getAptDetail(params);
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/dong", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DongDto>> getDong() {
		List<DongDto> list = houseService.getDong();
		return new ResponseEntity<List<DongDto>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/getNews", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<JSONObject> getNews() throws UnsupportedEncodingException, IOException, ParseException {
		BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/newsJson.json"));
		JSONObject json = (JSONObject) new JSONParser().parse(reader);
		return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
	}

}
