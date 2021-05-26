package com.ssafy.happyHouse.model.house.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;
import com.ssafy.happyHouse.model.house.StoreDto;
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
	public List<DongDto> getDongChart(String params) {
		return houseMapper.getDongChart(params);
	}
	public List<DongDto> getHouseChartTop10(){
		return houseMapper.getHouseChartTop10();
	}
	@Override
	public boolean addPick(Map<String, String> params) {
		return houseMapper.addPick(params) == 1;
	}
	@Override
	public List<HouseDto> getPickList(String id) {
		return houseMapper.getPickList(id);
	}
	@Override
	public List<StoreDto> getStore(String dong) {
		return houseMapper.getStore(dong);
	}
	@Override
	public HouseDto getLately() {
		return houseMapper.getLately();
	}
	public boolean deletePick(Map<String, String> params) {
		return houseMapper.deletePick(params) == 1;
	}
}
