<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.sql.*" %>                     <!-- java.sql의 어떠한 sql을 이용할 수 있다. -->
	<%@ page import="com.test.common.DBConn2" %>          <!-- import 써줘야한다. -->
	<%@ page import="com.test.dto.UserInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");

String result="";
if(id!=null && pwd!=null){
UserInfo ui=new UserInfo();
ui.setUserId(id);
ui.setUserPwd(pwd);

Connection con = null;
PreparedStatement ps = null;

try{
	con = DBConn2.getCon();
	String sql = "select username,age,address,hp1,hp2,hp3,userpwd from user_info where useid=?";
	ps = con.prepareStatement(sql);
	ps.setString(1, ui.getUserId());
	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		String userpwd = rs.getString("userpwd");
		String userName=rs.getString("username");
		int age=rs.getInt("age");
		String address=rs.getString("address");
		String hp1=rs.getString("hp1");
		String hp2=rs.getString("hp2");
		String hp3=rs.getString("hp3");
		if(userpwd.equals(ui.getUserPwd())){
			result="로그인 성공";
			session.setAttribute("useid", ui.getUserId());              //세션,    id키값에 값을 넣는다.
			session.setAttribute("username", userName);
			session.setAttribute("age", age);
			session.setAttribute("address", address);
			session.setAttribute("hp1", hp1);
			session.setAttribute("hp2", hp2);
			session.setAttribute("hp3", hp3);
		}else{
		result="비밀번호 틀렸다";
	}
	}
}catch(Exception e){
	System.out.println(e);
}
if(result.equals("")){
	result="그런 아이디 없음";
}
out.print(result);
}
else{
	session.invalidate();  //로그아웃 , 세션 초기화
}
%>
<script>
var result="<%=result%>";
alert(result);
location.href="/user/login.jsp";
</script>
</body>
</html>