package com.ssafy.happyHouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyHouse.model.DongDto;
import com.ssafy.happyHouse.model.HouseDto;

@Mapper
public interface HouseMapper {
	public List<HouseDto> getList(String dong);
	public List<DongDto> getDong();
}
