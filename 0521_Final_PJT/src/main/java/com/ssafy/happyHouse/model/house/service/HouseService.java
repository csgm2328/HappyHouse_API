package com.ssafy.happyHouse.model.house.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;
import com.ssafy.happyHouse.model.house.StoreDto;


public interface HouseService {
	public List<HouseDto> getList(String dong);
	public List<HouseDto> getAptDetail(Map<String, String> params);
	public List<HouseDto> getPickList(String id);
	public List<DongDto> getDong();
	public List<DongDto> getDongChart(String params);
	public List<DongDto> getHouseChartTop10();
	public List<StoreDto> getStore(String dong);
	public HouseDto getDetail(int no);
	public HouseDto getLately();
	public boolean addPick(Map<String, String> params);
}
