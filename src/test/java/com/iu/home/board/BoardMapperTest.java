package com.iu.home.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;

//	@Test
	void insertTest()throws Exception {
		BoardVO boardVO = new BoardVO();
		for(int i = 0; i <= 100; i++) {
			boardVO.setWriter("Writer" + i);
			boardVO.setTitle("Title" + i);
			boardVO.setContents("Contents" + i);
			boardMapper.setAdd(boardVO);
		}
	}

}
