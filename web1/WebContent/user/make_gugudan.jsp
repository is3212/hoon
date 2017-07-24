<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String guCnt = request.getParameter("gucnt"); //자동으로 톰캣에서 가져온다, null  값이면 서버오류 why? null값을 integer로 못한다
		if (guCnt == null || guCnt.equals("")) {
			out.println("null값이 들어갔습니다.<br/>");
			out.println("값을 입력하시오");
		} else {
			out.println(guCnt + "X" + guCnt + "단을 생성할게요<br/>");
			int maxNum = Integer.parseInt(guCnt);
			String result = "<table border='1'>";
			for (int i = 1; i <= maxNum; i++) {
				result += "<tr>";
				for (int j = 1; j <= maxNum; j++) {
					result += "<td>" + i + "*" + j + "=" + (i * j) + "</td>";
				}
				result += "</tr>";
			}
			result += "</table>";
			out.println(result);
		}
%>
<form action="/user/make_gugudan.jsp">
		구구단 생성갯수 : <input type="text" name="gucnt" /><br /> 
		<input type="submit" value="생성" />
	</form>
</body>
</html>