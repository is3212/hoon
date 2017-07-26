<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.UserInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>

	//var setObj;
	//var loopCnt = 0;
	function doLogout() {
		location.href = "/user/login_ok.jsp";
	}
	//function doStartTimer() {
	//	setObj = setInterval(function() {
		//	if (loopCnt == 10) {
				//clearInterval(setObj);
		//	} else {
			//	loopCnt++;
			//	alert(loopCnt + "번 안녕하세요");
		//	}
	//	}, 1000);
//	}
	//function doStopTimer() {
	//	clearInterval(setObj);
//	}

</script>
<body>
	<%
		if (login) {
			out.println("현재시간 : " + toDateStr);
			out.println("<br/>");
			out.println(userId + "님 환영해요");
			out.println("<br/>");
			out.println("==" + userId + "님의 정보==");
			out.println("<br/>");
			out.println("성명 : " + userName);
			out.println("<br/>");
			out.println("나이 : " + age);
			out.println("<br/>");
			out.println("주소 : " + address);
			out.println("<br/>");
			out.println("전화번호 : " + hp1 + "-" + hp2 + "-" + hp3);
			out.println("<br/>");
			out.println("<input type='button' value='로그아웃' onclick='doLogout()'/>");
			out.println("<input type='button' value='게시판가기' onclick='doMovePage(\"board\")'/>");

		} else {
	%>
	<form action="<%=rootPath %>/user/login_ok.jsp">
		ID : <input type="text" name="id" /><br /> PWD : <input type="text"
			name="pwd" /><br /> <input type="submit" value="로그인" />
	</form>
	<%
		}
	%>
</body>
</html>