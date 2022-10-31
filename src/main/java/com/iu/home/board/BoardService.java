package com.iu.home.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO> getList(Pager pager)throws Exception{
		Long totalCount = boardMapper.getCount(pager);
		pager.getRowNum();
		pager.getNum(totalCount);
		
		List<BoardVO> ar = boardMapper.getList(pager);
		return ar;
	}

}
