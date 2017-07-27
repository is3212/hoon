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
<fieldset>
<legend>게시글 비밀번호 확인</legend>
<label>번호 : </label>
<input type="text" value="<%=binum%>"/><br/>
<label>제목 : </label>
<input type="text" value="<%=bititle%>"/><br/>
<label>내용 : </label>
<input type="text" value="<%=bicontent%>"/><br/>
<label>글쓴이 : </label>
<input type="text" value="<%=creusr%>"/><br/>
<label>작성날짜 : </label>
<input type="text" value="<%=credat%>"/><br/>
<label>아이디 : </label>
<input type="text" value="<%=userId%>"/><br/>
<label>게시글 비밀번호 : </label>
<input type="password" name="bipwd" id="bipwd" placeholder="비밀번호 입력"/><br/>
<input type="button" value="삭제" onclick="deleteBoard()"/> <input type="button" value="수정" onclick="modifyBoard()"/> <input type="button" value="게시판 가기" onclick="doMovePage('board')"/>
</fieldset>
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
</body>
</html>