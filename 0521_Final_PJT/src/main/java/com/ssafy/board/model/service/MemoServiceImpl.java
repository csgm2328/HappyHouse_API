package com.ssafy.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.MemoDto;
import com.ssafy.board.model.mapper.MemoMapper;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeMemo(MemoDto memoDto) throws Exception {
		sqlSession.getMapper(MemoMapper.class).writeMemo(memoDto);
	}

	@Override
	public List<MemoDto> listMemo(int articleno) throws Exception {
		return sqlSession.getMapper(MemoMapper.class).listMemo(articleno);
	}

	@Override
	public void modifyMemo(MemoDto memoDto) throws Exception {
		sqlSession.getMapper(MemoMapper.class).modifyMemo(memoDto);
	}

	@Override
	public void deleteMemo(int memono) throws Exception {
		sqlSession.getMapper(MemoMapper.class).deleteMemo(memono);
	}

}
