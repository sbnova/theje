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
<h2>insertMulti</h2>
<form action="insertErrorReg" method="post" >
					<!-- 파일전송을 위함 : method="post" enctype="multipart/form-data" -->
	<table border="">
		<tr>
			<td>id</td>
			<td>제목</td>		
		</tr>
<c:forEach begin="0" end="2" var="i">
		<tr>			
			<td><input type="text" name="mem[${i }].id" /></td>
			<td><input type="text" name="mem[${i }].title" /></td>
		</tr>
</c:forEach>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="작성"/>
				<input type="reset" value="초기화"/>
				<a href="list">목록으로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>