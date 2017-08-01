<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.UserInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=rootPath %>/ui/board.css"/>
</head>
<body>

 <div class="container">
      <div class="starter-template">
<table class='table table-bordered table-hover'>
<thead>
<tr>
<td align='center'>ID</td>
<td align='center'>작성자</td>
<td align='center'>나이</td>
<td align='center'>주소</td>
<td align='center'>핸드폰번호</td>
</tr>
</thead>
<tr>
<td align='center' ><%=userId %></td>
<td align='center'><%=userName %></td>
<td align='center'><%=age %></td>
<td align='center'><%=address %></td>
<td align='center'><%=hp1 %>-<%=hp2 %>-<%=hp3 %></td>
</tr>
</table>

</div>
</div>
</body>
</html>