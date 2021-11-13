package com.spring.sideproject.recruitboard.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.sideproject.common.pager.Pager;
import com.spring.sideproject.common.pager.PagerFactory;
import com.spring.sideproject.common.pager.explorer.ListPageExplorer;
import com.spring.sideproject.common.pager.explorer.PageExplorer;
import com.spring.sideproject.recruitboard.dao.RecruitBoardDao;
import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;

@Component
public class RecruitBoardBizImpl implements RecruitBoardBiz {

	@Autowired
	private RecruitBoardDao recruitBoardDao;

	@Override
	public PageExplorer readAllRecruitBoardsBiz(RecruitBoardSearchVo recruitBoardSearchVo) {
		
		int totalCount = this.recruitBoardDao.selectAllRecruitBoardsCountDao(recruitBoardSearchVo);
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE, recruitBoardSearchVo.getPageNo() + "");
		pager.setTotalArticleCount(totalCount);
		
		PageExplorer pageExplorer = pager.makePageExplorer(ListPageExplorer.class, recruitBoardSearchVo);
		pageExplorer.setList(this.recruitBoardDao.selectAllRecruitBoardsDao(recruitBoardSearchVo));
		
		return pageExplorer;
	}

	@Override
	public boolean createOneRecruitBoardBiz(RecruitBoardVo recruitBoardVo) {
		return this.recruitBoardDao.insertOneRecruitBoardDao(recruitBoardVo) > 0;
	}
	
	
}
