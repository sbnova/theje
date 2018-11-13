<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>insertForm</h2>
<form action="insertReg" method="post" enctype="multipart/form-data">
					<!-- 파일전송을 위함 : method="post" enctype="multipart/form-data" -->
	<table border="">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="pname" /></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" /></td>
		</tr>
		<tr>
			<td>파일</td>
			<td><input type="file" name="upfileMM" /></td> <!-- file은 file로 해야한다-->
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" rows="5" cols="20"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="작성"/>
				<input type="reset" value="초기화"/>
				<a href="list">목록으로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>