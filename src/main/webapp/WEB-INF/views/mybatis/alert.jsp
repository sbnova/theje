<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	alert('${status.msg}'); // data를 물고 들어온다. -> data를 받지않고 status를 가져오므로(상태)
	location.href = '${status.url}' // data 가져온곳의 url로 이동
</script>
</body>
</html>