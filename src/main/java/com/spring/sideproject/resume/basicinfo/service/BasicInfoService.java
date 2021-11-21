package com.spring.sideproject.resume.basicinfo.service;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

public interface BasicInfoService {

	public boolean createOneResumeInfoService(BasicInfoVo basicInfoVo, RecruitMemberVo recruitMemberVo, int boardId);
	
	public int readOneBasicInfoByResumeIdService(String email);
}
