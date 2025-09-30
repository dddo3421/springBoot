<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello 페이지</title>
</head>
<body>
	hello.jsp 페이지 입니다<br>
	${message}<br>
	<!--  static 폴더의 uri 매핑은 / 
	      http://localhost:8080
		  이미지경로 : /image/apple.png
	-->
	<img src="/image/apple.png"><br>
	<img src="<c:url value='/image/apple.png'/>">
	
</body>
</html>