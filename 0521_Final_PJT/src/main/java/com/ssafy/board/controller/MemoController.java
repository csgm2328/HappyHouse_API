package com.ssafy.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.board.model.MemoDto;
import com.ssafy.board.model.service.MemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("MemoController V1")
//@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/memo")
public class MemoController {

	private static final Logger logger = LoggerFactory.getLogger(MemoController.class);
//	private static final String SUCCESS = "success";
//	private static final String FAIL = "fail";
	
	@Autowired
	private MemoService memoService;
	
	@ApiOperation(value = "댓글작성", notes = "새로운 댓글 정보를 입력한 후 댓글목록을 반환한다.", response = List.class)
	@PostMapping
	public ResponseEntity<List<MemoDto>> writeMemo(@RequestBody MemoDto memoDto) throws Exception {
		logger.info("writeMemo - 호출");
		memoService.writeMemo(memoDto);
		return new ResponseEntity<List<MemoDto>>(memoService.listMemo(memoDto.getArticleno()), HttpStatus.OK);
	}

	@ApiOperation(value = "댓글목록", notes = "댓글 목록을 반환한다.", response = List.class)
	@GetMapping("{articleno}")
	public ResponseEntity<List<MemoDto>> listMemo(@PathVariable("articleno") int articleno) throws Exception {
		logger.debug("listMemo - 호출");
		return new ResponseEntity<List<MemoDto>>(memoService.listMemo(articleno), HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글수정", notes = "댓글 정보를 수정한 후 댓글목록을 반환한다.", response = List.class)
	@PutMapping
	public ResponseEntity<List<MemoDto>> modifyMemo(@RequestBody MemoDto memoDto) throws Exception {
		logger.debug("modifyMemo - 호출");
		memoService.modifyMemo(memoDto);
		return new ResponseEntity<List<MemoDto>>(memoService.listMemo(memoDto.getArticleno()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "댓글삭제", notes = "댓글 정보를 삭제한 후 댓글목록을 반환한다.", response = List.class)
	@DeleteMapping("{articleno}/{memono}")
	public ResponseEntity<List<MemoDto>> deleteMemo(@PathVariable("articleno") int articleno, @PathVariable("memono") int memono) throws Exception {
		logger.debug("deleteMemo - 호출");
		memoService.deleteMemo(memono);
		return new ResponseEntity<List<MemoDto>>(memoService.listMemo(articleno), HttpStatus.OK);
	}
	
}
