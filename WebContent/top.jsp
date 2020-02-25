<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--구독 리스트 boardList.jsp참고할것  -->
<% String ctx=request.getContextPath(); %>

<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href="./css/whole.css" />
<!-- 전체 기본 스타일 -->
<link rel="stylesheet" href="./css/topNav.css" />
<!-- 상단 내비게이션 바 스타일 -->
<link rel="stylesheet" href="./css/sideNav.css" />
<!-- 좌측 내비게이션 바 스타일 -->

<!-- 각 담당 파트별 별도 css 지정 스타일 -->
<link rel="stylesheet" href="./css/main.css" />

<!--jQuery Google CDN-------------------------->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- 아이콘 라이브러리 -->
<script src="https://kit.fontawesome.com/d9fe37202c.js"
	crossorigin="anonymous"></script>
<!-----------------------------lightslider---------------->
<link rel="stylesheet" href="css/lightslider.css" />
<!--lightslider------------------------------------------->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<!-------------------------------------------------------->


<title>reTuLix</title>
</head>
<!-- EO-head--------------------------------------------------- -->


<body>
	<!-- 세션에 저장된 loginUser 추출================================================= -->
	<form id="user" name="user">
		<input type="text" id="email" name="email">
	</form>
	<c:if test="${loginUser ne null }">
		<script>
			sessionStorage.setItem('user_email', '${loginUser.email}')
			var email=sessionStorage.getItem('user_email', '${loginUser.email}')
			$("#email").val(email);
		</script>
	</c:if>
	
	<!-- 상단바====================================================================== -->
	<div id="wrap">
		<ul class="topNav">
			<li class="topNavLeft" id="menuToggle"><i class="fa fa-bars"></i></li>
			<li class="topNavLeft"><a href="<%=ctx%>/index.do"><img src="./images/logo-01.png" alt="logo" class="retulix_logo"></a></li>

			<li class="topNavLeft"><a href="#">영화</a></li>
			<li class="topNavLeft"><a href="#">TV프로그램</a></li>
			<li class="topNavSearch">
				<form action="">
					<input id="searchbar" type="text" name="search"
						placeholder="검색어를 입력하세요"> <i class="fa fa-search"></i>
				</form>
			</li>

			<li class="topNavRight"><a href="#">로그아웃</a></li>
			<li class="topNavRight"><a href="<%=ctx%>/chDoor.do?email=${email}"><i class="fa fa-cog"></i></a></li>
			<li class="topNavRight"><a href="<%=ctx%>/admin.do"><i class="fa fa-star"></i></a></li>
		</ul>
	</div>

	<!-- 좌측바====================================================================== -->
	<div id="wrap">
		<!-- topNav에 가려지는 부분 -->
		<div class="topNavFloor"></div>

		<div class="sideNav">
			<!-- .sideNav============== -->
			<!-- 상단 로그인 회원 정보 -->
			<div class="sideNavInfo">
				<span> <img src="./images/subscribe.png" alt="회원 이미지" />
				</span>
				<h1></h1>
				<p>일반회원</p>
			</div>

			<!-- 중앙 메뉴 -->
			<div class="sideNavMenu">
				<ul>
					<li><a href="#"> <span class=""><i
								class="fa fa-home"></i>홈</span>
					</a></li>
					<li><a href="#"> <span class=""><i
								class="fa fa-star"></i>최근 인기 영상</span>
					</a></li>
					<li><a href="#"> <span class=""><i
								class="fa fa-reply"></i>최근에 본 영상</span>
					</a></li>
					<li><a href="#"> <span class=""><i
								class="fa fa-heart"></i>나중에 볼 영상</span>
					</a></li>
				</ul>

				<hr>

				<!-- 구독 리스트: 첫 로드시 최대 4행 -->
				<ul class="subscribe">
					<span class="subscribeHead">구독</span>
					<c:forEach var="sub" items="${email_subs}">
					<div class="moreSub">
					
					<li><a href="#"> <span class=""><img
								src="./images/subscribe.png"></img>${sub.email_subs}</span>
					</a></li>
					
					</div>
					</c:forEach>
				
					<li><a href="#"> <span class="more"><i
								class="fa fa-plus"></i>더보기</span>
					</a></li>
				</ul>

				<hr>
				<div class="sideNavFoot">
					<ul>
						<li><a href="#">
							<span class=""><i class="fa fa-exclamation-circle"></i>공지사항</span>
						</a></li>
						<li><a href="#">
							<span class=""><i class="fa fa-cog"></i>내 채널</span> 
						</a></li>
						<li><a href="#"> <span class=""><i
									class="fa fa-times"></i>로그아웃</span>
						</a></li>
						<hr>
						<button type="button">
							<i class="fa fa-product-hunt"></i> 포인트 충전하기
						</button>
					</ul>
				</div>
			</div>

		</div><!-- .sideNav -->
	</div><!-- #wrap -->

	<div class="main" id="main">