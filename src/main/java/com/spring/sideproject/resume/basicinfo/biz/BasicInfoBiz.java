package com.spring.sideproject.resume.basicinfo.biz;

import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public interface BasicInfoBiz {
	
	public boolean createOneBasicInfoBiz(BasicInfoVo basicInfoVo);
	
	public BasicInfoVo readOneBasicInfoByResumeIdBiz(int resumeId);
	public int readOneBasicInfoByEmailBiz(String email);
	
	public boolean updateOneBasicInfoBiz(BasicInfoVo basicInfoVo);
	public boolean updateOneFinalSubmitByEmailBiz(String email);
}
