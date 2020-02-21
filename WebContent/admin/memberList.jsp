<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/admin/adminTop.jsp"/>

<!-- ------------------------------------------------------- -->
<div class='box'>
		<h2 class='head'>회원 목록</h2>
</div>
<form action="memberSearch.do" name="searchForm" method="POST">
	<div class='box'>
		<select class='' name="selectBox">
			<option value='email'>이메일</option>
			<option value='name'>이름</option>
			<option value='state'>회원상태</option>
		</select>
		<input type='text' name="searchInput" class=''>
		<button type='button' onclick='goSearch()'>검색</button>
	</div>
</form>
<!-- ----------------------------------------------------- -->
<div class="outer">
<div class="tableContainer">
	<table class="table">
		<thead>
			<tr>
				<th>#</th>
				<th>이메일</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>나이</th>
				<th>포인트</th>
				<th>상태</th>
				<th>업로드</th>
			</tr>
		</thead>
		<tbody>
			<core:forEach var="list" items="${listMember}">
				<tr>
					<td><a href='memberEdit.do?email=${list.email}'><i class="fa fa-edit"></i></a></td>
					<td>${list.email}</td>
					<td>${list.name}</td>
					<td>${list.pwd}</td>
					<td>${list.age}</td>
					<td>${list.point}</td>
					<td>${list.state}</td>
					<td><a href='memberContent.do?email=${list.email}'><i class="fa fa-eye"></i></a></td>
				</tr>
			</core:forEach>
		</tbody>
	</table>
	<div class='box'>
		${pageNavi}
	</div>
</div>
</div>

<script>
function goSearch() {
	searchForm.submit();
}
</script>

<jsp:include page="/foot.jsp" />