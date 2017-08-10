<%@include file="/common/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var testParam={};
testParam["giNum"]="1"; //dto 키값의 value 값 설정
testParam["giName"]="상품";
testParam["giDesc"]="상품설명";
testParam["viNum"]="1";
testParam["viName"]="회사명";
function callback(result){
	alert(result.giDesc);
}
goPage(testParam,"/test.goods",callback);
</script>
</body>
</html>