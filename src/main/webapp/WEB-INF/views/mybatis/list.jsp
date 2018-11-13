<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
<h2>list</h2>
<%-- ${data} --%>
<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<table class ="table table-bordered">
				<tr>
			      <td colspan="5" align="center">
			         <form action="?" method="post">
			              <div class="input-group">
			                   <span class="input-group-addon">제목 :</span>
			                   <input type="text" class="form-control" name="sch" placeholder="검색어를 입력하세요">
			                   <button type="submit" class="btn btn-primary">검색</button>
			            </div>
			
			         </form>
			      </td>
			    </tr>
			    <tr>
					<td colspan="5" align="center">
						<form action="?"><!-- 자기 자신한테 돌아온다 -->
						제목<input type="text" name="sch" />
							<input type="submit" value="검색"/></form>
					</td>
				</tr>
				<tr class="bg-primary">
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>조회수
						<form action="?"><!-- 자기 자신한테 돌아온다 -->
						<input type="text" name="cnt" size="3"/><br>
						<input type="radio" name="cntType" value=">=" checked="checked">이상
						<input type="radio" name="cntType" value="<=" >이하<br>
							<input type="submit" value="검색"/></form>
					</td>
				</tr>
			<c:forEach items="${data }" var="dd" varStatus="no">	
				<tr>
					<td>${no.index }</td>
					<td><a href="detail?id=${dd.id }">${dd.title }</a></td>
					<td>${dd.pname }</td>
					<td>${dd.reg_dateStr }</td>
					<td>${dd.cnt }</td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="5" align="right">
						<a href="insertForm">글쓰기</a>
						<a href="insertMulti">다중글쓰기</a>
						<a href="insertError">에러글쓰기</a>
					</td>
				</tr>
			 </table>
		</div>
	</div>
</div>
<table border="">
	
</table>
</body>
</html>