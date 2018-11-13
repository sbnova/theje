<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>delete</h2>
<form action="deleteReg">
	<input type="hidden" name="id" value="${param.id }" />
	<!-- 글번호가 보이면 안되니까 text->hidden -->
	<table border="">
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<a href="detail?id=${param.id }">뒤로</a>
			<input type="reset" value="초기화" />
			<input type="submit" value="삭제" />
		</td>
		</tr>
	</table>
</form>
</body>
</html>