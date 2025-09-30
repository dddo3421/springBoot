<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품검색결과 출력</title>
</head>
<body>
		<table border="1" width="600">
			<tr><th>상품번호</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>제조사</th>
			<th>재고</th>
			<th>제조일</th>
			<th>사진</th>
			</tr>
			
			<c:choose>			
			<c:when test="${empty prdList}">
				<tr align="center"><td colspan="7">찾는 상품이 없습니다</td>			
			</c:when>
			<c:otherwise>
				<c:forEach items="${prdList}" var="prd">
				<tr>
					<td><a href="<c:url value='/product/detailViewProduct/${prd.prdNo}'/>">${prd.prdNo}</a></td>
					<td>${prd.prdName }</td>
					<td>${prd.prdPrice }</td>
					<td>${prd.prdCompany }</td>
					<td>${prd.prdStock }</td>
					<td><fmt:formatDate value="${prd.prdDate}" pattern="YYYY-MM-dd"/></td>
					<td><img src="<c:url value='/product_images/${prd.prdNo}.jpg'/>" width="30" height="20"/></td>
				</tr>
				</c:forEach>
			</c:otherwise>
			</c:choose>
						
		</table><br><br>
</body>
</html>