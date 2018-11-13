<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- form>table>tr*5>td+td>input[name]>  태그 사용방법 -->
<form action="", method="post">
	<table border=1>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>국어</td>
			<td><input type="text" name="jum" /></td>
		</tr>
		<tr>
			<td>영어</td>
			<td><input type="text" name="jum" /></td>
		</tr>
		<tr>
			<td>수학</td>
			<td><input type="text" name="jum" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="submit" name="입력" /></td>
		</tr>
	</table>
</form>
</body>
</html>