<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Upload completed</h1>

	<div class="result-images">
	
			<c:forEach items="${list }" var="list" varStatus="status">
				<img src="${pageContext.request.contextPath}/gallery/assets/${list.video_name }" style="width:150px"><br>
			</c:forEach>

<!--  	  	<video id="vi" width="700" height="600" loop="loop" controls autoplay>
		  		
				<source type="video/mp4" src="${pageContext.request.contextPath }/${url1 }" />
			</video>-->	
	</div>

	<p>
		<a href='/videoupload'> 다시 업로드 하기 </a>
	</p>
	
</body>
</html>