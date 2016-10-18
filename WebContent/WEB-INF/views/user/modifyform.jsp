<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.bit2016.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	UserVo userVo = (UserVo)request.getAttribute("userVo");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/user.css" 
	rel="stylesheet" type="text/css"><!-- ${pageContext.request.contextPath } -->
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="user">

				<form id="join-form" name="modifyform" method="post" action="/mysite3/user">
					<input type="hidden" name ="a" value="modify"/>
					<input type="hidden" name = "no" value = "<%=userVo.getNo()%>"/>
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="<%=userVo.getName()%>"/>

					<label class="block-label" for="email">이메일</label>
					<Strong> <%=userVo.getEmail() %></Strong>
										
					<label class="block-label">패스워드</label>
					<input name="password" type="password" value="">
					
					<fieldset>
						<legend>성별</legend>
						<c:choose>				
						<c:when test="${'male' == param.gender  }">
						<label>여</label> <input type="radio" name="gender" value="female" >
						<label>남</label> <input type="radio" name="gender" value="male" checked="checked">
						</c:when>
						<c:otherwise>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
						</c:otherwise>
						</c:choose>
					</fieldset>
					
					<input type="submit" value="수정하기">
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
</body>
<c:if test="${'success' == param.update }">
<script > 
alert("성공 정보수정")
</script>
</c:if>
</html>