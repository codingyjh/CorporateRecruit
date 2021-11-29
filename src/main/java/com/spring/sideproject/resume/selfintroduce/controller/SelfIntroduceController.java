package com.spring.sideproject.resume.selfintroduce.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sideproject.common.session.Session;
import com.spring.sideproject.common.utils.HttpRequestHelper;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;
import com.spring.sideproject.resume.selfintroduce.service.SelfIntroduceService;
import com.spring.sideproject.resume.selfintroduce.vo.SelfIntroduceVo;

@Controller
public class SelfIntroduceController {

	@Autowired
	private SelfIntroduceService selfIntroduceService;
	
	@GetMapping("/resume/selfIntroduce.do/{resumeId}")
	public ModelAndView viewSelfIntroducePage(
			@PathVariable int resumeId) {

		SelfIntroduceVo selfIntroduce = this.selfIntroduceService.readOneSelfIntroduceByResumeIdService(resumeId);
		ModelAndView view = new ModelAndView(HttpRequestHelper.getJspPath());
		view.addObject("selfIntroduceVo", selfIntroduce);
		
		return view;
	}
	
	@PostMapping("/resume/selfIntroduceTempSave.do")
	@ResponseBody
	public Map<Object, Object> doSelfIntroduceTempSaveAction(
			@ModelAttribute SelfIntroduceVo selfIntroduceVo
			,@SessionAttribute(Session.USER) RecruitMemberVo recruitMemberVo) {
		
		String email = recruitMemberVo.getEmail();
		selfIntroduceVo.setEmail(email);
		selfIntroduceVo.setRecruitMemberVo(recruitMemberVo);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean isTempSaveCheck = this.selfIntroduceService.updateOneSelfIntroduceService(selfIntroduceVo);
		
		if ( !isTempSaveCheck == true ) {
			map.put("fail", isTempSaveCheck);
			return map;
		}
		
		map.put("success", isTempSaveCheck);
		return map;
	}
}
