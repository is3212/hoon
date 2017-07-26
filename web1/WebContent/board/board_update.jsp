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
String uppwd=request.getParameter("bipwd");
if(uppwd.equals(boardPwd)){

String uptitle=request.getParameter("bititle");
String upcontent=request.getParameter("bicontent");

if(uptitle!=null&&upcontent!=null){
BoardInfo bi=new BoardInfo();
bi.setBoardTitle(uptitle);
bi.setBoardContent(upcontent);

Connection con=null;
PreparedStatement ps=null;
try{
	con = DBConn2.getCon();
	String sql="update board_info set bititle=?, bicontent=?, credat=now()";
	ps=con.prepareStatement(sql);
	ps.setString(1, bi.getBoardTitle());
	ps.setString(2, bi.getBoardContent());
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
}else{
	String result="비밀번호가 틀렸습니다.";
}
%>
</body>
<table border='1'>
<tr>
<td colspan="2"><p align="center"> = 게시글 수정 = </p></td>
</tr>
<tr>
<td align="center">제목</td>
<td><input input type="text" name="bititle"/></td>
</tr>
<tr>
<td align="center">내용</td>
<td><input input type="text" name="bicontent"/></td>
</tr>
<td colspan="2" align="center"> <input type="button" value="수정" onclick="doMovePage('board')"/></td>
</tr>
</table>
</html>