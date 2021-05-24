package com.ssafy.happyHouse.model.house.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyHouse.model.house.DongDto;
import com.ssafy.happyHouse.model.house.HouseDto;

@Mapper
public interface HouseMapper {
	public List<HouseDto> getList(String dong);
	public List<HouseDto> getAptDetail(Map<String, String> params);
	public List<DongDto> getDong();
	public List<DongDto> getDongChart(String params);
	public List<DongDto> getHouseChartTop10();
	public HouseDto getDetail(int no);
}
