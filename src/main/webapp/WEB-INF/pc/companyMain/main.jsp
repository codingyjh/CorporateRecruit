<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     


<link rel="stylesheet" href="<c:url value='/css/main/main.css' />">	
<title>기업 메인 페이지</title>

	
<div class="container">
   	<div id="myCarousel" class="carousel slide" data-ride="carousel">
   		<ol class="carousel-indicators">
   			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
   			<li data-target="#myCarousel" data-slide-to="1"></li>
   			<li data-target="#myCarousel" data-slide-to="2"></li>
   		</ol>
   		<div class="carousel-inner">
   			<div class="item active">	    		
   				<img src="<c:url value='/images/main/jpg/mainSlide1.jpg' />" style="width: 1400px; height: 300px;">	    				
   			</div>
   			<div class="item">
   				<img src="<c:url value='/images/main/jpg/mainSlide2.jpg' />" style="width: 1400px; height: 300px;">	    				
   			</div>
   			<div class="item">
   				<img src="<c:url value='/images/main/jpg/mainSlide3.jpg' />" style="width: 1400px; height: 300px;">	    				
   			</div>
   		</div>
   		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
   			<span class="glyphicon glyphicon-chevron-left"></span>
   		</a>
   		<a class="right carousel-control" href="#myCarousel" data-slide="next">
   			<span class="glyphicon glyphicon-chevron-right"></span>
   		</a>
   	</div>
   	<br />
   	<br />
   	<div class="row">
		<div class="col-md-4">
			<div class="imgDiv">
				<img src="<c:url value='/images/main/jpg/mainIcon1.jpg' />">						
			</div>
			<h3>Future Technologies</h3>
			<h4>OO 기업은</h4>
			<h4>혁신적인 서비스를 통해</h4>
			<h4>우리의 삶을 변화시키고 있습니다.</h4>
		</div>
		<div class="col-md-4">
			<div class="imgDiv">
				<img src="<c:url value='/images/main/jpg/mainIcon2.jpg' />">					
			</div>
			<h3>IT Distribution</h3>
			<h4>OO 기업은 고객이 필요로 하는</h4> 
			<h4>모든 솔루션을 준비합니다.</h4>
			<h4>최고의 파트너들과 함께 변화합니다.</h4>
		</div>
		<div class="col-md-4">
			<div class="imgDiv">
				<img src="<c:url value='/images/main/jpg/mainIcon3.jpg' />">						
			</div>
			<h3>Enterprice IT Service</h3>
			<h4>OO 기업은</h4>
			<h4>고객의 성공을 책임지는</h4>
			<h4>IT 서비스를 제공합니다.</h4>
		</div>
	</div>
	<br />
	<br />
	<div class="row">
		<div class="col-sm-4">
			<div class="thumbnail">
				<img src="<c:url value='/images/main/jpg/mainThumnail1.jpg' />">						
		        <div class="caption">
		          <h3>기업정보 </h3>
		          <h4>IT의 신기술을 지향하는 OO 기업은</h4>
		          <h4>스마트한 세상을 향하며 달려가고 있습니다.</h4>
		          <p><a href="<c:url value='/companyInfo/introduce' />" class="btn btn-primary">자세히 알아보기</a></p>				          
		        </div>
		     </div>
		</div>					
		<div class="col-sm-4">
			<div class="thumbnail">
				<img src="<c:url value='/images/main/jpg/mainThumnail2.jpg' />">						
		        <div class="caption">
		          <h3>채용정보 </h3>
		          <h4>여러분의 빛나는 미래를 위한 첫걸음,</h4>
		          <h4>OO 기업이 당신의 열정과 함께 합니다.</h4>
		          <p><a href="<c:url value='/recruitInfo/recruitmentGuide' />" class="btn btn-primary">자세히 알아보기</a></p>				          
		        </div>
		     </div>
		</div>
		<div class="col-sm-4">
			<div class="thumbnail">
				<img src="<c:url value='/images/main/jpg/mainThumnail3.jpg' />">
		        <div class="caption">
		          <h3>채용공고 </h3>
		          <h4>OO 기업은 도전과 열정을 넘치는</h4>
		          <h4>여러분의 입사 지원을 기다리고 있습니다</h4>
		        </div>
		     </div>
		</div>
	</div>
</div>