package com.ssafy.happyHouse.model.house.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;


public interface HouseService {
	public List<HouseDto> getList(String dong);
	public List<HouseDto> getAptDetail(Map<String, String> params);
	public List<DongDto> getDong();
	public HouseDto getDetail(int no);
}
