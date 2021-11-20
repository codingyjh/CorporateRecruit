package com.spring.sideproject.recruitboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sideproject.recruitboard.vo.RecruitBoardSearchVo;
import com.spring.sideproject.recruitboard.vo.RecruitBoardVo;
import com.spring.sideproject.recruitmember.vo.RecruitMemberVo;

@Repository
public class RecruitBoardDaoImplMybatis extends SqlSessionDaoSupport implements RecruitBoardDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	@Override
	public int selectAllRecruitBoardsCountDao(RecruitBoardSearchVo recruitBoardSearchVo) {
		return getSqlSession().selectOne("RecruitBoardDao.selectAllRecruitBoardsCountDao", recruitBoardSearchVo);
	}	
	
	@Override
	public List<RecruitMemberVo> selectAllRecruitBoardsDao(RecruitBoardSearchVo recruitBoardSearchVo) {
		return getSqlSession().selectList("RecruitBoardDao.selectAllRecruitBoardsDao", recruitBoardSearchVo);
	}

	@Override
	public int insertOneRecruitBoardDao(RecruitBoardVo recruitBoardVo) {
		return getSqlSession().insert("RecruitBoardDao.insertOneRecruitBoardDao", recruitBoardVo);
	}

	@Override
	public RecruitBoardVo selectOneRecruitBoardDao(int boardId) {
		return getSqlSession().selectOne("RecruitBoardDao.selectOneRecruitBoardDao", boardId);
	}	
	
	@Override
	public int updateHitOneRecruitBoardDao(int boardId) {
		return getSqlSession().update("RecruitBoardDao.updateHitOneRecruitBoardDao", boardId);
	}

	@Override
	public int updateOneRecruitBoardDao(RecruitBoardVo recruitBoardVo) {
		return getSqlSession().update("RecruitBoardDao.updateOneRecruitBoardDao", recruitBoardVo);
	}

	@Override
	public int deleteOneRecruitBoardByBoardIdDao(int boardId) {
		return getSqlSession().delete("RecruitBoardDao.deleteOneRecruitBoardByBoardIdDao", boardId);
	}

}
