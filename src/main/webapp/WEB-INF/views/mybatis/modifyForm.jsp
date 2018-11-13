<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ModifyForm</h2>
<form action="modifyReg" method="post" enctype="multipart/form-data">
					<!-- 파일전송을 위함 : method="post" enctype="multipart/form-data" -->
<input type="hidden" name="id" value="${data.id }" />
<!-- 이 문구가 있어야 헷갈리지 않고 정확한거 수정한다 -->
	<table border="">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${data.title }"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="pname" value="${data.pname }"/></td>
		</tr>
		<tr>
			<td>암호</td>
			<td><input type="text" name="pw" /></td>
		</tr>
		<!-- <tr>
			<td>파일</td>
			<td><input type="file" name="upfileMM" /></td> file은 file로 해야한다
		</tr> -->	 
		<tr>
			<td>내용</td>
			<td><textarea name="content" rows="5" cols="20">${data.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="수정"/>
				<input type="reset" value="초기화"/>
				<a href="detail?id=${data.id }">뒤로</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>