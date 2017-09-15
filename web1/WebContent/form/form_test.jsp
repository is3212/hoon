<%@ include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>get parameter 방식</p>
<form action="test.formtest" method="get">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="text" name="pwd"><br>
<input type="submit" value="전송" >
</form>

<p>POST JSON 방식</p>
<form action="test.formtest" method="post">
아이디 : <input type="text" name="id" id="id2"><br>
비밀번호 : <input type="text" name="pwd" id="pwd2"><br>
<input type="button" value="전송" id="btn">
</form>
<script>
$("#btn").click(function(){
	var params={};
	params["id"]=$("#id2").val();
	params["pwd"]=$("#pwd2").val();
	params=JSON.stringify(params);
	
	$.ajax({
		type : "POST",
		url : "/test.formtest",
		dataType : "json",
		beforeSend : function(xhr){
			xhr.setRequestHeader("Accept","application/json");
			xhr.setRequestHeader("Content","application/json");
		},
		data : params,
		success : function(result){
			alert(result.id);
			alert(result.pwd);
		},
		error : function(xhr,status,e){
			alert("에러 :" + e);
		},
		done : function(e){
			
		}
		
	});
});

</script>
</body>
</html>