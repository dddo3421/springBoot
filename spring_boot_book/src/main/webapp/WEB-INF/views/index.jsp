<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index 페이지</title>
	</head>
	<body>
		<h3>MyBatis 사용 DB 연동 : 도서 관리</h3><br>
		
		<a href='<c:url value="/book/listAllBook"/>'>전체 도서 조회</a><br>
		<a href='<c:url value="/book/newBookForm"/>'>도서 등록</a><br>
		<a href='<c:url value="/book/bookSearchForm1"/>'>도서 검색</a><br>
	
	
	<hr>
	<br><br><br>
	
	
  <!-- 로그인/회원가입 링크 -->
    <c:if test="${empty sessionScope.sid}">
        <a href="<c:url value='/member/loginForm'/>">로그인</a> | 
        <a href="<c:url value='/member/joinForm'/>">회원가입</a>
    </c:if>

    <!-- 로그인 되어 있으면 환영 메시지 -->
    <c:if test="${not empty sessionScope.sid}">
        ${sessionScope.sid}님 환영합니다! 
        <a href="<c:url value='/member/logout'/>">로그아웃</a>
    </c:if>

</body>
</html>
