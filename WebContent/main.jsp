<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 인트로 이미지 시작-->
<section id="top" class="one dark cover">

<c:forEach var="url" items="${url}" begin="0" end="0">
	<div class="container">
		<div>
			<iframe width="100%" height="700"
				src="${url.url}"></iframe>
		</div>
		<!--?autoplay=1 자동재생  크롬에서는 작동 안함 -->
		<header> reTuLix에서 제공하는 최신 리뷰를 만나보세요 </header>

		<footer>

			<a href="#portfolio" class="button scrolly">지금 영상 보러가기</a>
		</footer>
	</div>
	</c:forEach>
	
</section>
<!-- 인트로 이미지 끝-->

<!--정렬하기 시작-->
<div class="align">
	<tr>
		<td>*정렬하기</td>
		<td><select name="align" id="g_button">
				<option value="조회수순">조회수순</option>
				<option value="좋아요순">좋아요순</option>
				<option value="업로드순">업로드순</option>
		</select></td>
	</tr>
</div>
<!--정렬하기 끝	-->

<!-- 슬라이더 시작 -->

<!--시청 중인 영상-->
<section id="about" class="two">
	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">누구누구가 최근에 본 영상</h3>
		<div class="demo">
			<div class="row">
				<ul id="mvs" class="content-slider"> <!-- 아이디 바꿀 것 -->
				
	<c:forEach var="title" items="${title}">		
	 <div class="col-6 col-lg-2 animate-in-down"><a href="'+[movies[i]]+'">
	 <img src="./포스터/SF 영화/${title.title}.jpg" 
	 class="center-block img-fluid my-3" height="230px"></a></div>
 			 </c:forEach>
				</ul>
			</div>
		</div>
	</div>

	<!--찜한 영상-->
	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">나중에 볼 찜 영상</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>
	<!--최근 인기 영상-->
	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">최근 인기 영상</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>

	<!-- 장르별 영화-->

	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">코미디 영화</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>

	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">공포 영화</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>


	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">SF 영화</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>

	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">액션 영화</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>

	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">로맨스 영화</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>
	<!--드라마-->
	<div class="container-fluid" id="cslide">
		<h3 align="left" style="color: lavender">드라마</h3>
		<div class="demo">
			<div class="row">
				<ul id="content-slider" class="content-slider">

				</ul>
			</div>
		</div>
	</div>

</section>
<!-- 슬라이더 끝 -->
