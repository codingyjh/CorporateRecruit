package com.spring.sideproject.resume.basicinfo.dao;

import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public interface BasicInfoDao {

	public int insertOneBasicInfoDao(BasicInfoVo basicInfoVo);
	
	public BasicInfoVo selectOneBasicInfoByResumeIdDao(int resumeId);
	
	public int selectOneBasicInfoByEmailDao(String email);
	
	public int updateOneBasicInfoDao(BasicInfoVo basicInfoVo);
	public int updateOneFinalSubmitByEmailDao(String email);
	
}
