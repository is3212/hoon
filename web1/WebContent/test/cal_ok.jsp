<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    	<%@ page import="org.json.simple.JSONObject"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.*"%>
<%@page import="com.test.common.DBConn2" %>

<%
JSONObject j= new Gson().fromJson(request.getReader(), JSONObject.class);
String num1Str=(String)j.get("num1");
String op=(String)j.get("op");
String num2Str=(String)j.get("num2");
int num1=Integer.parseInt(num1Str);
int num2=Integer.parseInt(num2Str);
int result=0;

if(op.equals("+")){
	result=num1+num2;

}else if(op.equals("-")){
	result=num1-num2;

}else if(op.equals("*")){
	result=num1*num2;

}else if(op.equals("/")){
	result=num1/num2;
}
Connection con = null;
PreparedStatement ps=null;
int insertResult=0;

try{
	con=DBConn2.getCon();
	String sql="insert into cal(num1,op,num2,result) values(?,?,?,?)";
	ps=con.prepareStatement(sql);
	ps.setInt(1,num1);
	ps.setString(2,op);
	ps.setInt(3,num2);
	ps.setInt(4,result);
	
	insertResult=ps.executeUpdate();
	if(insertResult==1){
		con.commit();
	}
	
}catch(Exception e){
	out.println(e);
}finally{
	ps.close();
	DBConn2.closeCon();
}
HashMap<String, Integer>  hm=new HashMap<String, Integer>();
hm.put("msg",result);
hm.put("insert",insertResult);
String json=new Gson().toJson(hm);
out.write(json);

%>