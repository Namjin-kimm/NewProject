package com.iu.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long startRow;
	private Long perPage;
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	//검색어
	private String search;
	//종류(writer, title, contents)
	private String select;
	
	public String getSelect() {
		if(this.select == null) {
			this.select = "contents";
		}
		return this.select;
	}
	
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return this.search;
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return this.page;
	}
	
	private Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		return this.perPage;
	}
	
	private Long getPerBlock() {
		this.perBlock = 5L;
		return this.perBlock;
	}
	
	//RowNum 구하기,mapper에서 사용할 값
	public void getRowNum() {
		this.startRow = (this.getPage() - 1)* this.getPerPage();
	}
	
	//startnum, lastnum 구하기
	public void getNum(Long totalCount)throws Exception{
		//1. totalCount로 totalPage 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//1-1. totalPage보다 getPage가 더 클 경우
		if(this.getPage() > totalPage) {
			this.setPage(totalPage);
		}
		
		//2. totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//3. Page로 curBlock 구하기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//4. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock - 1) * this.getPerBlock() + 1;
		this.lastNum = curBlock * this.getPerBlock();
		
		//5. curBlock이 마지막 Block 일 때
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		//6. 이전,다음 블럭 유무
		if(curBlock > 1) {
			pre = true;
		}
		
		if(curBlock < totalBlock) {
			next = true;
		}
	}
	
	
	

}
