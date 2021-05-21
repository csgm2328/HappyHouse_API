package com.ssafy.happyHouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyHouse.model.DongDto;
import com.ssafy.happyHouse.model.HouseDto;
import com.ssafy.happyHouse.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService {
	
	@Autowired
	HouseMapper houseMapper;
	
	public List<HouseDto> getList(String dong){
		return houseMapper.getList(dong);
	}
	
	public List<DongDto> getDong(){
		return houseMapper.getDong();
	}
}
