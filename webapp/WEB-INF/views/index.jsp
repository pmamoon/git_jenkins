<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  

<%
	pageContext.setAttribute("newLine", "\n");
%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<img src="${ pageContext.servletContext.contextPath }/assets/images/1.jpg">
	<form action="/guestbook/main/" method="post">
		<table border="1" width="500">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<br>
	
	<c:set var="count" value="${fn:length(list)}" />
	<c:forEach items="${list }" var="vo" varStatus="status" >
		<table width="510" border="1">
			<tr>
				<td>[${count - status.index}]</td>
				<td>${vo.name }</td>
				<td>${vo.regDate }</td>
				<td><a href="/guestbook/main/deleteform?no=${vo.no }">삭제</a></td>
			</tr>
			<tr>
				<!-- 개행(\n)을 JSTL에서 사용할 수 없어서 page context에 다른 변수로 추가해줘야함 -->
				<td>${fn:replace(vo.content, newLine, "<br>") }</td>
			</tr>
		</table>
		<br>
	</c:forEach>
</body>
</html>