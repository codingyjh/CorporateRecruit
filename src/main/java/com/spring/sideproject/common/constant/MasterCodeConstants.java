package com.spring.sideproject.common.constant;

public interface MasterCodeConstants {

	//Redirect URL
	public static final String REDIRECT_RECRUIT_MEMBER_LOGIN 				= "redirect:/recruitMember/recruitMemberLogin.do";
	public static final String REDIRECT_COMPANY_MAIN 						= "redirect:/companyMain/main.do";
	public static final String REDIRECT_RECRUIT_BOARD_LIST 					= "redirect:/recruitBoard/recruitBoardList.do";
	public static final String REDIRECT_RECRUIT_BOARD_DETAIL				= "redirect:/recruitBoard/recruitBoardDetail.do";
	public static final String REDIRECT_RESUME_BASIC_INFO					= "redirect:/resume/basicInfo.do";
	public static final String REDIRECT_RESUME_ACADEMY_BACKGROUND 			= "redirect:/resume/academicBackground.do";
	public static final String REDIRECT_RESUME_QUALIFICATION_AND_EDUCATION 	= "redirect:/resume/qualificationAndEducation.do"; 
	public static final String REDIRECT_RESUME_QUALIFICATION_EXPERIENCE 	= "redirect:/resume/qualificationExperience.do"; 
	public static final String REDIRECT_RESUME_SELF_INTRODUCE 				= "redirect:/resume/selfIntroduce.do"; 
	public static final String REDIRECT_RESUME_FINAL_SUBMISSION_AGREEEMENT 	= "redirect:/resume/finalSubmissionAgreement.do"; 
	public static final String REDIRECT_RESUME_FINISH_RESUME 				= "redirect:/resume/finishResume.do"; 
	public static final String REDIRECT_RECRUITMENT_QUESTION 				= "redirect:/recruitmentQuestion/recruitmentQuestion.do"; 
	
	
	//Interceptor URL
	public static final String INTERCEPTOR_COMPANY_MAIN 					= "/companyMain/main.do";
	public static final String INTERCEPTOR_RECRUIT_MEMBER_LOGIN 			= "/recruitMember/recruitMemberLogin.do";
	
	//다운로드 URL
	public static final String RECRUIT_BOARD_IMAGE_DOWNLOADED 				= "/recruitBoard/recruitBoardImageDownloaded.do/";
	
	//View 경로
	public static final String VIEW_RESUME_BASIC_INFO						= "pc/resume/basicInfo";
	public static final String VIEW_RESUME_SELF_INTRODUCE					= "pc/resume/selfIntroduce";
	public static final String VIEW_RECRUITMENT_QUESTION					= "pc/recruitmentQuestion/recruitmentQuestion";
	
	//마스터 코드
	public static final String URL 				= "url";
	public static final String UPLOADED 		= "uploaded";
	public static final String UPLOAD 			= "upload";
	
	public static final String IMAGE_JPG_PATH 	= "image/jpg";
	public static final String IMAGE_BMP_PATH 	= "image/bmp";
	public static final String IMAGE_JPEG_PATH 	= "image/jpeg";
	public static final String IMAGE_GIF_PATH 	= "image/gif";
	public static final String IMAGE_PNG_PATH 	= "image/png";
	
	public static final String COUNT			= "count"; // 개수
	public static final String EMAIL			= "email"; // 이메일
	public static final String PASSWORD			= "password"; // 비밀번호
	
	public static final String ROLE_USER		= "ROLE_USER"; // 사용자 권한
	public static final String ROLE_ADMIN		= "ROLE_ADMIN"; // ADMIN 권한
	
	public static final String YN_Y				= "Y";
	public static final String YN_N				= "N";
	
	public static final String FILE				= "file";
	
}
