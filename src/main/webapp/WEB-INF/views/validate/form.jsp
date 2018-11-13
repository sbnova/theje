<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- form>table>tr*3>td+td>input[name]> -->
<form action="" method="post">
	<table border="">
		<tr>
			<td>id</td>
			<td><input type="text" name="id" />
			<form:errors path="stud.id" /> <!-- 에러의 경로를 가져오겟다 -->
			</td>
		</tr>
		<tr>
			<td>pw</td>
			<td><input type="text" name="pw" />
			<form:errors path="stud.pw" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인" />
				<input type="reset" value="초기화" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>