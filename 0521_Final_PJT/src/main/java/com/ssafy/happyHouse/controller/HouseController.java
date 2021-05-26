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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;
import com.ssafy.happyHouse.model.house.StoreDto;
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
	
	@RequestMapping(value = "/getHouseChart", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DongDto>> getHouseChart(@RequestParam(required = false) String dong) {
		return new ResponseEntity<List<DongDto>>(houseService.getDongChart(dong), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getHouseChartTop10", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<DongDto>> getHouseChartTop10() {
		return new ResponseEntity<List<DongDto>>(houseService.getHouseChartTop10(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addPick", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> addPick(@RequestParam(name = "id") String id, @RequestParam(name = "no") String no) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("no", no);
		if(houseService.addPick(map)) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		else return new ResponseEntity<String>("FAIL", HttpStatus.OK);
	}
	@RequestMapping(value = "/getPickList", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HouseDto>> getPickList(@RequestParam(name = "id") String id) {
		List<HouseDto> list = houseService.getPickList(id);
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}
	@RequestMapping(value = "/deletePick", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deletePick(@RequestParam(name = "id") String id, @RequestParam(name = "no") String no) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("no", no);
		if(houseService.deletePick(map)) {
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		return new ResponseEntity<String>("FAIL", HttpStatus.OK);
	}
	@RequestMapping(value = "/getStore", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<StoreDto>> getStore(@RequestParam(name = "dong") String dong) {
		List<StoreDto> list = houseService.getStore(dong);
		return new ResponseEntity<List<StoreDto>>(list, HttpStatus.OK);
	}
	@RequestMapping(value = "/getLately", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDto> getLately() {
		HouseDto dto = houseService.getLately();
		return new ResponseEntity<HouseDto>(dto, HttpStatus.OK);
	}
}
