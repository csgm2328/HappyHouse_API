package com.ssafy.happyHouse.model.house.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;
import com.ssafy.happyHouse.model.house.mapper.HouseMapper;


@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	HouseMapper houseMapper;
	
	public List<HouseDto> getList(String dong){
		return houseMapper.getList(dong);
	}
	public List<HouseDto> getAptDetail(Map<String, String> params){
		return houseMapper.getAptDetail(params);
	}
	
	public List<DongDto> getDong(){
		return houseMapper.getDong();
	}
	public HouseDto getDetail(int no) {
		return houseMapper.getDetail(no);
	}
}
