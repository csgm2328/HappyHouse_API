package com.ssafy.happyHouse.model.house.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;
import com.ssafy.happyHouse.model.house.StoreDto;

@Mapper
public interface HouseMapper {
	public List<HouseDto> getList(String dong);
	public List<HouseDto> getAptDetail(Map<String, String> params);
	public List<HouseDto> getPickList(String id);
	public List<DongDto> getDong();
	public List<DongDto> getDongChart(String params);
	public List<DongDto> getHouseChartTop10();
	public List<StoreDto> getStore(String dong);
	public HouseDto getDetail(int no);
	public HouseDto getLately();
	public int addPick(Map<String, String> params);
	public int deletePick(Map<String, String> params);
}
