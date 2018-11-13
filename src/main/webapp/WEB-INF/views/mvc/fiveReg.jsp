<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
왔다!!!!<br>
이름:${exam.name }<br>
<c:forEach var="no" begin="0" end="2">
${exam.title(no) } <br>
<%-- <c:forEach items="${exam.jum}" var="jj" varStatus="no">
${exam.title(no.index) } : ${jj }<br> --%>
</c:forEach>
국어:${exam.jum[0] }<br>
영어:${exam.jum[1] }<br>
수학:${exam.jum[2] }<br>
</body>
</html>