<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="com.test.common.DBConn2" %>
<%@ page import="com.test.dto.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String upNum=request.getParameter("binum");
String upPwd=request.getParameter("bipwd");
String sql = "delete from  board_info";
sql += " where binum=? and bipwd=?";

Connection con = null;
PreparedStatement ps = null;
String result = "삭제 안된거 같은디?";
int resultNum =0;
try{
	con = DBConn2.getCon();
	ps = con.prepareStatement(sql);
	ps.setString(1, upNum);
	ps.setString(2, upPwd);
	resultNum = ps.executeUpdate();
	if(resultNum==1){
		result = "삭제 됬구먼!!!";
		con.commit();
	}
}catch(Exception e){
	System.out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps = null;
	}
	DBConn2.closeCon();
}
%>
<script>
alert("<%=result%>");
if(<%=resultNum%> == 1){
	location.href= "<%=rootPath%>/board/board_select.jsp";
}else{
	history.back();
}
</script>
</body>
</html>