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
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

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

	@Override
	public boolean updateOneHitRecruitBoardBiz(int boardId) {
		return this.recruitBoardDao.updateHitOneRecruitBoardDao(boardId) > 0;
	}

	@Override
	public RecruitBoardVo readOneRecruitBoardBiz(int boardId, RecruitMemberVo recruitMemberVo) {
		
		// 채용공고 게시물 조회
		RecruitBoardVo recruitBoard = this.recruitBoardDao.selectOneRecruitBoardDao(boardId);
		
		if ( !recruitBoard.getEmail().contentEquals(recruitMemberVo.getEmail()) ) {
			// 조회 수  증가
			this.recruitBoardDao.updateHitOneRecruitBoardDao(boardId);
			
			// 조회 수 증가 후 게시글 다시 조회
			recruitBoard = this.recruitBoardDao.selectOneRecruitBoardDao(boardId);
		}
		return recruitBoard;
	}
	
	
}
