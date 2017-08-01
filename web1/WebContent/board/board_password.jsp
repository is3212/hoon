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
<link rel="stylesheet" href="<%=rootPath %>/ui/board.css"/>
</head>
<body>
	<%
	int pBinum=Integer.parseInt(request.getParameter("binum"));
	Connection con=null;
	PreparedStatement ps=null;
	int binum=0;
	String bititle="";
	String bicontent="";
	String bipwd="";
	String creusr="";
	String credat="";
	try{
		con = DBConn2.getCon();
		String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info where binum=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,pBinum);
		ResultSet rs = ps.executeQuery();
		rs.last();
		int rowCnt = rs.getRow();
		if(rowCnt==0){
	%>
	<script>
	alert("<%=pBinum%>번 게시물은 이미 지워졌습니다.");
	history.back();
	</script>
	<%
	}
	rs.beforeFirst();
	while(rs.next()){
		binum = rs.getInt("binum");
		bititle = rs.getString("bititle");
		bicontent = rs.getString("bicontent");
		creusr = rs.getString("creusr");
		credat = rs.getString("credat");
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
	
	
	<div class="container">
	<div class="starter-template">
<table border='1' class='table table-bordered table-hover'>
<thead>
<tr>
<td colspan='2' align='center'>==게시글 비밀번호 확인==</td>
</tr>
</thead>
<tr>
<td align='center'>번호</td>
<td align='center'><%=binum %></td>
</tr>
<tr>
<td align='center'>제목</td>
<td align='center'><%=bititle %></td>
</tr>
<tr>
<td align='center'>내용</td>
<td align='center'><%=bicontent %></td>
</tr>
<tr>
<td align='center'>글쓴이</td>
<td align='center'><%=creusr %></td>
</tr>
<tr>
<td align='center'>작성날짜</td>
<td align='center'><%=credat %></td>
</tr>
<tr>
<td align='center'>ID</td>
<td align='center'><%=userId %></td>
</tr>
<tr>
<td align='center'>게시글 비밀번호</td>
<td align='center'><input type="password" name="bipwd" id="bipwd" placeholder="비밀번호 입력"/></td>
</tr>
</table>
<input type="button" value="삭제" onclick="deleteBoard()"/> <input type="button" value="수정" onclick="modifyBoard()"/> <input type="button" value="게시판 가기" onclick="doMovePage('board')"/>
<script>
function deleteBoard(){
	var bipwd=document.getElementById("bipwd").value;
	location.href="<%=rootPath%>/board/board_delete.jsp?binum=<%=binum%>&bipwd=" + bipwd;
}
function modifyBoard(){
	var pwdbi=document.getElementById("bipwd").value;
	location.href="<%=rootPath%>/board/board_update.jsp?binum=<%=binum%>&bipwd=" + pwdbi;
}
</script>
</div>
</div>
</body>
</html>