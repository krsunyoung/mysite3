<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page contentType="text/html;charset=UTF-8" %>
<%
	pageContext.setAttribute("newLine", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script> 
var isEnd = false;
var page=0;
var render = function(vo){
	var htmls=
		"<li>"+
		"<strong>" +vo.name +"</strong>"+
		"<p>"+vo.content+"</p>"+
		"<strong>"+vo.regDate+"</strong>"+
		"<a href='/mysite3/guestbook?a=deleteform&no="+vo.no+"'>삭제</a>"+
		"</li>";
		
		$("#list-guestbook").append(htmls);
}
var fetchList = function(){
	if(isEnd ==true){
		return;
	}
	++page;
	$.ajax({
		url :"${pageContext.request.contextPath }/api/guestbook?a=ajax-list&p="+page,
		type : "get",
		dataType: "json",
		success:function(response){
			if(response.result != "success"){
				console.error(response.message);
				isEnd=true;
				return;
			}
			//redering
			$(response.data).each(function(index, vo){
				render(vo);				
			});
			
			if(response.data.length<5){ 
				isEnd=true;
				$("#btn-fetch").prop("disabled",true);
			}
		}, error: function(jqXHR, status, e){
			console.error(status +":"+e);
		}
	})
}
$(function(){
	$("#add-form").submit(function(event){
		event.preventDefault();
		
		//ajax insert
	})
	$(window).scroll(function(){
		var $window = $(this);
		var scrollTop = $window.scrollTop(); // 브라우저에서 위에서 부터 scroll회색 나타나기 전까지 그부분 길이 
		var windowHeight=$window.height(); // 브라우저 height 길이
		var documentHeight=$(document).height();
		//스크롤 바가 바닥까지 왔을 때
		if(scrollTop+windowHeight +20 > documentHeight){
			fetchList();
		}
		//console.log(scrollTop+":"+windowHeight+":"+documentHeight);
	})
	$("#btn-fetch").click(function(){
		fetchList();
	})
		//1번째 리스트 가져오기
		fetchList();
})

</script>
</head>
<body>
	<div id="container">
	<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="guestbook" class="">
				<form  id ="add-form" action="${pageContext.request.contextPath }/guestbook" method="post">
					<input type="hidden" name="a" value="insert">
					<table class = "write-form">
						<tr>
						</tr>
						<tr>
							<td><input type="text" name="name" placeholder="이름을 입력하세요"></td>
						</tr>
						<tr>
							<td><input type="password" name="pass" placeholder="비밀번호를 입력하세요"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content" placeholder="소감을 작성하시오"></textarea></td>
						</tr>
						<tr >
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul id="list-guestbook">
				
				<%-- <c:set var="count" value="${fn:length(list) }"/> 
				<c:forEach items="${list }" var="vo" varStatus="status">
					<li>
						<table border=1 class="read">
							<tr>
								<td>[${count-status.index }]</td>
								<td>[${vo.name }]</td>
								<td>[${vo.req_date }]</td>
								<td class='delete-td' rowspan=2 align=center>
								<a href="${pageContext.request.contextPath }/guestbook?a=deleteform&no=${vo.no }"> 
									<input type="image" src="/mysite3/assets/images/delete2.png" >  </a>
								</td>
							</tr>
							<tr>
								<td colspan=3>${fn:replace(vo.content, newLine, "<br>") }</td>
							</tr>
						</table>
						<br>
					</li>
				</c:forEach> --%>
				</ul>
				<button style="margin-top:20px;" id="btn-fetch">가져오기</button>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="guestbook-ajax"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>