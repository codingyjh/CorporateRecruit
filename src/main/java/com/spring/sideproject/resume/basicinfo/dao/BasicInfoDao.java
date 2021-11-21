package com.spring.sideproject.resume.basicinfo.dao;

import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public interface BasicInfoDao {

	public int insertOneBasicInfoDao(BasicInfoVo basicInfoVo);
	
	public int selectOneBasicInfoByResumeIdDao(String email);
}
