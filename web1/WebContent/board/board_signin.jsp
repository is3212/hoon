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
<link rel="stylesheet" href="<%=rootPath %>/ui/board.css"/>
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
	<div class="container">
	<div class="starter-template">
<form action="<%=rootPath %>/board/board_signin.jsp">
<table border='1' class='table table-bordered table-hover'>
<thead>
<tr>
<td align="center" colspan="2">게시판 글쓰기</td>
</tr>
</thead>

<tr>
<td>작성자</td>
<td><input type="text" value="<%=userName%>" size="10" maxlength="8"/></td>
</tr>
<tr>
<td>제목</td>
<td><input type="text" name="bititle" size="30"/></td>
</tr>
<tr>
<td>내용</td>
<td><textarea name="bicontent" rows="10" cols="100"/></textarea></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="password" name="bipwd" size="15"/></td>
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