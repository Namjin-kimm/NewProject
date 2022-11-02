package com.iu.home.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.home.util.Pager;

@Mapper
public interface BoardMapper {
	//글의 총갯수 구하기
	public Long getCount(Pager pager)throws Exception;
	
	//리스트 불러오기
	public List<BoardVO> getList(Pager pager)throws Exception;
	
	//글쓰기
	public int setAdd(BoardVO boardVO)throws Exception;
	
	//파일 추가
	public int setAddFile(BoardFileVO boardFileVO)throws Exception;

}
