<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">

$(function(){
	
	$("#left").click(function(){
		$.ajax({
			url:"http://150.95.141.66/test/cgi-bin/RemoteMotor.py",
			type:"post",
			data: { remote:"left"},
			success: function(){
				console.log("success");
			},
			error : function(jqXHR, status, e) {
			console.log(status + ":" + e);
			}			
		});
	});
	
	$("#center").click(function(){
		$.ajax({
			url:"http://150.95.141.66/test/cgi-bin/RemoteMotor.py",
			type:"post",
			data: { remote : "center" },
			success: function(){
				console.log("success");
			},
			error : function(jqXHR, status, e) {
			console.log(status + ":" + e);
			}			
		});
	});
	
	$("#right").click(function(){
		$.ajax({
			url:"http://150.95.141.66/test/cgi-bin/RemoteMotor.py",
			type:"post",
			data: { remote:"right"},
			success: function(){
				console.log("success");
			},
			error : function(jqXHR, status, e) {
			console.log(status + ":" + e);
			}			
		});
	});
})

</script>
<title>Insert title here</title>
</head>
<body>
<button id="left">Left</button>
<button id="center">Center</button>
<button id="right">Right</button>
</body>
</html>