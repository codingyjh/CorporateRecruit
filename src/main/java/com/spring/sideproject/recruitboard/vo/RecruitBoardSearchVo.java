package com.spring.sideproject.recruitboard.vo;

import com.spring.sideproject.common.pager.annotations.EndRow;
import com.spring.sideproject.common.pager.annotations.StartRow;

public class RecruitBoardSearchVo {

	private int pageNo;

	private String searchKeyword;

	@StartRow
	private int startRow;

	@EndRow
	private int endRow;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

}
