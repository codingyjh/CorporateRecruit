package com.spring.sideproject.resume.basicinfo.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.basicinfo.dao.BasicInfoDao;
import com.spring.sideproject.resume.basicinfo.vo.BasicInfoVo;

@Component
public class BasicInfoBizImpl implements BasicInfoBiz{

	@Autowired
	private BasicInfoDao basicInfoDao;
	
	@Override
	public boolean createOneBasicInfoBiz(BasicInfoVo basicInfoVo) {
		return this.basicInfoDao.insertOneBasicInfoDao(basicInfoVo) > 0;
	}

	@Override
	public int readOneBasicInfoByResumeIdBiz(String email) {
		return this.basicInfoDao.selectOneBasicInfoByResumeIdDao(email);
	}

}
