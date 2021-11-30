<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="<c:url value='/css/recruitBoard/recruitBoardDetail.css' />">

<title>채용공고 페이지</title>
	
<!-- 채용공고 상세페이지 화면 구성 -->
<div class="container">
	 <h1 class="page-header">채용공고</h1>
	 <table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th colspan="6"><h4>게시물 보기</h4></th>
			</tr>
			<tr>
				<td class="tdStyle"><h5>제목</h5></td>
				<td colspan="5"><h5>${recruitBoardVo.title}</h5></td>
			</tr>
			<tr>
				<td class="tdStyle"><h5>작성자</h5></td>
				<td colspan="5"><h5>${recruitBoardVo.recruitMemberVo.name}</h5></td>
			</tr>
			<tr>
				<td class="tdStyle"><h5>채용마감</h5></td>
				<td><h5>${recruitBoardVo.recruitDt}</h5></td>
				<td class="tdStyle"><h5>작성날짜</h5></td>
				<td><h5>${recruitBoardVo.wrtDt}</h5></td>
				<td class="tdStyle"><h5>조회수</h5></td>
				<td><h5>${recruitBoardVo.hit}</h5></td>
			</tr>
			
			<tr>
				<td class="tdStyleContent"><h5>채용자료</h5></td>
				<td colspan="5">
				<c:if test="${not empty recruitBoardVo.originFileName}">
					<p>							
						<a href="<c:url value='/recruitBoard/recruitBoardFileDownload.do/${recruitBoardVo.boardId}' />">
							${recruitBoardVo.originFileName}
						</a>							
					</p>
				</c:if>
				</td>
			</tr>
			<tr>
				<td class="tdStyleContent"><h5>글 내용</h5></td>
				<td colspan="5" style="text-align: left;"><h5>${recruitBoardVo.content}</h5></td>
			</tr>
		</thead>
   		<tbody>
   			<tr>
   				<td colspan="6" style="text-align: right;">
        			<a href="<c:url value='/recruitBoard/recruitBoardUpdate.do/${recruitBoardVo.boardId}?token=${sessionScope._CSRF_TOKEN_}' />" class="btn btn-primary btn-warning" type="button" >수정</a>	         				
        			<a href="<c:url value='/recruitBoard/recruitBoardDelete.do/${recruitBoardVo.boardId}?token=${sessionScope._CSRF_TOKEN_}' />" class="btn btn-primary btn-warning" type="submit" onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>
       				<a href="<c:url value='/recruitBoard/recruitAgreement.do/${recruitBoardVo.boardId}' />" class="btn btn-primary" type="button" >지원하기</a>         				
   					<a href="<c:url value='/recruitBoard/recruitBoardList.do' />" class="btn btn-primary" type="button" >목록</a>     					     					   					
   				</td>
   			</tr>
   		</tbody>
	</table>
</div>