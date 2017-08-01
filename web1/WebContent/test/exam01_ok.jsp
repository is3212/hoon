<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.*" %>
<%
String test1=request.getParameter("id");
String test2=request.getParameter("name");
String test3=request.getParameter("age");
String test4=request.getParameter("address");
String test5=request.getParameter("address2");
String test6=request.getParameter("hp1");
String test7=request.getParameter("hp2");
String test8=request.getParameter("hp3");
String test9=request.getParameter("zipcode");
String test10=request.getParameter("password");


Map<String, String[]> map= request.getParameterMap();  //?뒤에 값이 key값이고 =뒤에가 value값으로 들어온다.
Iterator <String> it=map.keySet().iterator();      //map의 keyset()을 호출해서 호출된 값을 iterator에 담아
while(it.hasNext()){                                                          //while 안에서 iterator의 받은 모든 값을 출력함, hasNext : 다음 값이 있으면 true
	String name=it.next();                                                //모든 값들을 받아온다.
	String value=request.getParameter(name);
	out.println("입력하신" + name + "의 값은 " + value + " 입니다.<br/>");
}
%>