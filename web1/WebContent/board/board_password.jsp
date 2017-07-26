<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.BoardInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	%>
<form action="<%=rootPath %>/board/board_update.jsp">
<fieldset>
<legend>게시글 비밀번호 확인</legend>
<label>아이디 : </label>
<input type="text" value="<%=userName%>"/><br/>
<label>게시글 비밀번호 : </label>
<input type="password" name="bipwd" placeholder="비밀번호 입력"/><br/>
<input type="submit" value="확인"/>
</fieldset>
</form>
</body>
</html>