<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.BoardInfo"%>
<%@ page import="com.test.dto.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=rootPath %>/ui/board.css"/>
</head>
<body>
<%
int pBinum = Integer.parseInt(request.getParameter("binum"));
String pBiPwd = request.getParameter("bipwd");
Connection con = null;
PreparedStatement ps = null;
int binum = 0;
String bititle = "";
String bicontent = "";
String bipwd = "";
String creusr = "";
String credat = "";
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
		bipwd = rs.getString("bipwd");
		if(!bipwd.equals(pBiPwd)){
%>
			<script>
				alert("<%=pBinum%>번 게시물은 비밀번호가 틀렸습니다.");
				history.back();
			</script>
<%
		}
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
<form action="<%=rootPath %>/board/board_update_ok.jsp"/>
<table border='1' class='table table-bordered table-hover'>
<thead>
<tr>
<td align="center" colspan="2">게시판 글쓰기</td>
</tr>
</thead>
<tr>
<td align="center">작성자</td>
<td><input type="text"  name="creusr" id="creusr" value="<%=userName%>" size="10" maxlength="8"/></td>
</tr>
<tr>
<td align="center">제목</td>
<td><input input type="text" name="bititle" id="bititle" value="<%=bititle%>" size="30"/></td>
</tr>
<tr>
<td align="center">내용</td>
<td><textarea name="bicontent" rows="10" cols="100"/ value="<%=bicontent%>"/></textarea></td>
</tr>
<tr>
<td align="center">게시글 비밀번호</td>
<td><input type="password" name="bipwd" id="bipwd" value="<%=bipwd%>" size="15"/></td>
</tr>
</table>
<td colspan="2" align="center"> <input type="submit" value="수정" /> <input type="hidden" value="<%=binum%>" name="binum"/></td>
</form>
</div>
</div>
</body>
</html>