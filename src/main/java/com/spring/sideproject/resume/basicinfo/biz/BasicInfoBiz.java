package com.spring.sideproject.resume.basicinfo.biz;

import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public interface BasicInfoBiz {
	
	public boolean createOneBasicInfoBiz(BasicInfoVo basicInfoVo);
	
	public int readOneBasicInfoByResumeIdBiz(String email);
}
