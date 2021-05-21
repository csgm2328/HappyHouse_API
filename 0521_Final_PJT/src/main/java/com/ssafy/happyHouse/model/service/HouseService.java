package com.ssafy.happyHouse.model.service;

import java.util.List;

import com.ssafy.happyHouse.model.DongDto;
import com.ssafy.happyHouse.model.HouseDto;

public interface HouseService {
	public List<HouseDto> getList(String dong);
	public List<DongDto> getDong();
}
