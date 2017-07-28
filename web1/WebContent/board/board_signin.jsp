<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.sql.*" %>
    <%@ page import="com.test.common.DBConn2" %>         
	<%@ page import="com.test.dto.BoardInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String title=request.getParameter("bititle");
String content=request.getParameter("bicontent");
String pwd=request.getParameter("bipwd");



if(title!=null&&content!=null&&pwd!=null){
BoardInfo bi=new BoardInfo();
bi.setBoardTitle(title);
bi.setBoardContent(content);
bi.setBoardPwd(pwd);
bi.setBoardUser(userName);


Connection con = null;
PreparedStatement ps=null;
try{
con=DBConn2.getCon();
String sql="insert into board_info(bititle,bicontent,bipwd,creusr,credat)";
	sql+=" values(?,?,?,?,now())";
	
	ps=con.prepareStatement(sql);
	ps.setString(1, bi.getBoardTitle());
	ps.setString(2, bi.getBoardContent());
	ps.setString(3, bi.getBoardPwd());
	ps.setString(4, bi.getBoardUser());
	int result=ps.executeUpdate();
	if(result==1){
		con.commit();
	}
}catch(Exception e){
System.out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps=null;
	}if(con!=null){
		DBConn2.closeCon();
	}
}
}
%>
<jsp:include page="/common/top.jsp" flush="false">
<jsp:param value="<%=login %>" name="login"></jsp:param>
</jsp:include>
	<div class="container">
	<div class="starter-template">
<form action="<%=rootPath %>/board/board_signin.jsp">
<table border='1' class='table table-bordered table-hover'>
<tr>
<td colspan="2"><p align="center"> = 게시판 작성 = </p></td>
</tr>
<tr>
<td align="center">제목</td>
<td><input input type="text" name="bititle"/></td>
</tr>
<tr>
<td align="center">내용</td>
<td><input input type="text" name="bicontent"/></td>
</tr>
<tr>
<td align="center">비밀번호</td>
<td><input type="password" name="bipwd"/></td>
</tr>
<tr>
<td align="center">작성자</td>
<td><input type="text" value="<%=userName%>"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="작성"/> <input type="button" value="게시판가기" onclick="doMovePage('board')"/></td>
</tr>
</table>
</form>
</div>
</div>
</body>
</html>