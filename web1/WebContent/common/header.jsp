<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%!          //! :  ! 이후로는 자바다 jsp가 아니다. 함수를 만들수있다.
public void printStr(String str){
	System.out.println("adsfsfad");
}
%>
<%

String userId=(String) session.getAttribute("useid");
String userName="";
int age=0;
String address="";
String hp1="";
String hp2="";
String hp3="";
boolean login=false;
if(userId!=null){
	userName=(String) session.getAttribute("username");
	 age=(Integer) session.getAttribute("age");
	 address=(String) session.getAttribute("address");
	 hp1=(String) session.getAttribute("hp1");
	 hp2=(String) session.getAttribute("hp2");
	 hp3=(String) session.getAttribute("hp3");
	login=true;
}
String rootPath=request.getContextPath();
Date toDate=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
String toDateStr=sdf.format(toDate);
String init=request.getParameter("init");
String defaultUrl="";
if(init==null&&!login){
defaultUrl=rootPath + "/user/login.jsp?init=1";
response.sendRedirect(defaultUrl);
}
%>
<script src="<%=rootPath %>/js/jquery-3.2.1.js"></script>
<script>
var rootPath="<%=rootPath%>";

function doMovePage(pageId)
{
   var url = "";
   if(pageId == "board")
   {
      url = rootPath + "/board/board_select.jsp";
   }else if(pageId=="main"){
	url=rootPath+"/";
   }else if(pageId=="signin"){
	   url=rootPath+"/board/board_signin.jsp";
   }else if(pageId=="password"){
	   url=rootPath+"/board/board_password.jsp";
   }else if(pageId=="modify"){
	   url=rootPath+"/board/board_update.jsp";
   }
   location.href=url;
}

</script>
</html>