<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib	prefix="form" uri="http://www.springframework.org/tags/form" %>
<%-- <%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>        --%>

<link rel="stylesheet" href="<c:url value='/css/recruitBoard/recruitBoardList.css' />">

<title>채용공고 페이지</title>

<div class="container">
	<div class="jumbotron">
		<h1 class="text-center">채용공고</h1>
		<p class="text-center">OO 기업의 채용공고 게시판 입니다.</p>
	</div>
	<form:form id="searchForm" onsubmit="javascript:movePage(0);">
    	<div class="col-lg-12">
           <h1 class="page-header">채용공고 게시판 </h1>
           <input type="text" name="searchKeyword" value="${recruitBoardSearchVo.searchKeyword}" />
           <input type="submit" class="btn btn-primary" value="검색" onsubmit="javascript:movePage(0);"/>			   
		   <a href="<c:url value='/recruitBoard/recruitBoardInit.do' />" class="btn btn-primary" type="button">검색 초기화</a>
		   <a href="<c:url value='/recruitBoard/recruitBoardWrite.do' />" class="btn btn-primary btn-warning pull-right" type="button" >글 작성</a>
        </div>
        <div class="col-lg-12"><!--게시판 넓이 -->
            <div class="panel panel-default">
                <div class="panel-heading">채용공고 </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>채용 마감기간</th>
                                <th>작성일</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                        	<c:when test="${not empty recruitBoardVoList}">
                        		<c:forEach items="${recruitBoardVoList}" var="recruitBoard">
		                            <tr>
		                                <td>${recruitBoard.boardId}</td>			                                
		                                <td><a href="<c:url value='/recruitBoard/recruitBoardDetail.do/${recruitBoard.boardId}' />">${recruitBoard.title}</a></td>			                                
		                                <td>${recruitBoard.recruitMemberVo.name}</td>
		                                <td>${recruitBoard.recruitDt}</td>		                                
		                                <td>${recruitBoard.wrtDt}</td>
		                                <td>${recruitBoard.hit}</td>
		                            </tr>
                       		 	</c:forEach>
                        	</c:when>
                        	<c:otherwise>
								<tr>
									<td>등록된 게시글이 없습니다.</td>
								</tr>
							</c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
			<div class="paginationDiv">
				<ul class="pagination">
					<li>${pagenation}</li>
				</ul>
			</div>
        </div>
	</form:form>
</div>