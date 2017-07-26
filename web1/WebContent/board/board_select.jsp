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
	
	Connection con=null;
	PreparedStatement ps=null;
	
	try{
	con=DBConn2.getCon();
	String sql = "select binum,bititle,bicontent,bipwd,creusr,credat from board_info";
    ps=con.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    String tableStr="<table border='1'>";
    tableStr+="<tr>";
    tableStr+="<td colspan='6' align='center'> = 게시판 = </td>";
    tableStr+="</tr>";
    tableStr+="<tr>";
    tableStr+="<td align='center'>번호</td>";
    tableStr+="<td align='center'>제목</td>";
    tableStr+="<td align='center'>내용</td>";
    tableStr+="<td align='center'>작성자</td>";
    tableStr+="<td align='center'>작성날짜</td>";
    tableStr+="<td align='center'>게시글 수정</td>";
    tableStr+="</tr>";
	while(rs.next()){
	    tableStr+="<tr>";
	    tableStr+="<td align='center'>" + rs.getString("binum") + "</td>";
	    tableStr+="<td align='center'>" + rs.getString("bititle") + "</td>";
	    tableStr+="<td align='center'>" + rs.getString("bicontent") + "</td>";
	    tableStr+="<td align='center'>" + rs.getString("creusr") + "</td>";
	    tableStr+="<td align='center'>" + rs.getString("credat") + "</td>";
	    tableStr+="<td><input type='button' value='게시글 수정' onclick='doMovePage(\"password\")''/></td>";
	    tableStr+="</tr>";
	    session.setAttribute("bipwd",  rs.getString("bipwd"));
	}
	tableStr+="</table>";
	out.println("====" + userId + "==== 님이 접속하였습니다.");
	out.println(tableStr);
}catch (Exception e) {
	System.out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps=null;	
	}if(con!=null){
	DBConn2.closeCon();
	}
}
%>
<input type="button" value="게시글 작성" onclick="doMovePage('signin')"/>
<input type="button" value="메인가기" onclick="doMovePage('main')"/>
</body>
</html>